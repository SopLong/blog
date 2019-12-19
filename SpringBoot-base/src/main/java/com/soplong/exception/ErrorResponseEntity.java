package com.soplong.exception;

public enum ErrorResponseEntity {
    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(400, "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401, "请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!");

    private int code;

    private String messag;

    ErrorResponseEntity(int code, String messag) {
        this.code = code;
        this.messag = messag;
    }

    public int getCode() {
        return code;
    }

    public String getMessag() {
        return messag;
    }
}
