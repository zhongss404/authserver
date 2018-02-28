package com.example.security.config;

import com.example.dao.mapper.UserMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dashuai on 2017/11/8.
 */
@Configuration
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapperExt userMapperExt;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.dao.domain.User user = username.matches("\\d+") ? userMapperExt.selectByPhone(username) : userMapperExt.selectByUsername(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new User(username,user.getPassword(),authorities);
    }
}
