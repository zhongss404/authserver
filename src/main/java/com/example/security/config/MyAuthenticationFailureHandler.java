package com.example.security.config;

import com.example.security.properties.LoginProperties;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dashuai on 2017/11/8.
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler{

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private LoginProperties loginProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(savedRequest != null){
            String error = exception.getMessage() == null ? "UsernameOrPasswordError": exception.getMessage();
            redirectStrategy.sendRedirect(request,response,loginProperties.getPrefix() + loginProperties.getLoginPage()
                        + "?error=" + error);
        }else{  //发送验证码是ajax请求
            response.getWriter().write("mobileIsNotExists");
        }
    }
}
