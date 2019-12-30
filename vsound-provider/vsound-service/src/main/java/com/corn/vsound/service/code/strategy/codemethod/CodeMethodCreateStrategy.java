package com.corn.vsound.service.code.strategy.codemethod;

import com.alibaba.fastjson.JSON;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.util.DateUtils;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.entity.CodeMethodOrder;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.dao.mapper.CodeMethodOrderMapper;
import com.corn.vsound.facade.code.info.CodeMethodOrderInfo;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
public class CodeMethodCreateStrategy implements BaseCUDInterface<CodeMethodCUDOrder> {

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Autowired
    private CodeMethodOrderMapper codeMethodOrderMapper;

    @Override
    public void execute(CodeMethodCUDOrder order) {

        CodeMethod codeMethod = new CodeMethod();
        BeanCopier.create(CodeMethodCUDOrder.class,CodeMethod.class,false).copy(order,codeMethod,null);
        codeMethod.setMethodId("mtd"+ DateUtils.dateForMateForConnect(new Date()));
        codeMethodMapper.insertSelective(codeMethod);

        List<CodeMethodOrderInfo> codeMethodOrderInfos = order.getMethodOrders();
        if(!ObjectUtils.isEmpty(codeMethodOrderInfos)){
            for(CodeMethodOrderInfo info : codeMethodOrderInfos){
                info.setCodeMethodOrderId("mord"+DateUtils.dateForMateForConnect(new Date()));
                info.setCodeMethodId(codeMethod.getMethodId());
                info.setCreateTime(new Date());
            }
            List<CodeMethodOrder> codeMethodOrderList = JSON.parseArray(JSON.toJSONString(codeMethodOrderInfos),CodeMethodOrder.class);
            codeMethodOrderMapper.batchInsert(codeMethodOrderList);
        }
    }
}
