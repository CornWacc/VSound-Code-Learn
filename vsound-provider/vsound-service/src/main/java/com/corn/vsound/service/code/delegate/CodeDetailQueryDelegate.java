package com.corn.vsound.service.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.dto.CodeMethodOrderDto;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.entity.CodeOutSideUrl;
import com.corn.vsound.dao.entity.CodeParameter;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.dao.mapper.CodeOutSideUrlMapper;
import com.corn.vsound.dao.mapper.CodeParameterMapper;
import com.corn.vsound.facade.code.info.CodeMethodInfo;
import com.corn.vsound.facade.code.info.CodeOutSideUrlInfo;
import com.corn.vsound.facade.code.info.CodeParameterInfo;
import com.corn.vsound.facade.code.order.CodeDetailQueryOrder;
import com.corn.vsound.facade.code.result.CodeDetailQueryResult;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeDetailQueryDelegate extends AbstractBizService<CodeDetailQueryOrder, CodeDetailQueryResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Autowired
    private CodeParameterMapper codeParameterMapper;

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Override
    protected CodeDetailQueryResult initResult() {
        return new CodeDetailQueryResult();
    }

    @Override
    protected void orderCheck(CodeDetailQueryOrder order) {
        order.orderCheck();
        if(StringUtils.isBlank(order.getCodeId())){
            throw new BizError("源码Id不能为空!");
        }
    }

    @Override
    protected void appBiz(CodeDetailQueryOrder order, CodeDetailQueryResult result) {

        CodeBase codeBase = codeBaseMapper.findCodeBaseByCodeId(order.getCodeId());
        if(ObjectUtils.isEmpty(codeBase)){
            throw new BizError("该源码不存在!请刷新页面!");
        }

        String codeId = codeBase.getCodeId();
        BeanCopier.create(CodeBase.class,CodeDetailQueryResult.class,false).copy(codeBase,result,null);
        result.setCodeMethodInfoList(getCodeMethodInfoList(codeId));
        result.setCodeParameterInfos(getCodeParameterInfoList(codeId));
        result.setCodeOutSideUrlInfos(getCodeOutSideUrlInfoList(codeId));
    }

    private List<CodeMethodInfo> getCodeMethodInfoList(String codeId){
        List<CodeMethodOrderDto> codeMethods = codeMethodMapper.findCodeMethodListByCodeId(codeId);
        if(ObjectUtils.isEmpty(codeMethods)){
            return new ArrayList<>();
        }
        System.out.println(new Gson().toJson(codeMethods));
        List<CodeMethodInfo> codeMethodInfos = new ArrayList<>();
        for(CodeMethodOrderDto codeMethod : codeMethods){
            CodeMethodInfo codeMethodInfo = new CodeMethodInfo();
            BeanCopier.create(CodeMethodOrderDto.class,CodeMethodInfo.class,false).copy(codeMethod,codeMethodInfo,null);
            codeMethodInfos.add(codeMethodInfo);
        }
        return codeMethodInfos;
    }

    private List<CodeParameterInfo> getCodeParameterInfoList(String codeId){
        List<CodeParameter> codeParameters = codeParameterMapper.findCodeParameterListByCodeId(codeId);
        if(ObjectUtils.isEmpty(codeParameters)){
            return new ArrayList<>();
        }

        List<CodeParameterInfo> codeParameterInfos = new ArrayList<>();
        for(CodeParameter codeParameter : codeParameters){
            CodeParameterInfo codeParameterInfo = new CodeParameterInfo();
            BeanCopier.create(CodeParameter.class,CodeParameterInfo.class,false).copy(codeParameter,codeParameterInfo,null);
            codeParameterInfos.add(codeParameterInfo);
        }
        return codeParameterInfos;
    }

    private List<CodeOutSideUrlInfo> getCodeOutSideUrlInfoList(String codeId){
        List<CodeOutSideUrl> codeOutSideUrls = codeOutSideUrlMapper.findCodeOutSideUrlByCodeId(codeId);
        if(ObjectUtils.isEmpty(codeOutSideUrls)){
            return new ArrayList<>();
        }

        List<CodeOutSideUrlInfo> codeOutSideUrlInfos = new ArrayList<>();
        for(CodeOutSideUrl codeOutSideUrl : codeOutSideUrls){
            CodeOutSideUrlInfo codeOutSideUrlInfo = new CodeOutSideUrlInfo();
            BeanCopier.create(CodeOutSideUrl.class,CodeOutSideUrlInfo.class,false).copy(codeOutSideUrl,codeOutSideUrlInfo,null);
            codeOutSideUrlInfos.add(codeOutSideUrlInfo);
        }
        return codeOutSideUrlInfos;
    }

}
