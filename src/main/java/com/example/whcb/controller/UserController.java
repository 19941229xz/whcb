package com.example.whcb.controller;

import com.example.base.BaseController;
import com.example.base.BaseResponse;
import com.example.common.HttpCode;
import com.example.common.MyException;
import com.example.common.PageParam;
import com.example.whcb.model.Param;
import com.example.whcb.model.User;
import com.example.whcb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "user",description="这是一个用户数据模块")
@RestController
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired
    UserService userSevice;

//    @RequestMapping(method=RequestMethod.POST)
    @PostMapping
    @Override
    public Object insert(@RequestBody User user) {
        return BaseResponse.success(userSevice.insert(user));
    }

    @DeleteMapping("/{uId}")
    public Object delete(@PathVariable("uId") int uId) {
        User user = new User();
        user.setUId(uId);
        return BaseResponse.success(userSevice.delete(user));
    }

    @PutMapping
    @Override
    public Object update(@RequestBody User user) {

        User user1 = userSevice.update(user);

        return user1!=null?BaseResponse.success(user1):BaseResponse.fail(null).msg("修改失败");
    }


    @GetMapping("/{uId}")
    public Object getById(@PathVariable("uId") int uId){
            User user = new User();
            user.setUId(uId);
         return BaseResponse.success(userSevice.getById(user));
    }

    @ApiOperation(value = "这是一个获取所有用户的接口",consumes = "json格式",produces = "json格式")
    @PostMapping("/searchWithPage")
    @ApiResponse(code = 404,message = "未查询到数据")
    public Object search(@RequestBody @ApiParam(value = "传递用户查询参数") PageParam<User> pageParam) {


        return BaseResponse.success(userSevice.searchWithPage(pageParam));
    }


    @GetMapping("/showActiveProfile")
    public Object showActiveProfile(){


//        throw new ArithmeticException();
        System.out.println(0/0);

        return "test";
    }

    @PostMapping("/testParamWrap")
    public Object testParamWrap(@RequestBody @Valid Param param){

        System.out.println(param.getJack123());


        return BaseResponse.success("ok");
    }


}
