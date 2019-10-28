package com.example.whcb.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Param {




    private String param1;

    private String test2;

    private String tom;

    @Size(max = 10 , min = 2,message = "你注册的用户名长度不再2-10之间，请重新注册")
    private String jack123;

    private String str5;


    @Valid
    @NotNull
    private User user;




}
