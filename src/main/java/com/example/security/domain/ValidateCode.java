package com.example.security.domain;

import java.time.LocalDateTime;

/**
 * Created by dashuai on 2017/11/18.
 */
public class ValidateCode {

    private String code;

    private int expireIn;

    private LocalDateTime localDateTime;

    public ValidateCode() {
    }

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.localDateTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
