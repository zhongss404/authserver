package com.example.security.filter;

import com.example.security.config.MyHttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by dashuai on 2017/11/23.
 */
@Configuration
public class AuthorizeFilter extends OncePerRequestFilter {

    private RequestCache requestCache = new HttpSessionRequestCache();
    @Autowired
    private MyHttpSessionListener myHttpSessionListener;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String uri = httpServletRequest.getRequestURI();
        Map<String,HttpSession> sessionMap = myHttpSessionListener.getSessions();
        if("/oauth/authorize".equals(httpServletRequest.getRequestURI())) {
            SavedRequest savedRequest =  requestCache.getRequest(httpServletRequest,httpServletResponse);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication != null && savedRequest == null&& myHttpSessionListener.getSessions().size() == 0){
                authentication.setAuthenticated(false);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
