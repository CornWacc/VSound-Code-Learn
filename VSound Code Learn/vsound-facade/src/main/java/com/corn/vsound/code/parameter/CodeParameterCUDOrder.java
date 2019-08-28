package com.corn.vsound.code.parameter;

import com.corn.boot.base.BaseOrder;
import com.corn.vsound.code.info.CodeParameterInfo;

public class CodeParameterCUDOrder extends BaseOrder {

    private String codeId;

    private String parameterId;

    private String type;

    private CodeParameterInfo codeParameterInfo;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CodeParameterInfo getCodeParameterInfo() {
        return codeParameterInfo;
    }

    public void setCodeParameterInfo(CodeParameterInfo codeParameterInfo) {
        this.codeParameterInfo = codeParameterInfo;
    }
}
