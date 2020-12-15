package com.movie.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("/login")
    public String AdminLogin(){
        return "admin_login";
    }
    /*
    *页面通用跳转
    */
    @RequestMapping("/page_{target}")
    public String CommonJump(@PathVariable("target") String target){
        return target;
    }
}
