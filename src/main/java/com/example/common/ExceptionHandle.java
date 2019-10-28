package com.example.common;

import com.example.base.BaseResponse;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {



    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handleException(Exception e){
        e.printStackTrace();
        if(e instanceof MyException){
            return BaseResponse.fail(new MyException(HttpCode.ERROR));
        }else{
            return BaseResponse.fail(new MyException(HttpCode.ERROR));
        }



    }



}
