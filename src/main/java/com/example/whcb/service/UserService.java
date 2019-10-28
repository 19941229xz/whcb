package com.example.whcb.service;

import com.example.base.BaseService;
import com.example.common.PageParam;
import com.example.whcb.model.User;

public interface UserService extends BaseService {


    Object searchWithPage(PageParam<User> pageParam);

    User getById(User user);

    User insert(User user);

    User update(User user);

    int delete(User user);

}
