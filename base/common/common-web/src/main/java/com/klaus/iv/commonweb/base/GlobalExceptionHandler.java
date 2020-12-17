package com.klaus.iv.commonweb.base;

import com.klaus.iv.commonweb.R;
import com.klaus.iv.commonweb.constants.ResultStatusCode;
import com.klaus.iv.commonweb.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class, BindException.class,MethodArgumentNotValidException.class})
    public ResponseEntity handleHttpMessageNotReadableException(Exception e) {
        log.error("参数解析失败", e);
        if (e instanceof BindException){
            return R.suc(ResultStatusCode.UNKNOWN_ERROR);
        }
        if (e instanceof HttpMessageNotReadableException){
            return R.suc(ResultStatusCode.UNKNOWN_ERROR);
        }
        if (e instanceof MethodArgumentNotValidException){
            return R.suc(ResultStatusCode.UNKNOWN_ERROR);
        }
        return R.suc(ResultStatusCode.BAD_REQUEST);
    }


    /**
     * 其他全局异常在此捕获
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleException(Throwable e) {
        log.error("服务运行异常", e);
        if (e instanceof BaseException) {
            return R.suc(ResultStatusCode.UNKNOWN_ERROR);
        }
        return R.suc(ResultStatusCode.UNKNOWN_ERROR);
    }

}