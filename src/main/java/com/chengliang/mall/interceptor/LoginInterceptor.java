package com.chengliang.mall.interceptor;

import com.chengliang.mall.entity.user;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        request.setAttribute("base", base);
        ;
        /*
         * 从session中获取用户信息
         */
        user managerUser = (user) request.getSession().getAttribute("user");

        String path = request.getServletPath();
        String query = request.getQueryString();
        if (managerUser == null) {//如果session中没有用户的信息，跳转到登录页面，内部网页不能访问
//            System.out.println("ManagerUserInterceptor---->>>>>>preHandle");
//            request.setAttribute("callback", path+"?"+query);
//            String callback = path + "?" + query;
//            response.sendRedirect(base+"/toLogin?callback=" + callback);

            String XRequested = request.getHeader("X-Requested-With");
            if ("XMLHttpRequest".equalsIgnoreCase(XRequested)) {
                ServletOutputStream out = response.getOutputStream();
                String callback = base + "/" + path + "?" + query;;
                out.print("unlogin?" + callback);//返回给前端页面的未登陆标识
                out.flush();
                out.close();
                return false;
            } else {
                String callback = path + "?" + query;
                response.sendRedirect(base + "/toLogin?callback=" + callback);
            }
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
