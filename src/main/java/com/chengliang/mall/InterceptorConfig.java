package com.chengliang.mall;

import com.chengliang.mall.interceptor.CommonInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private CommonInterceptor commonInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/*");
        super.addInterceptors(registry);
    }
}
