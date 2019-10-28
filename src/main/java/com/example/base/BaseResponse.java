package com.example.base;

import com.example.common.MyException;
import lombok.Data;

@Data
public class BaseResponse {



    private int code;

    private String msg;

    private Object content;



    public static BaseResponse success(Object content){
        BaseResponse baseResponse = new BaseResponse();

        baseResponse.setCode(200);

        baseResponse.setMsg("ok");

        baseResponse.setContent(content);

        return baseResponse;

    }

    public static BaseResponse fail(MyException ex){


        BaseResponse baseResponse = new BaseResponse();

        baseResponse.setMsg(ex.getMsg());
        baseResponse.setCode(ex.getCode());


        return baseResponse;

    }

    public BaseResponse msg(String msg){

        this.msg =  msg;

        return  this;
    }

}
