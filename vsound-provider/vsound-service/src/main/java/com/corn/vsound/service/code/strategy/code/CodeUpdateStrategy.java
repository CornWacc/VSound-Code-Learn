package com.corn.vsound.service.code.strategy.code;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import com.corn.vsound.facade.code.result.CodeCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CodeUpdateStrategy implements CudExecuteInterface<CodeCUDOrder, CodeCUDResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Override
    public CodeCUDResult execute(CodeCUDOrder codeCUDOrder) {

        String codeId = codeCUDOrder.getCodeId();
        CodeBase codeBase = codeBaseMapper.findCodeBaseByCodeId(codeId);
        if(ObjectUtils.isEmpty(codeBase)){
            throw new BizError("该源码不存在,请刷新页面!");
        }

        BeanCopier.create(CodeCUDOrder.class,CodeBase.class,false).copy(codeCUDOrder,codeBase,null);
        codeBaseMapper.updateByPrimaryKeySelective(codeBase);
        return new CodeCUDResult();

    }
}
