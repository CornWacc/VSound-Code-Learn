package com.corn.vsound.service.code.strategy.methodorder;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeMethodOrder;
import com.corn.vsound.dao.mapper.CodeMethodOrderMapper;
import com.corn.vsound.facade.code.order.CodeMethodOrderCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author yyc
 * @apiNote 源码方法入参更新策略
 * @createTime 2020/1/9
 */
@Service
public class CodeMethodOrderUpdateStrategy implements BaseCUDInterface<CodeMethodOrderCUDOrder> {

    @Autowired
    private CodeMethodOrderMapper codeMethodOrderMapper;

    @Override
    public void execute(CodeMethodOrderCUDOrder order) {

        String orderId = order.getCodeMethodOrderId();
        CodeMethodOrder codeMethodOrder = codeMethodOrderMapper.selectByPrimaryKey(orderId);
        if(ObjectUtils.isEmpty(codeMethodOrder)){
            throw new BizError("该源码入参不存在,请刷新页面!");
        }

        BeanCopier.create(order.getClass(),codeMethodOrder.getClass(),false).copy(order,codeMethodOrder,null);
        codeMethodOrderMapper.updateByPrimaryKeySelective(codeMethodOrder);
    }
}