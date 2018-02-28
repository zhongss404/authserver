package com.example.controller;

import com.example.dao.domain.OauthToken;
import com.example.dao.domain.User;
import com.example.dao.mapper.OauthTokenMapperExt;
import com.example.dao.mapper.UserMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by dashuai on 2017/11/22.
 */
@RestController
@RequestMapping(value = "/resource")
public class ResourceController {

    @Autowired
    private UserMapperExt userMapperExt;
    @Autowired
    private OauthTokenMapperExt oauthTokenMapperExt;

    @RequestMapping(value = "/userInfo")
    public User getUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OauthToken oauthToken;
        String access_token = request.getParameter("access_token");
        if(access_token != null){
            oauthToken = oauthTokenMapperExt.selectByToken(access_token);
            if(oauthToken != null){
                if(new Date().before(oauthToken.getExpireTime())){
                    return userMapperExt.selectByUsername(oauthToken.getUserName());
                }
            }
        }
        return null;
    }
}
