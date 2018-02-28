package com.example.controller;

import com.example.dao.mapper.UserMapperExt;
import com.example.security.config.MyAuthenticationFailureHandler;
import com.example.security.domain.ImageCode;
import com.example.security.domain.ValidateCode;
import com.example.security.exception.ValidateCodeException;
import com.example.security.properties.ImageCodeProperties;
import com.example.security.properties.ValidateCodeProperties;
import com.example.security.utils.GenerateImageCode;
import com.example.security.utils.GenerateSmsCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dashuai on 2017/11/17.
 */
@RestController
@RequestMapping(value = "/code")
public class CodeController {

    @Autowired
    private ImageCodeProperties imageCodeProperties;
    @Autowired
    private ValidateCodeProperties validateCodeProperties;
    @Autowired
    private GenerateImageCode generateImageCode;
    @Autowired
    private GenerateSmsCode generateSmsCode;
    @Autowired
    private UserMapperExt userMapperExt;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @RequestMapping(value = "/imageCode")
    public void generateIMageCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("image/jpeg");
        // 禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();
        // 1、生成图片
        ImageCode imageCode = generateImageCode.createCode(imageCodeProperties.getWidth(),imageCodeProperties.getHeight(),validateCodeProperties.getExpireTime());
        // 2、将vCode写入session
        session.setAttribute("vCode",imageCode.getCode());
        session.setAttribute("expire_time", imageCode.getLocalDateTime());
        // 3、将图片以流的形式写入到浏览器
        ImageIO.write(imageCode.getBufferedImage(),"png",response.getOutputStream());
    }

    @RequestMapping(value = "/smsCode")
    public void generateSmsCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ValidateCode validateCode = generateSmsCode.createCode(validateCodeProperties.getExpireTime());
        String mobile = request.getParameter("mobile");
        try{
            if(userMapperExt.selectByPhone(mobile) == null){
                throw new ValidateCodeException("mobileIsNotExists");
            }
            HttpSession session = request.getSession();
            session.setAttribute("smsCode",validateCode.getCode());
            session.setAttribute("mobile",mobile);
            System.out.println("向" + mobile + "发送验证码" + validateCode.getCode());
        }catch(ValidateCodeException e){
            myAuthenticationFailureHandler.onAuthenticationFailure(request,response,e);
        }
    }
}
