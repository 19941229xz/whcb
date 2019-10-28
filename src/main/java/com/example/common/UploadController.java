package com.example.common;


import com.example.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Api(value = "上传文件模块")
@RestController
@RequestMapping("upload")
public class UploadController {


    @Value("${app.imgPath}")
    public String imgUploadPath;



    @ApiOperation(value = "上传图片接口")
    @PostMapping("/uploadImg")
    public Object uploadImg(@RequestParam(value = "img",required = false) MultipartFile file) {

//        String originName = file.getOriginalFilename();
        if(file!=null){


            File newFile = new File(imgUploadPath+file.getOriginalFilename());

            try {
//                FileCopyUtils.copy((File)file,newFile);
file.transferTo(newFile);


            } catch (IOException e) {
                e.printStackTrace();

                return BaseResponse.fail(new MyException(HttpCode.FAIL)).msg("上传失败");
            }

        }else{
            return BaseResponse.fail(new MyException(HttpCode.FAIL)).msg("上传文件为空");
        }

        return BaseResponse.success(file.getOriginalFilename());

    }



}
