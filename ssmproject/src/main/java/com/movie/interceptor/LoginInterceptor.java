package com.movie.interceptor;

import com.movie.bean.Admin;
import com.movie.bean.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    //请求目标方法执行之间
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //权限拦截
        String requestURI = request.getRequestURI();
        Admin loginAdmin=(Admin)request.getSession().getAttribute("loginadmin");


        if(requestURI.startsWith("/buy")||requestURI.startsWith("/user")||requestURI.startsWith("/queryPay")||requestURI.startsWith("/page_user")){
            Users loginUser = (Users) request.getSession().getAttribute("loginUser");
            if(loginUser==null){
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("<script>alert('请先登录网站');location.href='/';</script>");
                return false;
            }else {
                return  true;
            }
        } else if(loginAdmin!=null){
            return  true;
        }else {
            return false;
        }

    }

    //目标方法执行之后，界面出现之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //请求之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
