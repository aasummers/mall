package com.chengliang.mall.dao;

import com.chengliang.mall.entity.Order;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    @Select("select * from `order` where userId = #{userId}")
    List<Order> selectOrderListByUserId(Integer userId);
}