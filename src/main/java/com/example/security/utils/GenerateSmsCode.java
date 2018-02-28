package com.example.security.utils;

import com.example.security.domain.ValidateCode;
import com.example.security.properties.ValidateCodeProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dashuai on 2017/11/18.
 */
@Component
public class GenerateSmsCode {

    public ValidateCode createCode(int expireTime){
        return new ValidateCode(RandomStringUtils.randomNumeric(6),expireTime);
    }
}
