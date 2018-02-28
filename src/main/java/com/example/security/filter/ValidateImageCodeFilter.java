package com.example.security.filter;

import com.example.security.config.MyAuthenticationFailureHandler;
import com.example.security.properties.LoginProperties;
import com.example.security.exception.ValidateCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by dashuai on 2017/11/17.
 */
@Configuration
public class ValidateImageCodeFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(ValidateImageCodeFilter.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private LoginProperties loginProperties;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException,ValidateCodeException {
        if ("POST".equals(httpServletRequest.getMethod()) && loginProperties.getLoginAction().equals(httpServletRequest.getRequestURI())) {
            try{
                //校验图形验证码,这里会抛出自定义的异常
                validateImageCode(httpServletRequest,httpServletResponse);
            }catch (ValidateCodeException e){
                //通过自定义登录失败处理类处理
                myAuthenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                //｛易错点｝现在图像验证码出现错误,导致登录失败,不需要将filter传递下去
                return;
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private void validateImageCode(HttpServletRequest request,HttpServletResponse response){
        String vCode = request.getSession().getAttribute("vCode").toString();
        LocalDateTime expireTime = (LocalDateTime) request.getSession().getAttribute("expire_time");
        String pageVCode = request.getParameter("validateCode");
        if(StringUtils.isEmpty(vCode) || vCode == null){   //如果session中的vCode值为空
            throw new ValidateCodeException("vCodeIsNull");  //验证码不存在
        }
        if(StringUtils.isEmpty(pageVCode) || pageVCode == null){
            throw new ValidateCodeException("pageVCodeIsNull");  //验证码为空
        }
        if(expireTime.isBefore(LocalDateTime.now())){
            throw new ValidateCodeException("vCodeIsExpired");   //验证码已经过期
        }
        if(!vCode.equalsIgnoreCase(pageVCode)){
            throw  new ValidateCodeException("pageVCodeIsError");   //验证码错误
        }
    }
}
