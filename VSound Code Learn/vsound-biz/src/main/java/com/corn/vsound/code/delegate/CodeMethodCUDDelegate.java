package com.corn.vsound.code.delegate;

import com.alibaba.fastjson.JSON;
import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.base.CUDInterface;
import com.corn.vsound.code.info.CodeMethodInfo;
import com.corn.vsound.code.method.CodeMethodCUDOrder;
import com.corn.vsound.code.method.CodeMethodCUDResult;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;


@Service
@DoTranscation
public class CodeMethodCUDDelegate extends AbstractBizService<CodeMethodCUDOrder, CodeMethodCUDResult> implements CUDInterface<CodeMethodCUDOrder> {

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Override
    protected CodeMethodCUDResult initResult() {
        return new CodeMethodCUDResult();
    }

    @Override
    protected void orderCheck(CodeMethodCUDOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(CodeMethodCUDOrder order, CodeMethodCUDResult result) {

        cud(order.getType(),order.getMethodId(),order);

        List<CodeMethod> codeMethods = codeMethodMapper.findCodeMethodByCodeId(order.getCodeId());
        if(!ObjectUtils.isEmpty(codeMethods)){

            List<CodeMethodInfo> list = JSON.parseArray(JSON.toJSONString(codeMethods), CodeMethodInfo.class);
            result.setCodeMethodInfoList(list);
        }else {
            result.setCodeMethodInfoList(new ArrayList<>());
        }

    }

    @Override
    public void add(CodeMethodCUDOrder order) {
        CodeMethod codeMethod = new CodeMethod();
        if(!ObjectUtils.isEmpty(order.getCodeMethodInfo())){
            BeanUtils.copyProperties(order.getCodeMethodInfo(),codeMethod);
        }else{
            throw new BizError("新增方法入参不能为空");
        }
        codeMethod.setFromCodeId(order.getCodeId());
        codeMethod.setMethodId(AppUtils.correspondingCreate("md"));
        codeMethodMapper.insertSelective(codeMethod);
    }

    @Override
    public void del(String id) {
        codeMethodMapper.delCodeMethodByMehodId(id);
    }

    @Override
    public void update(CodeMethodCUDOrder order) {
        CodeMethod codeMethod = new CodeMethod();
        if(!ObjectUtils.isEmpty(order.getCodeMethodInfo())){
            BeanUtils.copyProperties(order.getCodeMethodInfo(),codeMethod);
            codeMethodMapper.updateByPrimaryKey(codeMethod);
        }
    }
}
