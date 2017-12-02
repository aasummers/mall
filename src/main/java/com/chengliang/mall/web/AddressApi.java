package com.chengliang.mall.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.dao.AddressMapper;
import com.chengliang.mall.dao.UserMapper;
import com.chengliang.mall.entity.Address;
import com.chengliang.mall.entity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AddressApi {
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 用户地址列表
     */
    @RequestMapping("/myAddress")
    public String addressList(Integer userId, ModelMap map) {
        List<Address> addressList = addressMapper.addressList(userId);
        map.put("addressList", addressList);
        return "myAddress";
    }

    /**
     * 跳转到添加收货地址页面
     * @param userId
     * @param map
     * @return
     */
    @RequestMapping("/toAddAddress")
    public String toAddAddress(Integer userId, ModelMap map) {
        map.put("userId", userId);
        return "addAddress";
    }

    /**
     * 跳转到修改收货地址页面
     * @param addressId
     * @return
     */
    @RequestMapping("/delAddress")
    public String delAddress(Integer addressId) {
        Address address = addressMapper.queryAddressById(addressId);
        if(address==null){
            // 地址不存在的处理方式
        }
        addressMapper.delAddress(addressId);
        return "redirect:myAddress?userId="+address.getUserId();
    }

    /**
     * 跳转到修改收货地址页面
     * @param addressId
     * @param map
     * @return
     */
    @RequestMapping("/toEditAddress")
    public String toEditAddress(Integer addressId, ModelMap map) {
        Address address = addressMapper.queryAddressById(addressId);
        map.put("address", address);
        return "editAddress";
    }


    /**
     * 添加地址
     */
    @RequestMapping("/addAddress")
    @Transactional
    public String addAddress(Address address) {
        int res = addressMapper.insert(address);
        updateDefaultAddress(address.getUserId(), defaultAddressId(address));
        return "redirect:myAddress?userId="+address.getUserId();
    }

    /**
     * 更新用户地址
     */
    @RequestMapping("/updateAddress")
    @Transactional
    public String updateAddress(Address address) {
        updateDefaultAddress(address.getUserId(), defaultAddressId(address));
        int res = addressMapper.updateAddress(address);
        return "redirect:myAddress?userId="+address.getUserId();
    }

    public Integer defaultAddressId(Address address) {
        Integer res = null;
        if (address.getIsDefault() == 1) {
            res = address.getId();
        }
        return res;
    }

    /**
     * 更新用户默认地址
     */
    private void updateDefaultAddress(int userId, Integer addressId) {
        if (addressId == null) return;
        List<Address> addresses = addressMapper.addressList(userId);
        for (Address address : addresses) {
            if (addressId.equals(address.getId())) {
                address.setIsDefault(1);
            } else {
                address.setIsDefault(0);
            }
            addressMapper.updateAddress(address);
        }

    }

}
