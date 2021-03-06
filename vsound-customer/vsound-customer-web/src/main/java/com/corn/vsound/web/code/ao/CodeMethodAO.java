package com.corn.vsound.web.code.ao;

import com.corn.boot.enums.CudTypeEnum;
import com.corn.vsound.facade.code.info.CodeMethodOrderInfo;
import com.corn.vsound.facade.enums.ActionScopeEnum;
import com.corn.vsound.facade.enums.CodeMethodBaseTypeEnum;
import com.corn.vsound.facade.enums.YNEnum;

import java.util.List;

public class CodeMethodAO {

    private String methodId;

    private String methodName;

    private String methodUsage;

    private String methodResult;

    private CodeMethodBaseTypeEnum methodBaseType;

    private YNEnum methodCommonUse;

    private YNEnum methodIsOverwrite;

    private YNEnum methodIsConstruct;

    private ActionScopeEnum methodActionScope;

    private String fromCodeId;

    private List<CodeMethodOrderInfo> methodOrders;

    private CudTypeEnum cudType;

    public CudTypeEnum getCudType() {
        return cudType;
    }

    public void setCudType(CudTypeEnum cudType) {
        this.cudType = cudType;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodUsage() {
        return methodUsage;
    }

    public void setMethodUsage(String methodUsage) {
        this.methodUsage = methodUsage;
    }

    public String getMethodResult() {
        return methodResult;
    }

    public void setMethodResult(String methodResult) {
        this.methodResult = methodResult;
    }

    public CodeMethodBaseTypeEnum getMethodBaseType() {
        return methodBaseType;
    }

    public void setMethodBaseType(CodeMethodBaseTypeEnum methodBaseType) {
        this.methodBaseType = methodBaseType;
    }

    public YNEnum getMethodCommonUse() {
        return methodCommonUse;
    }

    public void setMethodCommonUse(YNEnum methodCommonUse) {
        this.methodCommonUse = methodCommonUse;
    }

    public YNEnum getMethodIsOverwrite() {
        return methodIsOverwrite;
    }

    public void setMethodIsOverwrite(YNEnum methodIsOverwrite) {
        this.methodIsOverwrite = methodIsOverwrite;
    }

    public YNEnum getMethodIsConstruct() {
        return methodIsConstruct;
    }

    public void setMethodIsConstruct(YNEnum methodIsConstruct) {
        this.methodIsConstruct = methodIsConstruct;
    }

    public ActionScopeEnum getMethodActionScope() {
        return methodActionScope;
    }

    public void setMethodActionScope(ActionScopeEnum methodActionScope) {
        this.methodActionScope = methodActionScope;
    }

    public String getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(String fromCodeId) {
        this.fromCodeId = fromCodeId;
    }

    public List<CodeMethodOrderInfo> getMethodOrders() {
        return methodOrders;
    }

    public void setMethodOrders(List<CodeMethodOrderInfo> methodOrders) {
        this.methodOrders = methodOrders;
    }
}
