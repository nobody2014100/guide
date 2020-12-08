package com.klaus.iv.commonbase.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseException extends RuntimeException {
    private String msg;
    public BaseException(String msg) {
        super(msg);
    }
}
