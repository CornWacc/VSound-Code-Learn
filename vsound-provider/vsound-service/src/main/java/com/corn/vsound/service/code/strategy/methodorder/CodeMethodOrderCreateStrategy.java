package com.corn.vsound.service.code.strategy.methodorder;

import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.vsound.dao.entity.CodeMethodOrder;
import com.corn.vsound.dao.mapper.CodeMethodOrderMapper;
import com.corn.vsound.facade.code.order.CodeMethodOrderCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yyc
 * @apiNote 源码方法入参新增策略
 * @createTime 2020/1/9
 */
@Service
public class CodeMethodOrderCreateStrategy implements BaseCUDInterface<CodeMethodOrderCUDOrder> {

    @Autowired
    private CodeMethodOrderMapper codeMethodOrderMapper;

    @Override
    public void execute(CodeMethodOrderCUDOrder order) {

        CodeMethodOrder codeMethodOrder = new CodeMethodOrder();
        BeanCopier.create(order.getClass(),codeMethodOrder.getClass(),false).copy(order,codeMethodOrder,null);
        codeMethodOrder.setCreateTime(new Date());
        codeMethodOrderMapper.insertSelective(codeMethodOrder);
    }
}
