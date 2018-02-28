package com.example.controller;

import com.example.dao.domain.UserExample;
import com.example.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dashuai on 2017/11/8.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/say")
    @PreAuthorize("hasAuthority('user')")
    public String say(){
        StringBuilder stringBuilder = new StringBuilder();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            stringBuilder.append(((UserDetails)principal).getUsername());
        }else{
            stringBuilder.append(principal.toString());
        }
        return "<center><h2>你好!用户:【" + stringBuilder.toString() + "】</h2></center>";
    }

    @RequestMapping(value = "/query")
    @PreAuthorize("hasAuthority('admin')")
    public List<com.example.dao.domain.User> query(){
       return userMapper.selectByExample(new UserExample());
    }
}
