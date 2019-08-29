package com.corn.vsound.code.parameter;

import com.corn.boot.base.BaseRes;
import com.corn.vsound.code.info.CodeParameterInfo;

import java.util.List;

public class CodeParameterCUDResult extends BaseRes {

    private static final long serialVersionUID = -2533221368896308161L;
    private List<CodeParameterInfo> codeParameterInfoList;

    public List<CodeParameterInfo> getCodeParameterInfoList() {
        return codeParameterInfoList;
    }

    public void setCodeParameterInfoList(List<CodeParameterInfo> codeParameterInfoList) {
        this.codeParameterInfoList = codeParameterInfoList;
    }
}
