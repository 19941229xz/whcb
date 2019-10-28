package com.example.base;

import com.example.whcb.model.User;

import java.util.List;


public interface BaseService<T> {

    T insert(T t);

    int delete(T t);

    int update(T t);

    List<T> search(T t);


}
