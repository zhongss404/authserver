package com.example.dao.dto;

/**
 * Created by dashuai on 2017/11/22.
 */
public class AuthenticationDto {

    private String client_id;    //应用id

    private String redirect_uri;   //跳转的uri

    private String response_type;    //认证类型

    private String state;       //state

    private String code;      //code

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
