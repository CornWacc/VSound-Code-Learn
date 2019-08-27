package com.corn.vsound.code.codeparam;

import com.corn.boot.base.BaseRes;
import com.corn.vsound.code.info.CodeMethodInfo;
import com.corn.vsound.code.info.CodeOutSideUrlInfo;
import com.corn.vsound.code.info.CodeParameterInfo;

import java.util.List;

public class CodeParamsAddResult extends BaseRes {
    private static final long serialVersionUID = 863324122350872219L;

    private List<CodeMethodInfo> codeMethodInfoList;

    private List<CodeParameterInfo> codeParameterInfos;

    private List<CodeOutSideUrlInfo> codeOutSideUrlInfos;

    public List<CodeMethodInfo> getCodeMethodInfoList() {
        return codeMethodInfoList;
    }

    public void setCodeMethodInfoList(List<CodeMethodInfo> codeMethodInfoList) {
        this.codeMethodInfoList = codeMethodInfoList;
    }

    public List<CodeParameterInfo> getCodeParameterInfos() {
        return codeParameterInfos;
    }

    public void setCodeParameterInfos(List<CodeParameterInfo> codeParameterInfos) {
        this.codeParameterInfos = codeParameterInfos;
    }

    public List<CodeOutSideUrlInfo> getCodeOutSideUrlInfos() {
        return codeOutSideUrlInfos;
    }

    public void setCodeOutSideUrlInfos(List<CodeOutSideUrlInfo> codeOutSideUrlInfos) {
        this.codeOutSideUrlInfos = codeOutSideUrlInfos;
    }
}
