package com.chengliang.mall.web;

import com.chengliang.mall.MallApplication;
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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MallApplication.class)
@WebAppConfiguration
public class GoodsApiTest {
    MockMvc mvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void goodsList() throws Exception {
        String uri = "/goodsList";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = result.getResponse().getStatus();
        result.getResponse().setCharacterEncoding("utf-8");
        String content = result.getResponse().getContentAsString();
        System.out.println(result.getResponse().getCharacterEncoding());
        System.out.println(content);
    }

    @Test
    public void goodsDetails() throws Exception {
        String uri = "/goodsDetails";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .characterEncoding("utf-8")
                .param("goodsId", "1")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = result.getResponse().getStatus();
        result.getResponse().setCharacterEncoding("utf-8");
        String content = result.getResponse().getContentAsString();
        System.out.println(result.getResponse().getCharacterEncoding());
        System.out.println(content);
    }

}