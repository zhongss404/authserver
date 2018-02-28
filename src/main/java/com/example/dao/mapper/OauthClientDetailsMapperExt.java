package com.example.dao.mapper;

public interface OauthClientDetailsMapperExt {

    String getSecret(String client_id);

    Integer getExpireTime(String client_id);
}