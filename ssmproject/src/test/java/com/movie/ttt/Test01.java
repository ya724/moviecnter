package com.movie.ttt;

import com.movie.bean.Admin;
import com.movie.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test01 {

    @Resource
    AdminService adminService;
    @Test
    public void test1(){
        Admin admin=new Admin("tom","123");
        Admin admin1 = adminService.adminLogin(admin);
        System.out.println(admin1==null?"登陆失败":"登录成功");
    }
}
