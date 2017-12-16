package com.chengliang.mall.web;

import com.alibaba.fastjson.JSONObject;
import com.chengliang.mall.dao.UserMapper;
import com.chengliang.mall.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserApi {
    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request, ModelMap map, String callback){
//        String callBack = String.valueOf(request.getAttribute("callback"));
        map.put("callback", callback);
        return "login";
    };

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody()
    public String login(HttpServletRequest request, String userName, String passWord, String callback){
        String base = request.getAttribute("base").toString();
        user user = new user();
        user.setName(userName);
        user.setPassword(passWord);
        user res = userMapper.userExist(user);
        if(res!=null){
            request.getSession().setAttribute("user", res);
        }
        return base+callback;
    };

    /**
     * 个人中心
     * @return
     */
    @RequestMapping("/center")
    public String userInfo(HttpServletRequest request, ModelMap map){
        user user = (user) request.getSession().getAttribute("user");
        user res = userMapper.userInfo(user.getId());
        map.put("user", res);
        return "center";
    }

    /**
     * 跳转至修改密码页面
     * @param
     * @return
     */
    @RequestMapping("/toChangePW")
    public String toChangePW(HttpServletRequest request, ModelMap map){
        user user = (user) request.getSession().getAttribute("user");
        map.put("userId", user.getId());
        return "changePW";
    }

    /**
     * 修改密码
     * @param newPW
     * @return
     */
    @RequestMapping("/changePasswd")
    @ResponseBody()
    public String changePasswd(HttpServletRequest request, String newPW){
        Integer userId = ((user)request.getSession().getAttribute("user")).getId();
        int res = userMapper.changePasswd(userId, newPW);
        return JSONObject.toJSONString(res);
    }
}
