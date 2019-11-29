package com.corn.vsound.facade.project.order;

import com.corn.boot.base.pojobase.BaseOrder;

/**
 * @author yyc
 */
public class ProjectListQueryOrder extends BaseOrder {

    private static final long serialVersionUID = -4805344666148072186L;

    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
