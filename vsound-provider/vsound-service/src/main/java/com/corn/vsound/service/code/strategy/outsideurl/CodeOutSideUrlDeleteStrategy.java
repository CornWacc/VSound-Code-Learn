package com.corn.vsound.service.code.strategy.outsideurl;

import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeOutSideUrl;
import com.corn.vsound.dao.mapper.CodeOutSideUrlMapper;
import com.corn.vsound.facade.code.order.CodeOutSideUrlCUDOrder;
import com.corn.vsound.facade.code.result.CodeOutSideUrlCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/12
 */
@Service
public class CodeOutSideUrlDeleteStrategy implements CudExecuteInterface<CodeOutSideUrlCUDOrder, CodeOutSideUrlCUDResult> {

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Override
    public CodeOutSideUrlCUDResult execute(CodeOutSideUrlCUDOrder order) {
        CodeOutSideUrl codeOutSideUrlByUrlId = codeOutSideUrlMapper.findCodeOutSideUrlByUrlId(order.getUrlId());
        if(ObjectUtils.isEmpty(codeOutSideUrlByUrlId)){
            throw new BizError("当前源码外链不存在！");
        }
        codeOutSideUrlMapper.deleteByPrimaryKey(codeOutSideUrlByUrlId.getUrlId());

        return new CodeOutSideUrlCUDResult();
    }
}
