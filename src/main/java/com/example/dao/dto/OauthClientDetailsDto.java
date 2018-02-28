package com.example.dao.dto;

/**
 * Created by dashuai on 2017/11/22.
 */
public class OauthClientDetailsDto extends BaseDto{
    private String clientId;

    private String clientSecret;

    private Integer expireIn;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }
}
