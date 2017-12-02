package com.chengliang.mall.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class CommonInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        request.setAttribute("base", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());;
        // 指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods", "POST");
        // 响应头设置
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
