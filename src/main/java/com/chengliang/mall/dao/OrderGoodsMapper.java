package com.chengliang.mall.dao;

import com.chengliang.mall.entity.OrderGoods;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderGoodsMapper {
    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);
}