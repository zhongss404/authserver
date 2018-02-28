package com.example.dao.mapper;

import com.example.dao.dto.OauthCodeDto;

public interface OauthCodeMapperExt {

    int insert(OauthCodeDto record);

    /**
     * 通过code确定username
     */
    OauthCodeDto selectByCode(String code);

    int deleteByUsername(String username);
}