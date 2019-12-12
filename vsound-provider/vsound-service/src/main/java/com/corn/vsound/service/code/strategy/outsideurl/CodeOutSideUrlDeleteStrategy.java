package com.corn.vsound.service.code.strategy.outsideurl;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeOutSideUrl;
import com.corn.vsound.dao.mapper.CodeOutSideUrlMapper;
import com.corn.vsound.facade.code.order.CodeOutSideUrlCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/12
 */
@Service
public class CodeOutSideUrlDeleteStrategy implements BaseCUDInterface<CodeOutSideUrlCUDOrder> {

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Override
    public void execute(CodeOutSideUrlCUDOrder order) {
        CodeOutSideUrl codeOutSideUrlByUrlId = codeOutSideUrlMapper.findCodeOutSideUrlByUrlId(order.getUrlId());
        if(ObjectUtils.isEmpty(codeOutSideUrlByUrlId)){
            throw new BizError("当前源码外链不存在！");
        }
        codeOutSideUrlMapper.deleteByPrimaryKey(codeOutSideUrlByUrlId.getUrlId());
    }
}
