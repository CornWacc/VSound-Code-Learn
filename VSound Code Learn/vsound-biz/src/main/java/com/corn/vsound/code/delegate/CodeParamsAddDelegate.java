package com.corn.vsound.code.delegate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.code.codeparam.CodeParamsAddOrder;
import com.corn.vsound.code.codeparam.CodeParamsAddResult;
import com.corn.vsound.code.info.CodeMethodInfo;
import com.corn.vsound.code.info.CodeOutSideUrlInfo;
import com.corn.vsound.code.info.CodeParameterInfo;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.dao.mapper.CodeOutSideUrlMapper;
import com.corn.vsound.dao.mapper.CodeParameterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
@DoTranscation
public class CodeParamsAddDelegate extends AbstractBizService<CodeParamsAddOrder, CodeParamsAddResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Autowired
    private CodeParameterMapper codeParameterMapper;

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Override
    protected CodeParamsAddResult initResult() {
        return new CodeParamsAddResult();
    }

    @Override
    protected void orderCheck(CodeParamsAddOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(CodeParamsAddOrder order, CodeParamsAddResult result) {

        CodeBase codeBase = codeBaseMapper.findCodeBaseByCodeId(order.getCodeId());
        if(!ObjectUtils.isEmpty(codeBase)){

            switch (order.getType()){

                case "method":
                    addMethod(order.getCodeId(),order.getInfo());
                    break;
                case "params":
//                    addParameter(order.getCodeId(),order.getInfoList());
                    break;
                case "url":
//                    addUrl(order.getCodeId(),order.getInfoList());
                    break;
            }

        }else{
            throw new BizError("当前源码不存在");
        }
    }

    private void addMethod(String codeId, Object info){
        if(!ObjectUtils.isEmpty(info)){
            CodeMethod codeMethod = (CodeMethod) info;
            codeMethod.setFromCodeId(codeId);
            codeMethodMapper.insertSelective(codeMethod);
        }else{
            throw new BizError("新增方法不能为空");
        }
    }

    private void addParameter(String codeId, List<CodeParameterInfo> codeParameterInfos){

    }

    private void addUrl(String  codeId, List<CodeOutSideUrlInfo> codeOutSideUrlInfos){

    }
}
