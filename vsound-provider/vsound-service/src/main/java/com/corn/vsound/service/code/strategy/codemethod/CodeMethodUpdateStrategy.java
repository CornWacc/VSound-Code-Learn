package com.corn.vsound.service.code.strategy.codemethod;

import com.alibaba.fastjson.JSON;
import com.corn.boot.base.strategy.BaseCUDInterface;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.dto.CodeMethodOrderDto;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.entity.CodeMethodOrder;
import com.corn.vsound.dao.info.CodeMethodOrderDtoInfo;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.dao.mapper.CodeMethodOrderMapper;
import com.corn.vsound.facade.code.order.CodeMethodCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CodeMethodUpdateStrategy implements BaseCUDInterface<CodeMethodCUDOrder> {

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Autowired
    private CodeMethodOrderMapper codeMethodOrderMapper;

    @Override
    public void execute(CodeMethodCUDOrder order) {

        CodeMethodOrderDto codeMethodOrderDto = codeMethodMapper.findCodeMethodByMethodId(order.getMethodId());
        if(ObjectUtils.isEmpty(codeMethodOrderDto)){
            throw new BizError("需要更新的方法不存在！请刷新页面!");
        }

        BeanCopier.create(CodeMethodCUDOrder.class, CodeMethodOrderDto.class, false).copy(order, codeMethodOrderDto, null);
        codeMethodMapper.updateByPrimaryKeySelective(codeMethodOrderDto);

        List<CodeMethodOrderDtoInfo> codeMethodOrders  = codeMethodOrderDto.getOrderList();
        if (!ObjectUtils.isEmpty(codeMethodOrders)) {


        }
    }
}
