package com.klaus.iv.commonweb.constants;

import lombok.Getter;

@Getter
public enum  ResultStatusCode implements BasicError{

    OK("0", "OK"),
    HTTP_ERROR_100("100", "1XX错误"),
    HTTP_ERROR_300("300", "3XX错误"),
    HTTP_ERROR_400("400", "4XX错误"),
    HTTP_ERROR_500("500", "5XX错误"),
    SIGN_ERROR("120", "签名错误"),
    TIME_OUT("130", "访问超时"),
    KICK_OUT("300", "您已经在其他地方登录，请重新登录！"),
    BAD_REQUEST("407", "参数解析失败"),
    INVALID_TOKEN("401", "无效的授权码"),
    INVALID_CLIENTID("402", "无效的密钥"),
    REQUEST_NOT_FOUND("404", "访问地址不存在！"),
    METHOD_NOT_ALLOWED("405", "不支持当前请求方法"),
    REPEAT_REQUEST_NOT_ALLOWED("406", "请求重复提交"),
    SYSTEM_ERR("500", "服务器运行异常"),
    UNKNOWN_ERROR("-1", "未知错误"),
    BIND_PHONE("10010", "请绑定手机号"),
    UPLOAD_ERROR("20000", "上传文件异常"),
    INVALID_CAPTCHA("30005", "无效的验证码"),
    USER_FROZEN("40000", "该用户已被冻结");

    private String code;
    private String msg;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultStatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
