package com.corn.vsound.code.list;

import com.corn.boot.base.BaseRes;
import com.corn.vsound.code.info.CodeInfo;

import java.util.List;


public class CodeListQueryByKeyWordResult extends BaseRes {
    private static final long serialVersionUID = -8568076750780337824L;

    private String projectName;

    List<CodeInfo> codeInfoList;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<CodeInfo> getCodeInfoList() {
        return codeInfoList;
    }

    public void setCodeInfoList(List<CodeInfo> codeInfoList) {
        this.codeInfoList = codeInfoList;
    }
}
