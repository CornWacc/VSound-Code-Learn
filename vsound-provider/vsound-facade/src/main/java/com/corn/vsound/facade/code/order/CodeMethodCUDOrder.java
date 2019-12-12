package com.corn.vsound.facade.code.order;

import com.corn.boot.annotations.CudParamsCheck;
import com.corn.boot.base.strategy.CUDOrder;
import com.corn.boot.enums.CudTypeEnum;

public class CodeMethodCUDOrder extends CUDOrder {

    private static final long serialVersionUID = -2585905066420707215L;

    @CudParamsCheck(cudTypes = {CudTypeEnum.UPDATE,CudTypeEnum.DELETE},errorMsg = "方法id不能为空")
    private String methodId;

    @CudParamsCheck(cudTypes = {CudTypeEnum.CREATE},errorMsg = "方法名称不能为空")
    private String methodName;

    private String methodUsage;

    private String methodNotice;

    private String methodOrder;

    private String methodResult;

    private String isAbstract;

    private String methodCommonUse;

    private String fromCodeId;

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

    public String getMethodNotice() {
        return methodNotice;
    }

    public void setMethodNotice(String methodNotice) {
        this.methodNotice = methodNotice;
    }

    public String getMethodOrder() {
        return methodOrder;
    }

    public void setMethodOrder(String methodOrder) {
        this.methodOrder = methodOrder;
    }

    public String getMethodResult() {
        return methodResult;
    }

    public void setMethodResult(String methodResult) {
        this.methodResult = methodResult;
    }

    public String getIsAbstract() {
        return isAbstract;
    }

    public void setIsAbstract(String isAbstract) {
        this.isAbstract = isAbstract;
    }

    public String getMethodCommonUse() {
        return methodCommonUse;
    }

    public void setMethodCommonUse(String methodCommonUse) {
        this.methodCommonUse = methodCommonUse;
    }

    public String getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(String fromCodeId) {
        this.fromCodeId = fromCodeId;
    }
}
