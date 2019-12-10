package com.corn.vsound.service.code.strategy.codemethod;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

@Service
public class CodeMethodUpdateStrategy implements BaseCUDInterface<CodeMethodCUDOrder> {

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Override
    public void execute(CodeMethodCUDOrder order) {

        CodeMethod codeMethod = new CodeMethod();
        BeanCopier.create(CodeMethodCUDOrder.class,CodeMethod.class,false).copy(order,codeMethod,null);

        codeMethodMapper.updateByPrimaryKeySelective(codeMethod);
    }
}