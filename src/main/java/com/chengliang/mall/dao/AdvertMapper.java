package com.chengliang.mall.dao;

import com.chengliang.mall.entity.Advert;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdvertMapper {
    int insert(Advert record);

    int insertSelective(Advert record);

    /**
     * 查看公广告列表
     * @return
     */
    @Select("select * from advert limit 5")
    List<Advert> advertList();
}