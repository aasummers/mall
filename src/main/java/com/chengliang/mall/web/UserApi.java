package com.chengliang.mall.web;

import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.dao.UserMapper;
import com.chengliang.mall.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserApi {
    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    };

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

    /**
     * 个人中心
     * @param userId
     * @return
     */
    @RequestMapping("/center")
    public String userInfo(Integer userId, ModelMap map){
        user res = userMapper.userInfo(userId);
        map.put("user", res);
        return "center";
    }

    /**
     * 跳转至修改密码页面
     * @param userId
     * @return
     */
    @RequestMapping("/toChangePW")
    public String toChangePW(Integer userId, ModelMap map){
        map.put("userId", userId);
        return "changePW";
    }

    /**
     * 修改密码
     * @param userId
     * @param newPW
     * @return
     */
    @RequestMapping("/changePasswd")
    public String changePasswd(Integer userId, String newPW){
        int res = userMapper.changePasswd(userId, newPW);
        return JSONObject.toJSONString(res);
    }
}
