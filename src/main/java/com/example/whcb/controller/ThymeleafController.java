package com.example.whcb.controller;

import com.example.common.PageParam;
import com.example.whcb.model.User;
import com.example.whcb.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("thymeleaf")
@Slf4j
public class ThymeleafController {

    @Autowired
    UserService userService;

    @GetMapping("/hello/{name}")
    public String hello(HttpServletRequest request, @PathVariable("name") String name){

        request.setAttribute("name",name);

        return "helloWorld";
    }


    @GetMapping("/userList/{pageNum}/{pageSize}")
    public String hello(HttpServletRequest request,PageParam<User> pageParam){

//        PageParam<User> pageParam = new PageParam<User>();

        pageParam.setOrderParams(new String[]{});

        request.setAttribute("userList",(PageInfo<User>)userService.searchWithPage(pageParam));

        return "userList";
    }



    @GetMapping("/delete/{uId}")
    public String delete(HttpServletRequest request,User user){

        if(userService.delete(user)==1){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("msg","删除失败");
        }


        request.setAttribute("userList",(PageInfo<User>)userService
                .searchWithPage(PageParam.init(1,5)));

        return "redirect:../userList/1/5";
    }

    @GetMapping("/toUpdate/{uId}")
    public String toUpdate(HttpServletRequest request,User user){

    log.info(user.toString());

    User user1 = userService.getById(user);

    log.info(user1.toString());

        request.setAttribute("userData",user1);

        return "updateUser";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request,User user){


        userService.update(user);


        request.setAttribute("userList",(PageInfo<User>)userService
                .searchWithPage(PageParam.init(1,5)));

        return "redirect:userList/1/5";
    }

    @GetMapping("/toInsert")
    public String toInsert(){




        return "insertUser";
    }


    @PostMapping("/insert")
    public String insert(HttpServletRequest request,User user){


        userService.insert(user);


        request.setAttribute("userList",(PageInfo<User>)userService
                .searchWithPage(PageParam.init(1,5)));

        return "redirect:userList/1/5";
    }

}
