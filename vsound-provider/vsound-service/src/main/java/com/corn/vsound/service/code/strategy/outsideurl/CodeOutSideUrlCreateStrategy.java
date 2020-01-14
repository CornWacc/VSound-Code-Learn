package com.corn.vsound.service.code.strategy.outsideurl;

import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.base.strategy.CUDOrder;
import com.corn.boot.util.DateUtils;
import com.corn.vsound.dao.entity.CodeOutSideUrl;
import com.corn.vsound.dao.mapper.CodeOutSideUrlMapper;
import com.corn.vsound.facade.code.order.CodeOutSideUrlCUDOrder;
import com.corn.vsound.facade.code.result.CodeOutSideUrlCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/12
 */
@Service
public class CodeOutSideUrlCreateStrategy implements CudExecuteInterface<CodeOutSideUrlCUDOrder, CodeOutSideUrlCUDResult> {

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Override
    public CodeOutSideUrlCUDResult execute(CodeOutSideUrlCUDOrder order) {

        CodeOutSideUrl codeOutSideUrl = new CodeOutSideUrl();
        BeanCopier.create(order.getClass(),codeOutSideUrl.getClass(),false).copy(order,codeOutSideUrl,null);
        codeOutSideUrl.setUrlId("cosu"+ DateUtils.dateForMateForConnect(new Date()));

        codeOutSideUrlMapper.insertSelective(codeOutSideUrl);
        return new CodeOutSideUrlCUDResult();
    }
}
