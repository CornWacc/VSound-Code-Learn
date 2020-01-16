package com.corn.vsound.dao.entity;

import com.corn.vsound.facade.enums.YNEnum;

import java.util.Date;

public class CodeMethodOrder {
    private Integer id;

    private String codeMethodOrderId;

    private String codeMethodOrderName;

    private String codeMethodOrderClassType;

    private YNEnum orderIsInterface;

    private String codeMethodId;

    private String codeMethodOrderRemark;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public YNEnum getOrderIsInterface() {
        return orderIsInterface;
    }

    public void setOrderIsInterface(YNEnum orderIsInterface) {
        this.orderIsInterface = orderIsInterface;
    }

    public String getCodeMethodOrderId() {
        return codeMethodOrderId;
    }

    public void setCodeMethodOrderId(String codeMethodOrderId) {
        this.codeMethodOrderId = codeMethodOrderId == null ? null : codeMethodOrderId.trim();
    }

    public String getCodeMethodOrderName() {
        return codeMethodOrderName;
    }

    public void setCodeMethodOrderName(String codeMethodOrderName) {
        this.codeMethodOrderName = codeMethodOrderName == null ? null : codeMethodOrderName.trim();
    }

    public String getCodeMethodOrderClassType() {
        return codeMethodOrderClassType;
    }

    public void setCodeMethodOrderClassType(String codeMethodOrderClassType) {
        this.codeMethodOrderClassType = codeMethodOrderClassType == null ? null : codeMethodOrderClassType.trim();
    }


    public String getCodeMethodId() {
        return codeMethodId;
    }

    public void setCodeMethodId(String codeMethodId) {
        this.codeMethodId = codeMethodId == null ? null : codeMethodId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCodeMethodOrderRemark() {
        return codeMethodOrderRemark;
    }

    public void setCodeMethodOrderRemark(String codeMethodOrderRemark) {
        this.codeMethodOrderRemark = codeMethodOrderRemark;
    }
}