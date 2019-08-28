package com.corn.vsound.code.info;

import com.corn.boot.base.Base;

public class CodeOutSideUrlInfo extends Base {
    private static final long serialVersionUID = 7715020662815255972L;

    private String urlId;

    private String urlRemark;

    private String fromCodeId;

    private String urlPath;

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

    public String getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(String fromCodeId) {
        this.fromCodeId = fromCodeId;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
