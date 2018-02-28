package com.example.dao.mapper;

import com.example.dao.domain.User;
import com.example.dao.domain.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperExt {
    User selectByUsername(String username);

    User selectByPhone(String phone);
}