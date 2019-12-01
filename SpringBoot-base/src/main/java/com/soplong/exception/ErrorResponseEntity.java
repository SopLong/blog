package com.soplong.exception;

public enum ErrorResponseEntity {
    ;

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
