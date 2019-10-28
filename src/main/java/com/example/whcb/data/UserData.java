package com.example.whcb.data;

import com.example.whcb.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {




    public static List<User> userList;

    static{

        userList = new ArrayList<User>();

        User user = new User();

        user.setAge(18);
        user.setGender(0);
        user.setPassword("123");
        user.setUserName("tom");

        userList.add(user);
    }


}
