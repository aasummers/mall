package com.chengliang.mall.interceptor;

import com.chengliang.mall.entity.user;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        request.setAttribute("base", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());
        ;
        /*
         * 从session中获取用户信息
         */
        user managerUser = (user) request.getSession().getAttribute("user");


        if (managerUser == null) {//如果session中没有用户的信息，跳转到登录页面，内部网页不能访问
            System.out.println("ManagerUserInterceptor---->>>>>>preHandle");
            request.getRequestDispatcher("/toLogin").forward(request, response);
            return false;
        } else {
            request.setAttribute("user", managerUser);
            request.setAttribute("userId", managerUser.getId());
            return true;
        }
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
