package com.klaus.iv.commonweb.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public abstract class BaseException extends RuntimeException {

    public abstract String getCode();
    public abstract String getMsg();

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
