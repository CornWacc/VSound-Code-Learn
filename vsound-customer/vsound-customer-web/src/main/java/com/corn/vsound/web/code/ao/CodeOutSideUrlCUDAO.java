package com.corn.vsound.web.code.ao;

import com.corn.boot.enums.CudTypeEnum;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/12
 */
public class CodeOutSideUrlCUDAO {

    private String urlId;

    private String urlRemark;

    private String urlPath;

    private String fromCodeId;

    private CudTypeEnum cudType;

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

    public CudTypeEnum getCudType() {
        return cudType;
    }

    public void setCudType(CudTypeEnum cudType) {
        this.cudType = cudType;
    }
}
