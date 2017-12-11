package com.chengliang.mall.dao;

import com.chengliang.mall.entity.OrderGoods;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderGoodsMapper {
    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);
    @Select("SELECT * FROM `order_goods` where orderCode = #{orderCode};")
    List<OrderGoods> selectOrderGoodsByOrderCode(String orderCode);
}