package com.corn.vsound.facade.code.result;

import com.corn.boot.base.pojobase.BaseRes;
import com.corn.vsound.facade.code.info.CodeOutSideUrlInfo;

import java.util.List;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/12
 */
public class CodeOutSideUrlListQueryResult extends BaseRes {
    private static final long serialVersionUID = -1543253470283017858L;

    private List<CodeOutSideUrlInfo> codeOutSideUrlInfoList;

    public List<CodeOutSideUrlInfo> getCodeOutSideUrlInfoList() {
        return codeOutSideUrlInfoList;
    }

    public void setCodeOutSideUrlInfoList(List<CodeOutSideUrlInfo> codeOutSideUrlInfoList) {
        this.codeOutSideUrlInfoList = codeOutSideUrlInfoList;
    }
}
