package com.corn.vsound.service.code.strategy.codemethod;

import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.base.strategy.CUDOrder;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.dto.CodeMethodOrderDto;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.dao.mapper.CodeMethodOrderMapper;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

@Service
public class CodeMethodDeleteStrategy implements CudExecuteInterface<CodeMethodCUDOrder, CodeMethodCUDResult> {

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Autowired
    private CodeMethodOrderMapper codeMethodOrderMapper;

    @Override
    public CodeMethodCUDResult execute(CodeMethodCUDOrder order) {

        CodeMethodOrderDto codeMethod = codeMethodMapper.findCodeMethodByMethodId(order.getMethodId());
        if(ObjectUtils.isEmpty(codeMethod)){
            throw new BizError("该源码方法不存在,请刷新页面!");
        }

        codeMethodMapper.deleteByPrimaryKey(order.getMethodId());

        if(!ObjectUtils.isEmpty(codeMethod.getOrderList())){
            codeMethodOrderMapper.batchDeleteMethodOrder(Arrays.asList(order.getMethodId()));
        }
        return new CodeMethodCUDResult();
    }
}
