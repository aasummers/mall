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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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
    public String addressList(HttpServletRequest request, ModelMap map, Integer orderStatus) {
        user user = (user) request.getSession().getAttribute("user");
        List<Order> order;
        if(orderStatus==null || orderStatus==0){
            order = orderMapper.selectAllOrderListByUserId(user.getId());
        }else{
            order = orderMapper.selectOrderListByUserId(user.getId(), orderStatus);
        }
        map.put("orderList", order);
        map.put("status", orderStatus==null? 0 : orderStatus);
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

    @RequestMapping("/confirmAcceptOrder")
    public String confirmAcceptOrder(String orderCode) {
        Order order = orderMapper.updateOrderStatus(orderCode);
        return "redirect:myOrder";
    }


    /**
     * 添加订单
     */
    @RequestMapping("/addOrder")
    @ResponseBody()
    public String addOrder(HttpServletRequest request, Integer goodsId, Integer goodsNum, ModelMap map) {
        user user = (user) request.getSession().getAttribute("user");
        Goods goods = goodsMapper.queryGoodsDetails(goodsId);
        int res;
        String orderCode = orderNo();
        Address address = addressMapper.selectDefaultAddess(user.getId());
        if (goods != null) {
            Order order = new Order();
            order.setOrderCode(orderCode);
            order.setGoodsNum(goodsNum);
            order.setOrderStatus(1);
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

    /**
     * 穿件订单编号
     * @return
     */
    private String orderNo(){
        String res = "";
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        res = today.format(formatter);
        int count = orderMapper.todayOrderCount() + 1;
        String relex = leftPad(count+"",5,'0');
        return res+relex;
    }

    public static String leftPad(String str,int length,char ch){
        char[] chs = new char[length];
        Arrays.fill(chs, ch);//把数组chs填充成ch
        char[] src = str.toCharArray();//把字符串转换成字符数组
        System.arraycopy(src, 0, chs,
                length-src.length,src.length);
        //从src的0位置开始复制到chs中从length-src.length到src.lengtth
        //右填充
        return new String(chs);

    }
}
