package com.chengliang.mall.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
@Table(name = "order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "orderCode")
    private String orderCode;
    @Column(name = "goodsName")
    private String goodsName;
    @Column(name = "goodsImg")
    private String goodsImg;
    @Column(name = "goodsPrice")
    private BigDecimal goodsPrice;
    @Column(name = "goodsPromotionPrice")
    private BigDecimal goodsPromotionPrice;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsPromotionPrice() {
        return goodsPromotionPrice;
    }

    public void setGoodsPromotionPrice(BigDecimal goodsPromotionPrice) {
        this.goodsPromotionPrice = goodsPromotionPrice;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsImg() == null ? other.getGoodsImg() == null : this.getGoodsImg().equals(other.getGoodsImg()))
            && (this.getGoodsPrice() == null ? other.getGoodsPrice() == null : this.getGoodsPrice().equals(other.getGoodsPrice()))
            && (this.getGoodsPromotionPrice() == null ? other.getGoodsPromotionPrice() == null : this.getGoodsPromotionPrice().equals(other.getGoodsPromotionPrice()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRecUserName() == null ? other.getRecUserName() == null : this.getRecUserName().equals(other.getRecUserName()))
            && (this.getRecUserPhone() == null ? other.getRecUserPhone() == null : this.getRecUserPhone().equals(other.getRecUserPhone()))
            && (this.getRecUserAddress() == null ? other.getRecUserAddress() == null : this.getRecUserAddress().equals(other.getRecUserAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsImg() == null) ? 0 : getGoodsImg().hashCode());
        result = prime * result + ((getGoodsPrice() == null) ? 0 : getGoodsPrice().hashCode());
        result = prime * result + ((getGoodsPromotionPrice() == null) ? 0 : getGoodsPromotionPrice().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRecUserName() == null) ? 0 : getRecUserName().hashCode());
        result = prime * result + ((getRecUserPhone() == null) ? 0 : getRecUserPhone().hashCode());
        result = prime * result + ((getRecUserAddress() == null) ? 0 : getRecUserAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsImg=").append(goodsImg);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsPromotionPrice=").append(goodsPromotionPrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", state=").append(state);
        sb.append(", userId=").append(userId);
        sb.append(", recUserName=").append(recUserName);
        sb.append(", recUserPhone=").append(recUserPhone);
        sb.append(", recUserAddress=").append(recUserAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}