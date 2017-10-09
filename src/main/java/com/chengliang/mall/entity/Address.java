package com.chengliang.mall.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "rec_user_name")
    private String recUserName;
    @Column(name = "rec_user_phone")
    private String recUserPhone;
    @Column(name = "rec_user_address")
    private String recUserAddress;
    @Column(name = "rec_user_area")
    private String recUserArea;
    @Column(name = "is_default")
    private Integer isDefault;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRecUserArea() {
        return recUserArea;
    }

    public void setRecUserArea(String recUserArea) {
        this.recUserArea = recUserArea == null ? null : recUserArea.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        Address other = (Address) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRecUserName() == null ? other.getRecUserName() == null : this.getRecUserName().equals(other.getRecUserName()))
            && (this.getRecUserPhone() == null ? other.getRecUserPhone() == null : this.getRecUserPhone().equals(other.getRecUserPhone()))
            && (this.getRecUserAddress() == null ? other.getRecUserAddress() == null : this.getRecUserAddress().equals(other.getRecUserAddress()))
            && (this.getRecUserArea() == null ? other.getRecUserArea() == null : this.getRecUserArea().equals(other.getRecUserArea()))
            && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRecUserName() == null) ? 0 : getRecUserName().hashCode());
        result = prime * result + ((getRecUserPhone() == null) ? 0 : getRecUserPhone().hashCode());
        result = prime * result + ((getRecUserAddress() == null) ? 0 : getRecUserAddress().hashCode());
        result = prime * result + ((getRecUserArea() == null) ? 0 : getRecUserArea().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", recUserName=").append(recUserName);
        sb.append(", recUserPhone=").append(recUserPhone);
        sb.append(", recUserAddress=").append(recUserAddress);
        sb.append(", recUserArea=").append(recUserArea);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}