package com.example.dao.mapper;

import com.example.dao.domain.OauthToken;
import com.example.dao.dto.OauthTokenDto;

public interface OauthTokenMapperExt {

    int insert(OauthTokenDto record);

    OauthToken selectByToken(String token);

    int deleteByToken(String token);
}