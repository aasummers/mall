package com.chengliang.mall.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.dao.AddressMapper;
import com.chengliang.mall.dao.UserMapper;
import com.chengliang.mall.entity.Address;
import com.chengliang.mall.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressApi {
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 用户地址列表
     * @param userId
     * @return
     */
    @RequestMapping("/addressList")
    public String addressList(int userId){
        List<Address> res = addressMapper.addressList(userId);
        return JSONArray.toJSONString(res);
    };

    /**
     * 添加地址
     * @return
     */
    @RequestMapping("/addAddress")
    @Transactional
    public String addAddress(String ress){
        Address address = JSON.parseObject(ress, Address.class);
        int res = addressMapper.insert(address);
        updateDefaultAddress(address.getUserId(), defaultAddressId(address));
        return res + "";
    }

    /**
     * 更新用户地址
     * @return
     */
    @RequestMapping("/updateAddress")
    @Transactional
    public String updateAddress(String ress){
        Address address = JSON.parseObject(ress, Address.class);
        updateDefaultAddress(address.getUserId(), defaultAddressId(address));
        int res = addressMapper.updateAddress(address);
        return res + "";
    }

    public Integer defaultAddressId(Address address){
        Integer res = null;
        if( address.getIsDefault()==1 ){
            res = address.getId();
        }
        return res;
    }

    /**
     * 更新用户默认地址
     * @param userId
     */
    private void updateDefaultAddress(int userId, Integer addressId){
        if(addressId==null) return;
        List<Address> addresses = addressMapper.addressList(userId);
        for (Address address : addresses){
            if(addressId == address.getId()){
                address.setIsDefault(1);
            }else{
                address.setIsDefault(0);
            }
            addressMapper.updateAddress(address);
        }

    }

}
