package com.chengliang.mall.web;

import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.dao.UserMapper;
import com.chengliang.mall.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping("/login")
    public String login(String userName, String passWord){
        user user = new user();
        user.setName(userName);
        user.setPassword(passWord);
        int res = userMapper.userExist(user);
        return res+"";
    };

    @RequestMapping("/userInfo")
    public String userInfo(Integer userId){
        user res = userMapper.userInfo(userId);
        return JSONObject.toJSONString(res);
    }

    @RequestMapping("/changePasswd")
    public String changePasswd(Integer userId, String newPW){
        int res = userMapper.changePasswd(userId, newPW);
        return JSONObject.toJSONString(res);
    }
}
