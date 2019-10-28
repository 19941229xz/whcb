package com.example.common;

public enum HttpCode {


    SUCCESS(200,"ok"),
    FAIL(500,"请求失败，内部错误"),
    ERROR(550,"服务器异常"),
    ITEM_NOT_FOUND(404,"未查询到数据"),
    BAD_PARAM(503,"参数校验错误")
    ;



    private int code;


    private String msg;


    public int getCode() {
        return this.code;
    }


    public String getMsg() {
        return this.msg;
    }

    HttpCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
