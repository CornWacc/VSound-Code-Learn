package com.corn.vsound.dao.entity;

import java.util.Date;

public class CodeOutSideUrl {
    private Integer id;

    private String urlId;

    private String urlRemark;

    private String urlPath;

    private String fromCodeId;

    private Date createTime;

    private Date updateTime;

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public String getUrlRemark() {
        return urlRemark;
    }

    public void setUrlRemark(String urlRemark) {
        this.urlRemark = urlRemark;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(String fromCodeId) {
        this.fromCodeId = fromCodeId;
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