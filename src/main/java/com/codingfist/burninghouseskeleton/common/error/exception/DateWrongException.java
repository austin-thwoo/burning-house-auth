package com.codingfist.burninghouseskeleton.common.error.exception;


import com.codingfist.burninghouseskeleton.common.error.model.ErrorCode;

public class DateWrongException extends BusinessException {
    public DateWrongException(String value) {
        super(value, ErrorCode.DATE_WRONG);
    }
}
