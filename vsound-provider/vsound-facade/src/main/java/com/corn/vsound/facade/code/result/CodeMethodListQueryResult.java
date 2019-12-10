package com.corn.vsound.facade.code.result;

import com.corn.boot.base.pojobase.BaseRes;
import com.corn.vsound.facade.code.info.CodeMethodInfo;

import java.util.List;

public class CodeMethodListQueryResult extends BaseRes {
    private static final long serialVersionUID = -2820546382547276372L;

    private List<CodeMethodInfo> codeMethodInfoList;

    public List<CodeMethodInfo> getCodeMethodInfoList() {
        return codeMethodInfoList;
    }

    public void setCodeMethodInfoList(List<CodeMethodInfo> codeMethodInfoList) {
        this.codeMethodInfoList = codeMethodInfoList;
    }
}
