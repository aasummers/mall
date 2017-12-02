package com.chengliang.mall.web;

import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.dao.OrderGoodsMapper;
import com.chengliang.mall.dao.OrderMapper;
import com.chengliang.mall.entity.Order;
import com.chengliang.mall.entity.OrderGoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class OrderApi {
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/myOrder")
    public String addressList(Integer userId, ModelMap map) {
        List<Order> order = orderMapper.selectOrderListByUserId(userId);
        map.put("orderList", order);
        return "myOrder";
    }

    @RequestMapping("/orderDetails")
    public String orderDetails(Integer orderId, ModelMap map) {

        return "orderDetails";
    }

    /**
     * 添加订单
     */
    @RequestMapping("/addOrder")
    @Transactional
    public String addOrder(Integer orderId, Order order, ModelMap map) {
        if (order != null) {
            System.out.println(JSONObject.toJSONString(order));
            order.setOrderCode(UUID.randomUUID().toString().replace("-", ""));
            order.setGoodsNum(order.getOrderGoodsList().size());
            orderMapper.insertSelective(order);
            for (OrderGoods goods : order.getOrderGoodsList()) {
                orderGoodsMapper.insertSelective(goods);
            }
        } else {
            System.out.println("订单信息为空哦");
        }
        return "orderDetails";
    }
}
