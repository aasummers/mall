package com.chengliang.mall.dao;

import com.chengliang.mall.entity.Order;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
}