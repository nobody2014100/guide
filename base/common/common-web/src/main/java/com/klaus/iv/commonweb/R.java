package com.klaus.iv.commonweb;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.klaus.iv.commonweb.constants.BasicError;
import com.klaus.iv.commonweb.constants.ResultStatusCode;
import com.klaus.iv.commonweb.exception.BaseException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "rest请求的返回模型，所有rest正常都返回该类的对象")
public class R<T> {
    @ApiModelProperty(value = "处理结果code", required = true)
    private String code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String msg;
    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public R(String code) {
        this.code = code;
    }
    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseEntity<R> suc() {
        return R.suc(ResultStatusCode.OK);
    }

    public static ResponseEntity<R> suc(Object data) {
        return R.suc(ResultStatusCode.OK, data);
    }

    public static ResponseEntity<R> suc(BasicError statusCode) {
        return suc(statusCode, null);
    }

    public static ResponseEntity<R> suc(BasicError statusCode, Object data) {
        return ResponseEntity.ok(new R(statusCode.getCode(), statusCode.getMsg(), data));
    }

    public static ResponseEntity<R<Object>> fail(BaseException baseException) {
        return fail(baseException, null);
    }

    public static ResponseEntity<R<Object>> fail(BaseException baseException, Object data) {
        return ResponseEntity.ok(new R<Object>(baseException.getCode(), baseException.getMsg(), data));
    }





}
