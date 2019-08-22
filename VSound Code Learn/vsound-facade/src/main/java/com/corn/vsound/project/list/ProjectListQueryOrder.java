package com.corn.vsound.project.list;

import com.corn.boot.base.BaseOrder;

/**
 * @author yyc
 * @apiNote 项目列表查询入参
 * */
public class ProjectListQueryOrder extends BaseOrder {
    private static final long serialVersionUID = 2137448373466286779L;

    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
