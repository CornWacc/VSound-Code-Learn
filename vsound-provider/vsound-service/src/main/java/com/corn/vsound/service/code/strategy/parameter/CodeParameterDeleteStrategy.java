package com.corn.vsound.service.code.strategy.parameter;

import com.corn.boot.base.strategy.CudExecuteInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeParameter;
import com.corn.vsound.dao.mapper.CodeParameterMapper;
import com.corn.vsound.facade.code.order.CodeParameterCUDOrder;
import com.corn.vsound.facade.code.result.CodeParameterCUDResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/11
 */
@Service
public class CodeParameterDeleteStrategy implements CudExecuteInterface<CodeParameterCUDOrder, CodeParameterCUDResult> {

    @Autowired
    private CodeParameterMapper codeParameterMapper;

    @Override
    public CodeParameterCUDResult execute(CodeParameterCUDOrder order) {
        CodeParameter codeParameter = codeParameterMapper.findCodeParameterByParameterId(order.getParameterId());
        if(ObjectUtils.isEmpty(codeParameter)){
            throw new BizError("当前类参数不存在!请刷新一下页面!");
        }

        codeParameterMapper.deleteByPrimaryKey(codeParameter.getParameterId());

        return new CodeParameterCUDResult();
    }
}
