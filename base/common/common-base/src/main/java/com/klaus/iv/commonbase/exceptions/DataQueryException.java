package com.klaus.iv.commonbase.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
class DataQueryException extends RuntimeException {

    private String msg;

    DataQueryException(String msg, Object... params) {
        super(String.format(msg, params));
        this.msg = msg;
    }

    DataQueryException(String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }
}
