package com.example.security.properties;

import com.example.security.domain.ValidateCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by dashuai on 2017/11/18.
 */
@Component
@ConfigurationProperties(prefix = "login.imageCode")
public class ImageCodeProperties extends ValidateCode{
    private int width;

    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
