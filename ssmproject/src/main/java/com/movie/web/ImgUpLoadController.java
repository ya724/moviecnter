package com.movie.web;

import com.movie.untils.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ImgUpLoadController {

    @ResponseBody
    @RequestMapping("/Imgupload")
    public CommonResult ImgLoad(MultipartFile file, HttpServletRequest request){
        //获取上传照片文件的原名字
        String originalFilename = file.getOriginalFilename();
        //获取照片后缀名
        String extendfilename = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成随机不可重复的照片名
        String newfilename = UUID.randomUUID().toString() + extendfilename;
        //获取照片全路径
        String realPath = request.getServletContext().getRealPath("/photo") + "/" + newfilename;

        try {
            //文件上传
            file.transferTo(new File(realPath));
            return new CommonResult(200,"文件上传成功",newfilename);
        } catch (IOException e) {
            e.printStackTrace();
            return new CommonResult(500,"文件上传失败");
        }
    }
}
