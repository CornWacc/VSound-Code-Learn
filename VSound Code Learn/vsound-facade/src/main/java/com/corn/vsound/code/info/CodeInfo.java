package com.corn.vsound.code.info;

import com.corn.boot.base.Base;

import java.util.List;


/**
 * @author yyc
 * @apiNote 源码实体
 * */
public class CodeInfo extends Base {
    private static final long serialVersionUID = 4656054130073287285L;

    private String codeId;

    private String codeName;

    private String codeType;

    private Integer codeLevel;

    private String codeProgram;

    private String usePosition;

    private String codeRemark;

    private List<CodeMethodInfo> codeMethods;

    private List<CodeOutSideUrlInfo> outSideUrl;

    private List<CodeParameterInfo> codeParameters;


    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
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

    public String getCodeProgram() {
        return codeProgram;
    }

    public void setCodeProgram(String codeProgram) {
        this.codeProgram = codeProgram;
    }

    public String getUsePosition() {
        return usePosition;
    }

    public void setUsePosition(String usePosition) {
        this.usePosition = usePosition;
    }

    public String getCodeRemark() {
        return codeRemark;
    }

    public void setCodeRemark(String codeRemark) {
        this.codeRemark = codeRemark;
    }

    public List<CodeMethodInfo> getCodeMethods() {
        return codeMethods;
    }

    public void setCodeMethods(List<CodeMethodInfo> codeMethods) {
        this.codeMethods = codeMethods;
    }

    public List<CodeOutSideUrlInfo> getOutSideUrl() {
        return outSideUrl;
    }

    public void setOutSideUrl(List<CodeOutSideUrlInfo> outSideUrl) {
        this.outSideUrl = outSideUrl;
    }

    public List<CodeParameterInfo> getCodeParameters() {
        return codeParameters;
    }

    public void setCodeParameters(List<CodeParameterInfo> codeParameters) {
        this.codeParameters = codeParameters;
    }
}
