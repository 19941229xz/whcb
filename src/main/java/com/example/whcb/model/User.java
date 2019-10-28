package com.example.whcb.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ApiModel(value = "user" ,description = "用户实体类")
@Data
public class User implements Serializable {


    @ApiModelProperty(value = "用户名" , name = "userName")
    @NotEmpty(message = "param中的user中的 username 不能为空")
    private String userName;

    @ApiModelProperty(value = "密码" , name = "password")
    private String password;

    @ApiModelProperty(value = "年龄" , name = "age")
    private Integer age;

    @ApiModelProperty(value = "性别" , name = "gender")
    private int gender;

    @ApiModelProperty(value = "主键" , name = "uId")
    private int uId;




}
