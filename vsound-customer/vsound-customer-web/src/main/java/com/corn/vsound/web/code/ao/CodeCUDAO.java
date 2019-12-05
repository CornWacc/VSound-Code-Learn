package com.corn.vsound.web.code.ao;

public class CodeCUDAO {

    private String cudType;

    private String codeName;

    private String codeType;

    private Integer codeLevel;

    private String projectId;

    public String getCudType() {
        return cudType;
    }

    public void setCudType(String cudType) {
        this.cudType = cudType;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public Integer getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(Integer codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
