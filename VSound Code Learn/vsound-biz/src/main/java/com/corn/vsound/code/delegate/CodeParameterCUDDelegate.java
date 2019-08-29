package com.corn.vsound.code.delegate;

import com.alibaba.fastjson.JSON;
import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.base.CUDInterface;
import com.corn.vsound.code.info.CodeParameterInfo;
import com.corn.vsound.code.parameter.CodeParameterCUDOrder;
import com.corn.vsound.code.parameter.CodeParameterCUDResult;
import com.corn.vsound.dao.entity.CodeParameter;
import com.corn.vsound.dao.mapper.CodeParameterMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@DoTranscation
public class CodeParameterCUDDelegate extends AbstractBizService<CodeParameterCUDOrder, CodeParameterCUDResult> implements CUDInterface<CodeParameterCUDOrder> {

    @Autowired
    private CodeParameterMapper codeParameterMapper;

    @Override
    protected CodeParameterCUDResult initResult() {
        return new CodeParameterCUDResult();
    }

    @Override
    protected void orderCheck(CodeParameterCUDOrder order) {
        if(ObjectUtils.isEmpty(order.getCodeParameterInfo())){
            throw new BizError("源码参数,源码参数实体不能为空!");
        }
        if(StringUtils.isBlank(order.getCodeId())){
            throw new BizError("源码参数,源码Id不能为空!");
        }
        order.orderCheck();
    }

    @Override
    protected void appBiz(CodeParameterCUDOrder order, CodeParameterCUDResult result) {

        cud(order.getType(),order.getParameterId(),order);

        List<CodeParameter> codeParameterList = codeParameterMapper.findParameterListByCodeId(order.getCodeId());
        if(!ObjectUtils.isEmpty(codeParameterList)){

            List<CodeParameterInfo> codeParameterInfos = JSON.parseArray(JSON.toJSONString(codeParameterList),CodeParameterInfo.class);
            result.setCodeParameterInfoList(codeParameterInfos);
        }else{
            result.setCodeParameterInfoList(new ArrayList<>());
        }
    }

    @Override
    public void add(CodeParameterCUDOrder order) {

        CodeParameter codeParameter = new CodeParameter();
        BeanUtils.copyProperties(order.getCodeParameterInfo(),codeParameter);
        codeParameter.setFromCodeId(order.getCodeId());
        codeParameter.setParameterId(AppUtils.correspondingCreate("par"));

        codeParameterMapper.insertSelective(codeParameter);
    }

    @Override
    public void del(String id) {

        codeParameterMapper.delCodeParameterByParameterId(id);
    }

    @Override
    public void update(CodeParameterCUDOrder order) {

        CodeParameter codeParameter = new CodeParameter();
        BeanUtils.copyProperties(order.getCodeParameterInfo(),codeParameter);
        codeParameterMapper.updateByPrimaryKeySelective(codeParameter);
    }

}
