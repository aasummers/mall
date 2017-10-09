package com.chengliang.mall.dao;

import com.chengliang.mall.entity.user;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 判断用户是否存在
     * @param user
     * @return
     */
    @Select("select count(*) from user where name = #{name} and password = #{password}")
    int userExist(user user);
}