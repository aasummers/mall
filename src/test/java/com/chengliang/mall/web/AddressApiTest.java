package com.chengliang.mall.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.MallApplication;
import com.chengliang.mall.entity.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MallApplication.class)
@WebAppConfiguration
public class AddressApiTest {
    MockMvc mvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void addressList() throws Exception {
        String uri = "/addressList";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .characterEncoding("utf-8")
                .param("userId", "1")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = result.getResponse().getStatus();
        result.getResponse().setCharacterEncoding("utf-8");
        String content = result.getResponse().getContentAsString();
        System.out.println(result.getResponse().getCharacterEncoding());
        System.out.println(content);
    }

    @Test
    public void addAddress() throws Exception {
        String uri = "/addAddress";
        Address address = new Address();
        address.setIsDefault(1);
        address.setRecUserAddress("乔家大院");
        address.setRecUserArea("山西");
        address.setRecUserName("大乔");
        address.setRecUserPhone("13241115253");
        address.setUserId(1);
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(address))
                .characterEncoding("utf-8")
                .param("ress", JSON.toJSONString(address))
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        System.out.println(result.getResponse().getCharacterEncoding());
        System.out.println(content);
    }

    @Test
    public void updateAddress() throws Exception {
        String uri = "/updateAddress";
        Address address = new Address();
        address.setId(2);
        address.setIsDefault(1);
        address.setRecUserAddress("乔家大院");
        address.setRecUserArea("山西");
        address.setRecUserName("大乔");
        address.setRecUserPhone("13242225253");
        address.setUserId(1);
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(address))
                .characterEncoding("utf-8")
                .param("ress", JSON.toJSONString(address))
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        System.out.println(result.getResponse().getCharacterEncoding());
        System.out.println(content);
    }

}