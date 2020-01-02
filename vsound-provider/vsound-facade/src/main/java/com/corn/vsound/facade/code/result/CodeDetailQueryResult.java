package com.corn.vsound.facade.code.result;

import com.corn.boot.base.pojobase.BaseRes;
import com.corn.vsound.facade.code.info.CodeMethodInfo;
import com.corn.vsound.facade.code.info.CodeOutSideUrlInfo;
import com.corn.vsound.facade.code.info.CodeParameterInfo;

import java.util.List;

/**
 * @author yyc
 * @apiNote 源码详情查看出参
 * */
public class CodeDetailQueryResult extends BaseRes {

    private static final long serialVersionUID = -8279680553541657492L;

    private String codeName;

    private String codeId;

    private String codeRemark;

    private String codeType;

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    private List<CodeMethodInfo> codeMethodInfoList;

    private List<CodeParameterInfo> codeParameterInfos;

    private List<CodeOutSideUrlInfo> codeOutSideUrlInfos;

    public List<CodeOutSideUrlInfo> getCodeOutSideUrlInfos() {
        return codeOutSideUrlInfos;
    }

    public void setCodeOutSideUrlInfos(List<CodeOutSideUrlInfo> codeOutSideUrlInfos) {
        this.codeOutSideUrlInfos = codeOutSideUrlInfos;
    }

    public List<CodeParameterInfo> getCodeParameterInfos() {
        return codeParameterInfos;
    }

    public void setCodeParameterInfos(List<CodeParameterInfo> codeParameterInfos) {
        this.codeParameterInfos = codeParameterInfos;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getCodeRemark() {
        return codeRemark;
    }

    public void setCodeRemark(String codeRemark) {
        this.codeRemark = codeRemark;
    }

    public List<CodeMethodInfo> getCodeMethodInfoList() {
        return codeMethodInfoList;
    }

    public void setCodeMethodInfoList(List<CodeMethodInfo> codeMethodInfoList) {
        this.codeMethodInfoList = codeMethodInfoList;
    }
}
