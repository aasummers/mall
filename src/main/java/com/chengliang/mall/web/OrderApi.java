package com.chengliang.mall.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderApi {
    @RequestMapping("/myOrder")
    public String addressList(Integer userId, ModelMap map) {
        return "myOrder";
    }

    @RequestMapping("/orderDetails")
    public String orderDetails(Integer orderId, ModelMap map) {
        return "orderDetails";
    }
}
