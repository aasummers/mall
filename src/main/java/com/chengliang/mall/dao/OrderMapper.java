package com.chengliang.mall.dao;

import com.chengliang.mall.entity.Order;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    @Select("select * from `order` where userId = #{userId} and orderStatus = #{status}")
    List<Order> selectOrderListByUserId(@Param("userId") Integer userId, @Param("status") Integer status);

    @Select("select * from `order` where orderCode = #{orderCode};")
    Order selectOrderByOrderCode(String orderCode);

    @Update("update `order` set orderStatus = 4 where orderCode = #{orderCode};")
    Order updateOrderStatus(String orderCode);
}