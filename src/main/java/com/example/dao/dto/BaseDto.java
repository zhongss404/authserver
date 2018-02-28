package com.example.dao.dto;

import java.util.UUID;

/**
 * Created by dashuai on 2017/11/22.
 */
public class BaseDto {
    private String id;

    public BaseDto() {
        this.setId(UUID.randomUUID().toString().replaceAll("-","").trim());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
