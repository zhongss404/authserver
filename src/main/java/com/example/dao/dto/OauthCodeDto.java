package com.example.dao.dto;

/**
 * Created by dashuai on 2017/11/22.
 */
public class OauthCodeDto extends BaseDto {

    private String clientId;

    private String userName;

    private String code;

    public OauthCodeDto() {
    }

    public OauthCodeDto(String userName, String code) {
        this.userName = userName;
        this.code = code;
    }

    public OauthCodeDto(String clientId, String userName, String code) {
        this.clientId = clientId;
        this.userName = userName;
        this.code = code;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
