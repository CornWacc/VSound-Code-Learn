package com.corn.vsound.code.url;

import com.corn.boot.base.BaseRes;
import com.corn.vsound.code.info.CodeOutSideUrlInfo;

import java.util.List;

public class CodeUrlCUDResult extends BaseRes {

    private List<CodeOutSideUrlInfo> codeOutSideUrlInfoList;

    public List<CodeOutSideUrlInfo> getCodeOutSideUrlInfoList() {
        return codeOutSideUrlInfoList;
    }

    public void setCodeOutSideUrlInfoList(List<CodeOutSideUrlInfo> codeOutSideUrlInfoList) {
        this.codeOutSideUrlInfoList = codeOutSideUrlInfoList;
    }
}
