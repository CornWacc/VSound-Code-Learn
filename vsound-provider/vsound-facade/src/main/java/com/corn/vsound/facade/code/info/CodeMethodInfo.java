package com.corn.vsound.facade.code.info;

import com.corn.boot.base.pojobase.Base;
import com.corn.vsound.facade.enums.ActionScopeEnum;
import com.corn.vsound.facade.enums.CodeMethodBaseTypeEnum;
import com.corn.vsound.facade.enums.YNEnum;

import java.util.List;

/**
 * @author yyc
 * @apiNote 源码方法实体
 * */
public class CodeMethodInfo extends Base {

    private static final long serialVersionUID = 6567091441455143861L;

    /**
     * 方法id
     * */
    private String methodId;

    /**
     * 方法名称
     * */
    private String methodName;

    /**
     * 方法使用方式(注释)
     * */
    private String methodUsage;

    /**
     * 方法返回参数
     * */
    private String methodResult;

    /**
     * 方法基础类型
     * */
    private CodeMethodBaseTypeEnum methodBaseType;

    /**
     * 方法是否常用
     * */
    private YNEnum methodCommonUse;

    /**
     * 方法是否为构造方法
     * */
    private YNEnum methodIsConstruct;

    /**
     * 方法是否重写
     * */
    private YNEnum methodIsOverWrite;

    /**
     * 方法作用域
     * */
    private ActionScopeEnum actionScope;

    /**
     * 所属源码id
     * */
    private String fromCodeId;

    /**
     * 方法入参
     * */
    private List<CodeMethodOrderInfo> codeMethodOrderInfoList;

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

    public YNEnum getMethodIsConstruct() {
        return methodIsConstruct;
    }

    public void setMethodIsConstruct(YNEnum methodIsConstruct) {
        this.methodIsConstruct = methodIsConstruct;
    }

    public YNEnum getMethodIsOverWrite() {
        return methodIsOverWrite;
    }

    public void setMethodIsOverWrite(YNEnum methodIsOverWrite) {
        this.methodIsOverWrite = methodIsOverWrite;
    }

    public ActionScopeEnum getActionScope() {
        return actionScope;
    }

    public void setActionScope(ActionScopeEnum actionScope) {
        this.actionScope = actionScope;
    }

    public String getFromCodeId() {
        return fromCodeId;
    }

    public void setFromCodeId(String fromCodeId) {
        this.fromCodeId = fromCodeId;
    }

    public List<CodeMethodOrderInfo> getCodeMethodOrderInfoList() {
        return codeMethodOrderInfoList;
    }

    public void setCodeMethodOrderInfoList(List<CodeMethodOrderInfo> codeMethodOrderInfoList) {
        this.codeMethodOrderInfoList = codeMethodOrderInfoList;
    }
}
