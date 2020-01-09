package com.corn.vsound.web.code.ao;

import com.corn.boot.base.pojobase.Base;

/**
 * @author yyc
 * @apiNote 源码方法入参CUDAO
 * @createTime 2020/1/9
 */
public class CodeMethodOrderCUDAO extends Base {

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
