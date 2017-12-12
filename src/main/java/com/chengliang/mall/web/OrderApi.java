package com.chengliang.mall.web;

import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.dao.AddressMapper;
import com.chengliang.mall.dao.GoodsMapper;
import com.chengliang.mall.dao.OrderGoodsMapper;
import com.chengliang.mall.dao.OrderMapper;
import com.chengliang.mall.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderApi {
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    public GoodsMapper goodsMapper;
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/myOrder")
    public String addressList(Integer userId, ModelMap map, Integer orderStatus) {
        orderStatus = orderStatus == null ? 0 : orderStatus;
        List<Order> order = orderMapper.selectOrderListByUserId(userId, orderStatus);
        map.put("orderList", order);
        return "myOrder";
    }

    @RequestMapping("/orderDetails")
    public String orderDetails(String orderCode, ModelMap map) {
        Order order = orderMapper.selectOrderByOrderCode(orderCode);
        List<OrderGoods> goods = orderGoodsMapper.selectOrderGoodsByOrderCode(order.getOrderCode());
        order.setOrderGoodsList(goods);
        map.put("order", order);
        return "orderDetails";
    }



    /**
     * 添加订单
     */
    @RequestMapping("/addOrder")
    @ResponseBody()
    public String addOrder(HttpServletRequest request, Integer goodsId, Integer goodsNum, ModelMap map) {
        user user = (user)request.getSession().getAttribute("user");
        Goods goods = goodsMapper.queryGoodsDetails(goodsId);
        int res;
        String orderCode  = UUID.randomUUID().toString().replace("-", "");
        Address address = addressMapper.selectDefaultAddess(user.getId());
        if (goods != null) {
            Order order = new Order();
            order.setOrderCode(orderCode);
            order.setGoodsNum(goodsNum);
            order.setOrderStatus(0);
            order.setUserId(user.getId());
            order.setRecUserName(address.getRecUserName());
            order.setRecUserPhone(address.getRecUserPhone());
            order.setRecUserAddress(address.getRecUserAddress());
            order.setGoodsNum(goodsNum);

            res = orderMapper.insertSelective(order);

            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setOrdercode(orderCode);
            orderGoods.setGoodsId(goodsId);
            orderGoods.setGoodsimg(goods.getImage());
            orderGoods.setGoodsname(goods.getName());
            orderGoods.setGoodsprice(goods.getPromotionPrice());

            orderGoodsMapper.insertSelective(orderGoods);

        } else {
            res = 0;
            System.out.println("订单信息为空哦");
        }
        return orderCode;
    }
}
