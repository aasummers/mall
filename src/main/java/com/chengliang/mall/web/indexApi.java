package com.chengliang.mall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexApi {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
