package com.klaus.iv.commonweb.exception;

import com.klaus.iv.commonweb.constants.BasicError;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class BizException extends BaseException {

    private String code;
    private String msg;

    public BizException(BasicError basicError) {
        super(basicError.getMsg());
        this.code = basicError.getCode();
    }

    public BizException(BasicError error, Throwable cause) {
        super(error.getMsg(), cause);
        this.code = error.getCode();
    }

}
