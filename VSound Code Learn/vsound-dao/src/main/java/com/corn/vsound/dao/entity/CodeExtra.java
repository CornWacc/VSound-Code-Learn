package com.corn.vsound.dao.entity;

import com.corn.boot.base.Base;

import java.util.Date;

public class CodeExtra extends Base {
    private Integer id;

    private String codeId;

    private String usePosition;

    private String codeRemark;

    private String codeMethods;

    private String codeParameter;

    private String outSideUrl;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId == null ? null : codeId.trim();
    }

    public String getUsePosition() {
        return usePosition;
    }

    public void setUsePosition(String usePosition) {
        this.usePosition = usePosition == null ? null : usePosition.trim();
    }

    public String getCodeRemark() {
        return codeRemark;
    }

    public void setCodeRemark(String codeRemark) {
        this.codeRemark = codeRemark == null ? null : codeRemark.trim();
    }

    public String getCodeMethods() {
        return codeMethods;
    }

    public void setCodeMethods(String codeMethods) {
        this.codeMethods = codeMethods == null ? null : codeMethods.trim();
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

    public String getCodeParameter() {
        return codeParameter;
    }

    public void setCodeParameter(String codeParameter) {
        this.codeParameter = codeParameter;
    }

    public String getOutSideUrl() {
        return outSideUrl;
    }

    public void setOutSideUrl(String outSideUrl) {
        this.outSideUrl = outSideUrl;
    }
}