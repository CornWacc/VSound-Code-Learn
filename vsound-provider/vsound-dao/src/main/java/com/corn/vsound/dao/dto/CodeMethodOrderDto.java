package com.corn.vsound.dao.dto;

import com.corn.boot.base.pojobase.Base;
import com.corn.vsound.dao.info.CodeMethodOrderDtoInfo;
import com.corn.vsound.facade.enums.ActionScopeEnum;
import com.corn.vsound.facade.enums.CodeMethodBaseTypeEnum;
import com.corn.vsound.facade.enums.YNEnum;

import java.util.List;

/**
 * @author yyc
 * @apiNote 方法与入参对应DTO
 * @createTime 2020/1/2
 */
public class CodeMethodOrderDto extends Base {

    private Integer id;

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

    private List<CodeMethodOrderDtoInfo> orderList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<CodeMethodOrderDtoInfo> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<CodeMethodOrderDtoInfo> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "CodeMethodOrderDto{" +
                "id=" + id +
                ", methodId='" + methodId + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodUsage='" + methodUsage + '\'' +
                ", methodResult='" + methodResult + '\'' +
                ", methodBaseType=" + methodBaseType +
                ", methodCommonUse=" + methodCommonUse +
                ", methodIsOverwrite=" + methodIsOverwrite +
                ", methodIsConstruct=" + methodIsConstruct +
                ", methodActionScope=" + methodActionScope +
                ", fromCodeId='" + fromCodeId + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
