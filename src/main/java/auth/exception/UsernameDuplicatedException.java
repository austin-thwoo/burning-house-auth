package auth.exception;


import globalCommon.error.exception.BusinessException;
import globalCommon.error.model.ErrorCode;

public class UsernameDuplicatedException extends BusinessException {
    public UsernameDuplicatedException(String value) {
        super(value, ErrorCode.DUPLICATED_ID);
    }
}
