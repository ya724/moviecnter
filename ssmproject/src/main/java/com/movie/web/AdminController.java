package com.movie.web;

import com.movie.bean.Admin;
import com.movie.service.AdminService;
import com.movie.untils.CommonResult;
import com.movie.untils.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Resource
    AdminService adminService;
    @ResponseBody//把返回值自动转换为json格式
    @RequestMapping(value = "/LoginMsg",method = RequestMethod.POST)
    public CommonResult  LoginMsg(Admin admin,String userCode, HttpSession session){
        CommonResult result=null;
        String safeCode = (String) session.getAttribute("safeCode");
        Admin loginadmin = adminService.adminLogin(admin);

        if(loginadmin!=null){
            if(userCode.equalsIgnoreCase(safeCode)){
                String salt="hl123";
                String newpassword = MD5Utils.string2MD5(salt+loginadmin.getAdmin_pwd());
                loginadmin.setAdmin_pwd(newpassword);
                session.setAttribute("loginadmin",loginadmin);
                result=new CommonResult(200,"登录成功");
            }
          else {
              result=new CommonResult(250,"验证码错误");
            }
        }else {
            result=new CommonResult(500,"登录失败!账号或密码错误");
        }
        return result;
    }

    @ResponseBody//把返回值自动转换为json格式
    @RequestMapping(value = "/adminLoginout",method = RequestMethod.POST)
    public CommonResult AdminLoginout(HttpSession session){
        session.invalidate();
        CommonResult commonResult=new CommonResult(200,"注销成功");
        return commonResult;
    }
}
