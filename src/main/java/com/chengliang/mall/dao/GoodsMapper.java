package com.chengliang.mall.dao;

import com.chengliang.mall.entity.Goods;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    int insert(Goods record);

    int insertSelective(Goods record);

    @Select("select * from goods")
    List<Goods> queryGoodsList();

    @Select("select * from goods where id = #{goodsId}")
    Goods queryGoodsDetails(Integer goodsId);
}