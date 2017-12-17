package com.chengliang.mall.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Table(name = "order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "orderCode")
    private String orderCode;
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "state")
    private Integer state;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "recUserName")
    private String recUserName;
    @Column(name = "recUserPhone")
    private String recUserPhone;
    @Column(name = "recUserAddress")
    private String recUserAddress;
    @Column(name = "goodsNum")
    private Integer goodsNum;
    @Column(name = "orderStatus")
    private Integer orderStatus;
    @Column(name = "orderPrice")
    private Double orderPrice;

    private List<OrderGoods> orderGoodsList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecUserName() {
        return recUserName;
    }

    public void setRecUserName(String recUserName) {
        this.recUserName = recUserName == null ? null : recUserName.trim();
    }

    public String getRecUserPhone() {
        return recUserPhone;
    }

    public void setRecUserPhone(String recUserPhone) {
        this.recUserPhone = recUserPhone == null ? null : recUserPhone.trim();
    }

    public String getRecUserAddress() {
        return recUserAddress;
    }

    public void setRecUserAddress(String recUserAddress) {
        this.recUserAddress = recUserAddress == null ? null : recUserAddress.trim();
    }

    public List<OrderGoods> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderGoods> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }


    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }
}