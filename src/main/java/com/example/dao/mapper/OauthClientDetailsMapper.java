package com.example.dao.mapper;

import com.example.dao.domain.OauthClientDetails;
import com.example.dao.domain.OauthClientDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthClientDetailsMapper {
    int countByExample(OauthClientDetailsExample example);

    int deleteByExample(OauthClientDetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(OauthClientDetails record);

    int insertSelective(OauthClientDetails record);

    List<OauthClientDetails> selectByExample(OauthClientDetailsExample example);

    OauthClientDetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OauthClientDetails record, @Param("example") OauthClientDetailsExample example);

    int updateByExample(@Param("record") OauthClientDetails record, @Param("example") OauthClientDetailsExample example);

    int updateByPrimaryKeySelective(OauthClientDetails record);

    int updateByPrimaryKey(OauthClientDetails record);
}