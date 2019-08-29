package com.corn.vsound.code.method;

import com.corn.boot.base.BaseOrder;
import com.corn.vsound.code.info.CodeMethodInfo;

public class CodeMethodCUDOrder extends BaseOrder {

    private static final long serialVersionUID = 6741243849046526454L;

    private String type;

    private String codeId;

    private String methodId;

    private CodeMethodInfo codeMethodInfo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public CodeMethodInfo getCodeMethodInfo() {
        return codeMethodInfo;
    }

    public void setCodeMethodInfo(CodeMethodInfo codeMethodInfo) {
        this.codeMethodInfo = codeMethodInfo;
    }
}
