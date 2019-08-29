package com.corn.vsound.code.method;

import com.corn.boot.base.BaseRes;
import com.corn.vsound.code.info.CodeMethodInfo;

import java.util.List;

public class CodeMethodCUDResult extends BaseRes {

    private static final long serialVersionUID = -5064985666151823335L;
    private List<CodeMethodInfo> codeMethodInfoList;

    public List<CodeMethodInfo> getCodeMethodInfoList() {
        return codeMethodInfoList;
    }

    public void setCodeMethodInfoList(List<CodeMethodInfo> codeMethodInfoList) {
        this.codeMethodInfoList = codeMethodInfoList;
    }
}
