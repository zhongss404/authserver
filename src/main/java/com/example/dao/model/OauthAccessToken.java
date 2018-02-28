package com.example.dao.model;

/**
 * Created by dashuai on 2017/11/22.
 */
public class OauthAccessToken {
    private String access_token;

    public OauthAccessToken() {
    }

    public OauthAccessToken(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
