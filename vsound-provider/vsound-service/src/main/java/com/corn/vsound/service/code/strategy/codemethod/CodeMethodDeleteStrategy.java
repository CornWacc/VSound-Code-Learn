package com.corn.vsound.service.code.strategy.codemethod;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CUDOrder;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CodeMethodDeleteStrategy implements BaseCUDInterface<CodeMethodCUDOrder> {

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Override
    public void execute(CodeMethodCUDOrder order) {

        CodeMethod codeMethod = codeMethodMapper.findCodeMethodByMethodId(order.getMethodId());
        if(ObjectUtils.isEmpty(codeMethod)){
            throw new BizError("该源码方法不存在,请刷新页面!");
        }

        codeMethodMapper.deleteByPrimaryKey(order.getMethodId());
    }
}
