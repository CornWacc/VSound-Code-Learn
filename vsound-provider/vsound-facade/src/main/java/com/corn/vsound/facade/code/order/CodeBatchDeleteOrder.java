package com.corn.vsound.facade.code.order;

import com.corn.boot.base.pojobase.BaseOrder;

import java.util.List;

/**
 * @author yyc
 * @apiNote 源码批量删除
 * @createTime 2019/12/13
 */
public class CodeBatchDeleteOrder extends BaseOrder {

    private List<String> codeIds;

    public List<String> getCodeIds() {
        return codeIds;
    }

    public void setCodeIds(List<String> codeIds) {
        this.codeIds = codeIds;
    }
}
