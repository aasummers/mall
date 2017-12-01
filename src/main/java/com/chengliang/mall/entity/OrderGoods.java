package com.chengliang.mall.entity;

import java.io.Serializable;

public class OrderGoods implements Serializable {
    private Integer id;

    private String ordercode;

    private String goodsname;

    private String goodsimg;

    private String goodsprice;

    private String goodspromotionprice;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg == null ? null : goodsimg.trim();
    }

    public String getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice == null ? null : goodsprice.trim();
    }

    public String getGoodspromotionprice() {
        return goodspromotionprice;
    }

    public void setGoodspromotionprice(String goodspromotionprice) {
        this.goodspromotionprice = goodspromotionprice == null ? null : goodspromotionprice.trim();
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
        OrderGoods other = (OrderGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrdercode() == null ? other.getOrdercode() == null : this.getOrdercode().equals(other.getOrdercode()))
            && (this.getGoodsname() == null ? other.getGoodsname() == null : this.getGoodsname().equals(other.getGoodsname()))
            && (this.getGoodsimg() == null ? other.getGoodsimg() == null : this.getGoodsimg().equals(other.getGoodsimg()))
            && (this.getGoodsprice() == null ? other.getGoodsprice() == null : this.getGoodsprice().equals(other.getGoodsprice()))
            && (this.getGoodspromotionprice() == null ? other.getGoodspromotionprice() == null : this.getGoodspromotionprice().equals(other.getGoodspromotionprice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrdercode() == null) ? 0 : getOrdercode().hashCode());
        result = prime * result + ((getGoodsname() == null) ? 0 : getGoodsname().hashCode());
        result = prime * result + ((getGoodsimg() == null) ? 0 : getGoodsimg().hashCode());
        result = prime * result + ((getGoodsprice() == null) ? 0 : getGoodsprice().hashCode());
        result = prime * result + ((getGoodspromotionprice() == null) ? 0 : getGoodspromotionprice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ordercode=").append(ordercode);
        sb.append(", goodsname=").append(goodsname);
        sb.append(", goodsimg=").append(goodsimg);
        sb.append(", goodsprice=").append(goodsprice);
        sb.append(", goodspromotionprice=").append(goodspromotionprice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}