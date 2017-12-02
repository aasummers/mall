package com.chengliang.mall.dao;

import com.chengliang.mall.entity.Order;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
}