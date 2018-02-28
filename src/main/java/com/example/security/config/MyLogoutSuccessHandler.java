package com.example.security.config;

import com.example.dao.domain.OauthToken;
import com.example.dao.mapper.OauthCodeMapperExt;
import com.example.dao.mapper.OauthTokenMapperExt;
import com.example.dao.model.LogoutStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dashuai on 2017/11/23.
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OauthCodeMapperExt oauthCodeMapperExt;
    @Autowired
    private OauthTokenMapperExt oauthTokenMapperExt;
    @Autowired
    private MyHttpSessionListener myHttpSessionListener;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OauthToken oauthToken;
        String access_token = request.getParameter("access_token");
        if(access_token != null){
            oauthToken = oauthTokenMapperExt.selectByToken(access_token);
            if(oauthToken != null) {
                oauthTokenMapperExt.deleteByToken(oauthToken.getToken());
                oauthCodeMapperExt.deleteByUsername(oauthToken.getUserName());
                myHttpSessionListener.clearSession();
            }
        }
        response.getWriter().write(objectMapper.writeValueAsString(new LogoutStatus(true, "")));
    }
}
