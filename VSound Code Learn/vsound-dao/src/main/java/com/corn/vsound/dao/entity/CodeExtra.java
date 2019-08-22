package com.corn.vsound.dao.entity;

import java.util.Date;

public class CodeExtra {
    private Integer id;

    private String codeId;

    private String usePosition;

    private String codeRemark;

    private String codeMethods;

    private String codeImages;

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

    public String getCodeImages() {
        return codeImages;
    }

    public void setCodeImages(String codeImages) {
        this.codeImages = codeImages == null ? null : codeImages.trim();
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
}