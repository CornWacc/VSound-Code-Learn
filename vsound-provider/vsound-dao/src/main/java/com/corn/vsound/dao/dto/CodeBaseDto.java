package com.corn.vsound.dao.dto;

import com.corn.vsound.dao.info.CodeMethodDtoInfo;
import com.corn.vsound.dao.info.CodeOutSideUrlDtoInfo;
import com.corn.vsound.dao.info.CodeParameterDtoInfo;

import java.util.List;

/**
 * @author yyc
 * @apiNote
 * @createTime 2020/1/15
 */
public class CodeBaseDto {

    private String codeId;

    private String codeName;

    private String codeType;

    private String fromProjectId;

    private String codeRemark;

    private List<CodeMethodDtoInfo> methodDtoInfoList;

    private List<CodeOutSideUrlDtoInfo> outSideUrlDtoInfoList;

    private List<CodeParameterDtoInfo> parameterDtoInfoList;

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

    public String getFromProjectId() {
        return fromProjectId;
    }

    public void setFromProjectId(String fromProjectId) {
        this.fromProjectId = fromProjectId;
    }

    public String getCodeRemark() {
        return codeRemark;
    }

    public void setCodeRemark(String codeRemark) {
        this.codeRemark = codeRemark;
    }

    public List<CodeMethodDtoInfo> getMethodDtoInfoList() {
        return methodDtoInfoList;
    }

    public void setMethodDtoInfoList(List<CodeMethodDtoInfo> methodDtoInfoList) {
        this.methodDtoInfoList = methodDtoInfoList;
    }

    public List<CodeOutSideUrlDtoInfo> getOutSideUrlDtoInfoList() {
        return outSideUrlDtoInfoList;
    }

    public void setOutSideUrlDtoInfoList(List<CodeOutSideUrlDtoInfo> outSideUrlDtoInfoList) {
        this.outSideUrlDtoInfoList = outSideUrlDtoInfoList;
    }

    public List<CodeParameterDtoInfo> getParameterDtoInfoList() {
        return parameterDtoInfoList;
    }

    public void setParameterDtoInfoList(List<CodeParameterDtoInfo> parameterDtoInfoList) {
        this.parameterDtoInfoList = parameterDtoInfoList;
    }
}
