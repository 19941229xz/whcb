package com.example.whcb.dao;

import com.example.whcb.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserDao {



//    @Select("select * from user")
    public List<User> getAllUser();


    @Update("update user set userName = #{userName} , password=#{password} where uId = #{uId}")
    public int update(User user);

//    @Insert("insert into user(uId,userName,password)values(#{uId},#{userName},#{password})")
    public int insert(User user);

    @Delete("delete from user where uId=#{uId}")
    public int delete(User user);

    @Select("select * from user where uId = #{uId}")
    public User getById(int uId);


}
