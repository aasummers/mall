package com.chengliang.mall;

import com.chengliang.mall.interceptor.CommonInterceptor;
import com.chengliang.mall.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private CommonInterceptor commonInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/*");
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/*")
                .excludePathPatterns("/toLogin*")
                .excludePathPatterns("/login*")
                .excludePathPatterns("/index*")
                .excludePathPatterns("/goodsDetails*");
        super.addInterceptors(registry);
    }
}
