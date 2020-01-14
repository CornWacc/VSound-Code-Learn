package com.corn.vsound.facade.code.order;

import com.corn.boot.annotations.CudParamsCheck;
import com.corn.boot.base.strategy.CUDOrder;
import com.corn.boot.enums.CudTypeEnum;

/**
 * @author yyc
 * @apiNote 源码方法入参CUDorder
 * @createTime 2020/1/9
 */
public class CodeMethodOrderCUDOrder extends CUDOrder {

    private static final long serialVersionUID = 6679573441308001313L;

    @CudParamsCheck(cudTypes = {CudTypeEnum.DELETE,CudTypeEnum.UPDATE},errorMsg = "源码方法入参Id不能为空!")
    private String codeMethodOrderId;

    private String codeMethodOrderName;

    private String codeMethodOrderClassType;

    private String codeMethodOrderType;

    private String codeMethodId;

    public String getCodeMethodOrderId() {
        return codeMethodOrderId;
    }

    public void setCodeMethodOrderId(String codeMethodOrderId) {
        this.codeMethodOrderId = codeMethodOrderId;
    }

    public String getCodeMethodOrderName() {
        return codeMethodOrderName;
    }

    public void setCodeMethodOrderName(String codeMethodOrderName) {
        this.codeMethodOrderName = codeMethodOrderName;
    }

    public String getCodeMethodOrderClassType() {
        return codeMethodOrderClassType;
    }

    public void setCodeMethodOrderClassType(String codeMethodOrderClassType) {
        this.codeMethodOrderClassType = codeMethodOrderClassType;
    }

    public String getCodeMethodOrderType() {
        return codeMethodOrderType;
    }

    public void setCodeMethodOrderType(String codeMethodOrderType) {
        this.codeMethodOrderType = codeMethodOrderType;
    }

    public String getCodeMethodId() {
        return codeMethodId;
    }

    public void setCodeMethodId(String codeMethodId) {
        this.codeMethodId = codeMethodId;
    }
}
