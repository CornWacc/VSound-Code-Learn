package com.corn.vsound.service.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeParameter;
import com.corn.vsound.dao.mapper.CodeParameterMapper;
import com.corn.vsound.facade.code.info.CodeParameterInfo;
import com.corn.vsound.facade.code.order.CodeParameterListQueryOrder;
import com.corn.vsound.facade.code.result.CodeParameterListQueryResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yyc
 * @apiNote
 * @createTime 2019/12/11
 */
@Service
public class CodeParameterListQueryDelegate extends AbstractBizService<CodeParameterListQueryOrder, CodeParameterListQueryResult> {

    @Autowired
    private CodeParameterMapper codeParameterMapper;

    @Override
    protected CodeParameterListQueryResult initResult() {
        return new CodeParameterListQueryResult();
    }

    @Override
    protected void orderCheck(CodeParameterListQueryOrder order) {
        order.orderCheck();
        if(StringUtils.isBlank(order.getCodeId())){
            throw new BizError("源码Id不能为空!");
        }
    }

    @Override
    protected void appBiz(CodeParameterListQueryOrder order, CodeParameterListQueryResult result) {

        List<CodeParameter> codeParameterList = codeParameterMapper.findCodeParameterListByCodeId(order.getCodeId());
        if(ObjectUtils.isEmpty(codeParameterList)){
            result.setCodeParameterInfoList(new ArrayList<>());
        }

        List<CodeParameterInfo> codeParameterInfos = new ArrayList<>();
        BeanCopier copier = BeanCopier.create(CodeParameter.class,CodeParameterInfo.class,false);
        for(CodeParameter codeParameter : codeParameterList){
            CodeParameterInfo codeParameterInfo = new CodeParameterInfo();
            copier.copy(codeParameter,codeParameterInfo,null);
            codeParameterInfos.add(codeParameterInfo);
        }
        result.setCodeParameterInfoList(codeParameterInfos);
    }
}
