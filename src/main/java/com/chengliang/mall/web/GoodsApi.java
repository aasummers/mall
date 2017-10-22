package com.chengliang.mall.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.dao.GoodsMapper;
import com.chengliang.mall.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsApi {
    @Autowired
    public GoodsMapper goodsMapper;
    /**
     * 展示商品列表
     * @return
     */
    @RequestMapping("/goodsList")
    public String goodsList(){
        List<Goods> res = goodsMapper.queryGoodsList();
        return JSONArray.toJSONString(res);
    }

    /**
     * 展示商品详情
     * @param goodsId
     * @return
     */
    @RequestMapping("/goodsDetails")
    public String goodsDetails(Integer goodsId){
        Goods res = goodsMapper.queryGoodsDetails(goodsId);
        return JSONObject.toJSONString(res);
    }

}
