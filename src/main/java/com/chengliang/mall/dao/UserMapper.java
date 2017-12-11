package com.chengliang.mall.dao;

import com.chengliang.mall.entity.user;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 判断用户是否存在
     * @param user
     * @return
     */
    @Select("select * from user where name = #{name} and password = #{password}")
    user userExist(user user);

    @Select("select * from user where id = #{userId}")
    user userInfo(Integer userId);

    @Update("update user set password = #{newPW} where id = #{userId}")
    int changePasswd(@Param("userId")Integer userId, @Param("newPW") String newPW);
}