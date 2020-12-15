package com.movie.web;

import com.movie.bean.Users;
import com.movie.dto.TicketDto;
import com.movie.service.BuyTicketService;
import com.movie.service.UsersService;
import com.movie.untils.CommonResult;;
import com.movie.untils.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UsersController {

    @Resource
    UsersService usersService;

    @Resource
    BuyTicketService buyTicketService;
    @ResponseBody
    @RequestMapping("/userregister")
    public CommonResult UserRegister(Users users) {
        CommonResult commonResult;
        String salt="hl123";
        users.setImg_url("/img/ht.jpg");
        String newuserpassword= MD5Utils.string2MD5(salt + users.getUser_password());
        users.setUser_password(newuserpassword);
        int count = usersService.addUsers(users);
        //System.out.println(users);
        if (count > 0) {
            commonResult = new CommonResult(200, "注册成功");
        } else {
            commonResult = new CommonResult(500, "注册失败");
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping("/userlogin")
    public CommonResult UserLogin(String user_code1, Users users, HttpSession session) {
        CommonResult commonResult;
        String salt="hl123";
        String newuserpassword2= MD5Utils.string2MD5(salt +users.getUser_password());
        users.setUser_password(newuserpassword2);
        String safeCode = (String) session.getAttribute("safeCode");
        Users auser = usersService.getAUser(users);
        if (auser!=null){
            if (user_code1.equalsIgnoreCase(safeCode)) {

                session.setAttribute("loginUser", auser);
                commonResult = new CommonResult(200, "登录成功");
            } else {
                commonResult = new CommonResult(250, "验证码错误");
            }
        } else {
            commonResult = new CommonResult(500, "登录失败");
        }
        return commonResult;
    }


    @RequestMapping("/usertopersonal")
    public String ToUserPersonal(HttpSession session, Model model) {
        Users loginUser = (Users) session.getAttribute("loginUser");
        List<TicketDto> ticketDtosByPlayId = buyTicketService.getPersonTicketDtos(loginUser.getUser_id());
        model.addAttribute("ticketDtos",ticketDtosByPlayId);
        return "user_personal";
    }

    @ResponseBody
    @RequestMapping("/userloginout")
    public CommonResult UserLoginOut(HttpSession session) {
        session.invalidate();
        CommonResult commonResult = new CommonResult(200, "退出成功");
        return commonResult;
    }

    @ResponseBody
    @RequestMapping("/userupdateinfo")
    public CommonResult UpdateUsers(Users users, HttpSession session) {
        CommonResult commonResult;
        int count = usersService.updateUser(users);
        Users user2 = usersService.getById(users.getUser_id());
        if (count > 0) {
            session.setAttribute("loginUser", user2);
            commonResult = new CommonResult(200, "用户信息修改成功");
        } else {
            commonResult = new CommonResult(500, "用户信息修改错误");
        }
        return commonResult;
    }


    @RequestMapping("/userupdateheadphoto")
    public void ImgLoad(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        //获取上传照片文件的原名字
        String originalFilename = file.getOriginalFilename();
        if (!"".equals(originalFilename)) {
            //获取照片后缀名
            String extendfilename = originalFilename.substring(originalFilename.lastIndexOf("."));
            //生成随机不可重复的照片名
            String newfilename = UUID.randomUUID().toString() + extendfilename;
            //获取照片全路径
            String realPath = request.getServletContext().getRealPath("/photo") + "/" + newfilename;
            //文件上传
            try {
                file.transferTo(new File(realPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpSession session = request.getSession();
            Users loginuser = (Users) session.getAttribute("loginUser");
            int count = usersService.updatePhoto(loginuser.getUser_id(), "/photo/" + newfilename);
            if (count > 0) {
                Users users = usersService.getById(loginuser.getUser_id());
                session.setAttribute("loginUser", users);
                response.getWriter().write("<script>alert('用户头像修改成功');location.href='/usertopersonal'</script>");
            } else {
                response.getWriter().write("<script>alert('用户头像修改失败');location.href='/usertopersonal'</script>");
            }
        } else {
            response.getWriter().write("<script>alert('请选择要上传的头像');location.href='/usertopersonal';</script>");
        }
    }
}





