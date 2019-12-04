package com.corn.vsound.service.code.strategy;


import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.facade.code.order.CodeCUDOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeCreateStrategy implements CodeStrategyInterface{

    @Autowired
    private CodeBaseMapper codeBaseMapper;


    @Override
    public void execute(CodeCUDOrder codeCUDOrder) {

    }
}
