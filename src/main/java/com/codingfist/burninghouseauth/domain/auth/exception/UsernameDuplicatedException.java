package com.codingfist.burninghouseauth.domain.auth.exception;


import com.codingfist.burninghouseauth.globalCommon.error.exception.BusinessException;
import com.codingfist.burninghouseauth.globalCommon.error.model.ErrorCode;

public class UsernameDuplicatedException extends BusinessException {
    public UsernameDuplicatedException(String value) {
        super(value, ErrorCode.DUPLICATED_ID);
    }
}
