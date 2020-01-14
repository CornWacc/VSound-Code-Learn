package com.corn.vsound.service.code.strategy.methodorder;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeMethodOrder;
import com.corn.vsound.dao.mapper.CodeMethodOrderMapper;
import com.corn.vsound.facade.code.order.CodeMethodOrderCUDOrder;
import com.corn.vsound.facade.code.result.CodeMethodCUDResult;
import com.corn.vsound.facade.code.result.CodeMethodOrderCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author yyc
 * @apiNote 源码方法入参删除策略
 * @createTime 2020/1/9
 */
@Service
public class CodeMethodOrderDeleteStrategy implements CudExecuteInterface<CodeMethodOrderCUDOrder, CodeMethodOrderCUDResult> {

    @Autowired
    private CodeMethodOrderMapper codeMethodOrderMapper;

    @Override
    public CodeMethodOrderCUDResult execute(CodeMethodOrderCUDOrder order) {

        String orderId = order.getCodeMethodOrderId();
        CodeMethodOrder codeMethodOrder = codeMethodOrderMapper.selectByPrimaryKey(orderId);
        if(ObjectUtils.isEmpty(codeMethodOrder)){
            throw new BizError("该源码入参不存在,请刷新页面!");
        }
        codeMethodOrderMapper.deleteByPrimaryKey(orderId);
        return new CodeMethodOrderCUDResult();
    }
}
