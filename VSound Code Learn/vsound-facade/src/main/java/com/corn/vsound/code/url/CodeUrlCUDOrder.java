package com.corn.vsound.code.url;

import com.corn.boot.base.BaseOrder;
import com.corn.vsound.code.info.CodeOutSideUrlInfo;


public class CodeUrlCUDOrder extends BaseOrder {

    private String type;

    private String codeId;

    private String urlId;

    private CodeOutSideUrlInfo codeOutSideUrlInfo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public CodeOutSideUrlInfo getCodeOutSideUrlInfo() {
        return codeOutSideUrlInfo;
    }

    public void setCodeOutSideUrlInfo(CodeOutSideUrlInfo codeOutSideUrlInfo) {
        this.codeOutSideUrlInfo = codeOutSideUrlInfo;
    }
}
