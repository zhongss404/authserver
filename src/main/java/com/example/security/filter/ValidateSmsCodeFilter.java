package com.example.security.filter;

import com.example.security.config.MyAuthenticationFailureHandler;
import com.example.security.exception.ValidateCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
public class ValidateSmsCodeFilter extends OncePerRequestFilter {

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException,ValidateCodeException {
        if ("POST".equals(httpServletRequest.getMethod()) && "/login_test1".equals(httpServletRequest.getRequestURI())) {
            try{
                //校验手机号
                validateMobile(httpServletRequest,httpServletResponse);
                //校验图形验证码,这里会抛出自定义的异常
                validateSmsCode(httpServletRequest,httpServletResponse);
            }catch (ValidateCodeException e){
                //通过自定义登录失败处理类处理
                myAuthenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                //｛易错点｝现在图像验证码出现错误,导致登录失败,不需要将filter传递下去
                return;
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    /**
     * 校验手机号
     * @param request
     * @param response
     */
    private void validateMobile(HttpServletRequest request,HttpServletResponse response){
        String sessionMobile = (String)request.getSession().getAttribute("mobile");
        String pageMobile = request.getParameter("mobile");
        if(sessionMobile.isEmpty() || sessionMobile == null){
            throw new ValidateCodeException("mobileIsNull");
        }
        if(pageMobile.isEmpty() || pageMobile == null) {
            throw new ValidateCodeException("pageMobileIsNull");
        }
        if(!sessionMobile.equals(pageMobile)){
            throw new ValidateCodeException("pageMobileIsError");
        }
    }

    /**
     * 校验图形验证码
     * @param request
     * @param response
     */
    private void validateSmsCode(HttpServletRequest request,HttpServletResponse response){
        String smsCode = request.getSession().getAttribute("smsCode").toString();
        LocalDateTime expireTime = (LocalDateTime) request.getSession().getAttribute("expire_time");
        String pageVCode = request.getParameter("smsCode");
        if(StringUtils.isEmpty(smsCode) || smsCode == null){   //如果session中的vCode值为空
            throw new ValidateCodeException("vCodeIsNull");
        }
        if(StringUtils.isEmpty(pageVCode) || pageVCode == null){
            throw new ValidateCodeException("pageVCodeIsNull");
        }
        if(expireTime.isBefore(LocalDateTime.now())){
            throw new ValidateCodeException("vCodeIsExpired");
        }
        if(!smsCode.equals(pageVCode)){
            throw  new ValidateCodeException("pageVCodeIsError");
        }
    }

}
