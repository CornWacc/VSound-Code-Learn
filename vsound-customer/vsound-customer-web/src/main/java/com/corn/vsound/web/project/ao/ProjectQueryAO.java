package com.corn.vsound.web.project.ao;

import com.corn.vsound.facade.enums.ClassTypeEnum;

public class ProjectQueryAO{

    private String projectId;

    private String keyWord;

    private ClassTypeEnum codeType;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public ClassTypeEnum getCodeType() {
        return codeType;
    }

    public void setCodeType(ClassTypeEnum codeType) {
        this.codeType = codeType;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
