package com.corn.vsound.code.delegate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.code.codeparam.CodeParamsAddOrder;
import com.corn.vsound.code.codeparam.CodeParamsAddResult;
import com.corn.vsound.code.create.CodeAddResult;
import com.corn.vsound.code.info.CodeMethodInfo;
import com.corn.vsound.code.info.CodeOutSideUrlInfo;
import com.corn.vsound.code.info.CodeParameterInfo;
import com.corn.vsound.dao.entity.CodeExtra;
import com.corn.vsound.dao.mapper.CodeExtraMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
@DoTranscation
public class CodeParamsAddDelegate extends AbstractBizService<CodeParamsAddOrder, CodeParamsAddResult> {

    @Autowired
    private CodeExtraMapper codeExtraMapper;

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

        CodeExtra codeExtra = codeExtraMapper.findCodeParamsByCodeId(order.getCodeId());
        if(ObjectUtils.isEmpty(codeExtra)){
            throw new BizError("该源码不存在!");
        }
        System.out.println(codeExtra);

        String resJson = "";

        switch (order.getType()){
            case "method":
                resJson = addMethodParam(order.getCodeMethodInfoList());
                codeExtra.setCodeMethods(resJson);
                break;
            case "params":
                resJson = addParameter(order.getCodeParameterInfos());
                codeExtra.setCodeParameter(resJson);
                break;
            case "url":
                resJson = addUrl(order.getCodeOutSideUrlInfos());
                codeExtra.setOutSideUrl(resJson);
                break;
        }
        System.out.println(resJson);
        codeExtraMapper.updateByPrimaryKeySelective(codeExtra);

        setCallBack(order.getCodeId(),result);
    }

    private String addMethodParam(List<CodeMethodInfo> codeMethodInfoList){
        if(!ObjectUtils.isEmpty(codeMethodInfoList)){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(JSON.toJSON(codeMethodInfoList));
            return stringBuilder.toString();
        }else{
            throw new BizError("新增方法出错,新增列表为空");
        }
    }

    private String addParameter(List<CodeParameterInfo> codeParameterInfos){
        if(!ObjectUtils.isEmpty(codeParameterInfos)){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(JSON.toJSON(codeParameterInfos));
            return stringBuilder.toString();
        }else{
            throw new BizError("新增参数失败,新增列表为空");
        }
    }

    private String addUrl(List<CodeOutSideUrlInfo> codeOutSideUrlInfos){
        if(!ObjectUtils.isEmpty(codeOutSideUrlInfos)){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(JSON.toJSON(codeOutSideUrlInfos));
            return stringBuilder.toString();
        }else{
            throw new BizError("新增连接失败,新增列表为空");
        }
    }

    private void setCallBack(String codeId,CodeParamsAddResult result){
        //回调
        CodeExtra codeExtra = codeExtraMapper.findCodeParamsByCodeId(codeId);
        if(StringUtils.isNotBlank(codeExtra.getCodeMethods())){
            List<CodeMethodInfo> codeMethodInfos = JSON.parseObject(codeExtra.getCodeMethods(),new TypeReference<List<CodeMethodInfo>>(){});
            result.setCodeMethodInfoList(codeMethodInfos);
        }
        if(StringUtils.isNotBlank(codeExtra.getCodeParameter())){
            List<CodeParameterInfo> codeParameterInfos = JSON.parseObject(codeExtra.getCodeParameter(),new TypeReference<List<CodeParameterInfo>>(){});
            result.setCodeParameterInfos(codeParameterInfos);
        }
        if(StringUtils.isNotBlank(codeExtra.getOutSideUrl())){
            List<CodeOutSideUrlInfo> codeOutSideUrlInfos = JSON.parseObject(codeExtra.getOutSideUrl(),new TypeReference<List<CodeOutSideUrlInfo>>(){});
            result.setCodeOutSideUrlInfos(codeOutSideUrlInfos);
        }
    }


}
