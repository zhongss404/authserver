package com.example.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dashuai on 2017/11/8.
 */
@Configuration
@ConfigurationProperties(prefix = "login")
public class LoginProperties {

    private String prefix;

    private String loginPage;

    private String loginAction;

    private String logoutPage;

    private String logoutAction;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getLoginAction() {
        return loginAction;
    }

    public void setLoginAction(String loginAction) {
        this.loginAction = loginAction;
    }

    public String getLogoutPage() {
        return logoutPage;
    }

    public void setLogoutPage(String logoutPage) {
        this.logoutPage = logoutPage;
    }

    public String getLogoutAction() {
        return logoutAction;
    }

    public void setLogoutAction(String logoutAction) {
        this.logoutAction = logoutAction;
    }
}
