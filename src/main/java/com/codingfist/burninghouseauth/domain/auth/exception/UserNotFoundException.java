package com.codingfist.burninghouseauth.domain.auth.exception;


import com.codingfist.burninghouseauth.globalCommon.error.exception.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(Long target) {
        super(target + "is not found");
    }
}
