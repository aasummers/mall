package com.chengliang.mall.dao;

import com.chengliang.mall.entity.OrderGoods;

public interface OrderGoodsMapper {
    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);
}