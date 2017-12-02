package com.chengliang.mall.web;

import com.chengliang.mall.dao.AdvertMapper;
import com.chengliang.mall.dao.GoodsMapper;
import com.chengliang.mall.entity.Advert;
import com.chengliang.mall.entity.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author dingyuxin
 */
@Controller
public class IndexApi {
    @Autowired
    public GoodsMapper goodsMapper;
    @Autowired
    public AdvertMapper advertMapper;
    @RequestMapping("/")
    public String index(ModelMap map) {
        List<Goods> goodsList = goodsMapper.queryIndexGoods();
        List<Advert> advertList = advertMapper.advertList();
        map.put("goodsList", goodsList);
        map.put("advertList", advertList);
        return "index";
    }
}
