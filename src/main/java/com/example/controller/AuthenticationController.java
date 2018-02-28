package com.example.controller;

import com.example.dao.dto.AuthenticationDto;
import com.example.dao.dto.OauthCodeDto;
import com.example.dao.dto.OauthTokenDto;
import com.example.dao.mapper.OauthClientDetailsMapperExt;
import com.example.dao.mapper.OauthCodeMapperExt;
import com.example.dao.mapper.OauthTokenMapperExt;
import com.example.dao.mapper.UserMapperExt;
import com.example.dao.model.OauthAccessToken;
import com.example.exception.MyException;
import com.example.security.config.MyAuthenticationFailureHandler;
import com.example.util.Base64Utils;
import com.example.util.GenerateCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by dashuai on 2017/11/8.
 */
@RestController
@RequestMapping(value = "/oauth")
public class AuthenticationController {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    private OauthCodeMapperExt oauthCodeMapperExt;
    @Autowired
    private OauthClientDetailsMapperExt oauthClientDetailsMapperExt;
    @Autowired
    private OauthTokenMapperExt oauthTokenMapperExt;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserMapperExt userMapperExt;


    @RequestMapping(value = "/authorize",method = RequestMethod.GET)
    public void authorize(AuthenticationDto authenticationDto, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = GenerateCode.getCode(6);
        String contextName = SecurityContextHolder.getContext().getAuthentication().getName();
        String username = contextName.matches("\\d+") ? userMapperExt.selectByPhone(contextName).getUsername() : contextName;
        oauthCodeMapperExt.insert(new OauthCodeDto(authenticationDto.getClient_id(),username,code));
        String uri = authenticationDto.getRedirect_uri() + "&code=" + code + "&state=" + authenticationDto.getState();
        redirectStrategy.sendRedirect(request,response,uri);
    }

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public String token(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            validateUri(request);
        }catch (MyException e){
            myAuthenticationFailureHandler.onAuthenticationFailure(request,response,e);
        }
        String token = UUID.randomUUID().toString();
        OauthCodeDto oauthCodeDto = oauthCodeMapperExt.selectByCode(request.getParameter("code"));
        long expireTime = new Date().getTime()/1000 + oauthClientDetailsMapperExt.getExpireTime(oauthCodeDto.getClientId());
        oauthTokenMapperExt.insert(new OauthTokenDto(token,oauthCodeDto.getUserName(),new Date(expireTime * 1000)));
        return objectMapper.writeValueAsString(new OauthAccessToken(token));
    }

    private void validateUri(HttpServletRequest request) throws JsonProcessingException {
        String[] data = new String(Base64Utils.decodeBase64(request.getHeader("Authorization").replace("Basic","").trim())).split(":");
        if(!oauthClientDetailsMapperExt.getSecret(data[0]).equals(data[1])){
            throw new MyException("客户端不存在");
        }
    }
}
