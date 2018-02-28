package com.example.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by dashuai on 2017/11/22.
 */
public class MyException extends AuthenticationServiceException{

    public MyException(String message) {
        super(message);
    }
}
