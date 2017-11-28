package com.chengliang.mall.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.dao.GoodsMapper;
import com.chengliang.mall.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
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
    @RequestMapping(value = "/goodsDetails/{goodsId}", method = RequestMethod.GET)
    public String goodsDetails(@PathVariable Integer goodsId, ModelMap map){
        Goods res = goodsMapper.queryGoodsDetails(goodsId);
        map.put("res", res);
        return "goodsDetails";
    }

}
