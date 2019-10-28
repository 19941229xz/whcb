package com.example.common;

import lombok.Data;

@Data
public class MyException extends RuntimeException{



    private int code;

    private String msg;


    public MyException(HttpCode httpCode){

        this.code=httpCode.getCode();
        this.msg=httpCode.getMsg();
    }


    public MyException msg(String msg){
        this.msg=msg;

        return this;
    }


}
