package com.corn.vsound.code.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.code.create.CodeAddOrder;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.entity.CodeExtra;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.dao.mapper.CodeExtraMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@DoTranscation
public class CodeAddDelegate extends AbstractBizService<CodeAddOrder, CodeAddResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Autowired
    private CodeExtraMapper codeExtraMapper;

    @Override
    protected CodeAddResult initResult() {
        return new CodeAddResult();
    }

    @Override
    protected void orderCheck(CodeAddOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(CodeAddOrder order, CodeAddResult result) {

        String codeId = AppUtils.correspondingCreate("code");

        CodeBase codeBase = new CodeBase();
        BeanUtils.copyProperties(order,codeBase);
        codeBase.setCodeId(codeId);
        codeBase.setCreateTime(new Date());
        System.out.println(codeBase);

        codeBaseMapper.insertSelective(codeBase);

        CodeExtra codeExtra = new CodeExtra();
        codeExtra.setCodeId(codeId);
        codeExtra.setCreateTime(new Date());
        codeExtraMapper.insertSelective(codeExtra);
    }
}
