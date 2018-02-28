package com.example.dao.mapper;

import com.example.dao.domain.OauthCode;
import com.example.dao.domain.OauthCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthCodeMapper {
    int countByExample(OauthCodeExample example);

    int deleteByExample(OauthCodeExample example);

    int deleteByPrimaryKey(String id);

    int insert(OauthCode record);

    int insertSelective(OauthCode record);

    List<OauthCode> selectByExample(OauthCodeExample example);

    OauthCode selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OauthCode record, @Param("example") OauthCodeExample example);

    int updateByExample(@Param("record") OauthCode record, @Param("example") OauthCodeExample example);

    int updateByPrimaryKeySelective(OauthCode record);

    int updateByPrimaryKey(OauthCode record);
}