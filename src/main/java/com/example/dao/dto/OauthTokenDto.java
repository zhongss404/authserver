package com.example.dao.dto;

import java.util.Date;

public class OauthTokenDto extends BaseDto{

    private String token;

    private String userName;

    private Date expireTime;

    public OauthTokenDto() {
    }

    public OauthTokenDto(String token, String userName, Date expireTime) {
        this.token = token;
        this.userName = userName;
        this.expireTime = expireTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}