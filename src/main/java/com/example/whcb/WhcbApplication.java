package com.example.whcb;

import com.example.base.BaseResponse;
import com.example.common.HttpCode;
import com.example.common.MyException;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.ElementVisitor;

/**
 * 1231231412312312
 */
@RestController
@RequestMapping("test")
@Slf4j
@SpringBootApplication(scanBasePackages = "com.example")
@ControllerAdvice
@MapperScan({"com.example.whcb.dao", "com.example.task"})
@EnableCaching
//@EnableScheduling
public class WhcbApplication {

    @Value("${app.info}")
    private String appInfo;

    public static void main(String[] args) {


        SpringApplication.run(WhcbApplication.class, args);


//        System.out.println(appInfo);

        System.out.println("我改了代码");
        //asdfaf
        //asdfa/
        //       /asdf/asdf/
    }

public void test(){

}


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handleException(Exception e) {
        e.printStackTrace();
        if (e instanceof MyException) {
            return BaseResponse.fail(new MyException(HttpCode.ERROR));
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            return BaseResponse.fail(new MyException(HttpCode.BAD_PARAM).msg(
                    "参数校验错误，错误原因：" + ex.getBindingResult().getFieldError().getDefaultMessage()
            ));
        } else {
            return BaseResponse.fail(new MyException(HttpCode.ERROR));
        }


    }


}
