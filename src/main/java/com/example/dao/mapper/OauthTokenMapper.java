package com.example.dao.mapper;

import com.example.dao.domain.OauthToken;
import com.example.dao.domain.OauthTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthTokenMapper {
    int countByExample(OauthTokenExample example);

    int deleteByExample(OauthTokenExample example);

    int deleteByPrimaryKey(String id);

    int insert(OauthToken record);

    int insertSelective(OauthToken record);

    List<OauthToken> selectByExample(OauthTokenExample example);

    OauthToken selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OauthToken record, @Param("example") OauthTokenExample example);

    int updateByExample(@Param("record") OauthToken record, @Param("example") OauthTokenExample example);

    int updateByPrimaryKeySelective(OauthToken record);

    int updateByPrimaryKey(OauthToken record);
}