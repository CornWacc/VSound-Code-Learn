package com.corn.vsound.dao.entity;

import java.util.Date;

public class CodeOutSideUrl {
    private Integer id;

    private Integer urlId;

    private String urlRemark;

    private String urlPath;

    private Integer fromCodeId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public String getUrlRemark() {
        return urlRemark;
    }

    public void setUrlRemark(String urlRemark) {
        this.urlRemark = urlRemark == null ? null : urlRemark.trim();
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath == null ? null : urlPath.trim();
    }

    public Integer getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(Integer fromCodeId) {
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