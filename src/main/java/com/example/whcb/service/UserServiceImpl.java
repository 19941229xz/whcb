package com.example.whcb.service;


import com.example.common.PageParam;
import com.example.whcb.dao.UserDao;
import com.example.whcb.data.UserData;
import com.example.whcb.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @CachePut(value = "users" , key = "#p0.uId")
    @Override
    public User insert(User user) {

        int num = userDao.insert(user);
//        User user = new User();
//        user.setUId(num);


        return getById(user);
    }

    @Override
    public Object insert(Object o) {
        return null;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @CacheEvict(value = "users" , key = "#p0.uId")
    @Override
    public int delete(User user) {
        return userDao.delete(user);

//        return UserData.userList.remove((User)o)?1:0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @CachePut(value = "users" , key = "#p0.uId")
    @Override
    public User update(User user) {

        int num = userDao.update(user);



        return num==1?userDao.getById(user.getUId()):null;
    }

    @Override
    public List<User> search(Object o) {
        return userDao.getAllUser();
    }

    @Override
    public Object searchWithPage(PageParam<User> pageParam) {

        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());

        for (int i = 0; i < pageParam.getOrderParams().length; i++) {
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }

        List<User> userList = userDao.getAllUser();

        PageInfo<User> res = new PageInfo<User>(userList);

        return res;
    }


    @Cacheable(value = "users", key = "#p0.uId")
    @Override
    public User getById(User user) {

        log.info("走的是数据库查询");

        return userDao.getById(user.getUId());
    }
}
