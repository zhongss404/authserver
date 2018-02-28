package com.example.security.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by dashuai on 2017/11/17.
 */

public class ValidateCodeException extends AuthenticationServiceException{

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
