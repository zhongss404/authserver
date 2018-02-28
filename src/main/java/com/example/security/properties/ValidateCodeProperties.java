package com.example.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dashuai on 2017/11/20.
 */
@Configuration
@ConfigurationProperties(prefix = "login.vCode")
public class ValidateCodeProperties {
    private int expireTime;

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }
}
