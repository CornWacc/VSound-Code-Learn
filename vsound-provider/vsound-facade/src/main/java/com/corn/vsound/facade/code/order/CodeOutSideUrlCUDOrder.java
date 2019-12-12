package com.corn.vsound.facade.code.order;

import com.corn.boot.base.strategy.CUDOrder;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/11
 */
public class CodeOutSideUrlCUDOrder extends CUDOrder {
    private static final long serialVersionUID = 29646677700876356L;

    private String urlId;

    private String urlRemark;

    private String urlPath;

    private String fromCodeId;

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
}
