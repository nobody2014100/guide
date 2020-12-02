package com.klaus.iv.commonweb.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class DbException extends Exception {
    private String msg;
    private String code;
}
