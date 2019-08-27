package com.corn.vsound.code.codeparam;

import com.corn.boot.base.BaseOrder;
import com.corn.vsound.code.info.CodeMethodInfo;
import com.corn.vsound.code.info.CodeOutSideUrlInfo;
import com.corn.vsound.code.info.CodeParameterInfo;

import java.util.List;


/**
 * @author yyc
 * @apiNote 源码内容新增入参 方法/参数/链接
 * */
public class CodeParamsAddOrder extends BaseOrder {
    private static final long serialVersionUID = -3937042738643538887L;

    private String type;

    private List<CodeMethodInfo> codeMethodInfoList;

    private List<CodeOutSideUrlInfo> codeOutSideUrlInfos;

    private List<CodeParameterInfo> codeParameterInfos;

    private String codeId;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CodeMethodInfo> getCodeMethodInfoList() {
        return codeMethodInfoList;
    }

    public void setCodeMethodInfoList(List<CodeMethodInfo> codeMethodInfoList) {
        this.codeMethodInfoList = codeMethodInfoList;
    }

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
}
