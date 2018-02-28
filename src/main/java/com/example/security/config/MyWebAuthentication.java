package com.example.security.config;

import com.example.security.properties.LoginProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dashuai on 2017/11/8.
 */
@RestController
public class MyWebAuthentication {
    @Autowired
    private LoginProperties loginProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping(value = "/handleLogin")
    public void SendRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception{
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(savedRequest.getRedirectUrl() != null){
            redirectStrategy.sendRedirect(request,response, loginProperties.getLoginPage());
        }
    }
}
