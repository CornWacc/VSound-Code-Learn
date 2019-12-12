package com.corn.vsound.facade.code.result;

import com.corn.boot.base.pojobase.BaseRes;
import com.corn.vsound.facade.code.info.CodeParameterInfo;

import java.util.List;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/11
 */
public class CodeParameterListQueryResult extends BaseRes {
    private static final long serialVersionUID = -3321962093355030880L;

    private List<CodeParameterInfo> codeParameterInfoList;

    public List<CodeParameterInfo> getCodeParameterInfoList() {
        return codeParameterInfoList;
    }

    public void setCodeParameterInfoList(List<CodeParameterInfo> codeParameterInfoList) {
        this.codeParameterInfoList = codeParameterInfoList;
    }
}
