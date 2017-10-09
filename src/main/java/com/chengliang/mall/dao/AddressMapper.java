package com.chengliang.mall.dao;

import com.chengliang.mall.entity.Address;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {
    /**
     * 添加地址
     *
     * @param record
     * @return
     */
    int insert(Address record);

    /**
     * 用户地址列表
     *
     * @param userId
     * @return
     */
    @Select("select id, user_id userId, rec_user_name recUserName, rec_user_phone recUserPhone, rec_user_address recUserAddress, rec_user_area recUserArea, is_default isDefault from address where user_id = #{userId}")
    List<Address> addressList(int userId);

    /**
     * 更新地址信息
     *
     * @param address
     * @return
     */
    @Update("update address set user_id = #{userId}, rec_user_name = #{recUserName}, rec_user_phone = #{recUserPhone}, rec_user_address = #{recUserAddress}, rec_user_area = #{recUserArea}, is_default = #{isDefault} where id = #{id}")
    int updateAddress(Address address);
}