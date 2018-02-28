package com.example.security.config;

import com.example.mobile.SmsCodeAuthenticationConfig;
import com.example.security.filter.AuthorizeFilter;
import com.example.security.filter.ValidateImageCodeFilter;
import com.example.security.filter.ValidateSmsCodeFilter;
import com.example.security.properties.LoginProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Created by dashuai on 2017/11/8.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//配置安全细节
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginProperties loginProperties;

    //javax.sql.Datasource(包名)
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Autowired
    private ValidateImageCodeFilter validateImageCodeFilter;
    @Autowired
    private ValidateSmsCodeFilter validateSmsCodeFilter;
    @Autowired
    private AuthorizeFilter authorizeFilter;

    @Autowired
    private SmsCodeAuthenticationConfig smsCodeAuthenticationConfig;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);         //设置数据源
//        tokenRepository.setCreateTableOnStartup(true);   //应用启动新建表
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                .addFilterBefore(authorizeFilter,UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validateImageCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validateSmsCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .formLogin()    //定义登录方式为form表单登录
                .loginPage(loginProperties.getLoginPage()) //定义登录页
                //将自定义登录页的action请求注入到UsernamePasswordAuthenticationFilter中
                .loginProcessingUrl(loginProperties.getLoginAction())
                .failureHandler(myAuthenticationFailureHandler)
/*
                .and()
                //.rememberMe()              //启用remember-me
                .tokenRepository(persistentTokenRepository())  //设置token持久化方式
                .tokenValiditySeconds(120)  //设置token过期时间
                .userDetailsService(userDetailsService)    //设置UserDetailsService
*/

                /** 设置请求校验规则 **/
                 .and()
                 .authorizeRequests()
                 //定义哪些请求不需要认证
                 //｛易错点｝这里定义了登录页不需要认证
                 .antMatchers(loginProperties.getLoginPage(),"/code/imageCode","/code/smsCode",
                         "/css/*","/oauth/token","/resource/*").permitAll()
                    //所有的请求需要认证(上述不需要认证的除外)
                 .anyRequest().authenticated()

                    /** 关闭csrf防护 **/
                 .and().csrf().disable()

                 .apply(smsCodeAuthenticationConfig);


        http.logout()
                //触发注销操作的URL
                .logoutUrl("/resource/logout")
                //自定义注销成功处理
                .logoutSuccessHandler(myLogoutSuccessHandler)
                //注销成功后跳转的url
//                .logoutSuccessUrl(loginProperties.getLoginPage())
                //指定是否在注销时让HttpSession无效
                .invalidateHttpSession(true);
    }
}
