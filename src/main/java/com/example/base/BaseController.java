package com.example.base;

public class BaseController<T> {

    BaseService<T> baseService;

    public Object insert(T t){

        return BaseResponse.success(baseService.insert(t));
    }


    public Object delete(T t){

        return BaseResponse.success(baseService.delete(t));
    }


    public Object update(T t){

        return BaseResponse.success(baseService.update(t));
    }



    public Object search(T t){

        return BaseResponse.success(baseService.search(t));
    }



}
