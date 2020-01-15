package com.corn.vsound.service.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.dto.CodeMethodOrderDto;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.mapper.CodeMethodMapper;
import com.corn.vsound.facade.code.info.CodeMethodInfo;
import com.corn.vsound.facade.code.order.CodeMethodListQueryOrder;
import com.corn.vsound.facade.code.result.CodeMethodListQueryResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class CodeMethodListQueryDelegate extends AbstractBizService<CodeMethodListQueryOrder, CodeMethodListQueryResult> {

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Override
    protected CodeMethodListQueryResult initResult() {
        return new CodeMethodListQueryResult();
    }

    @Override
    protected void orderCheck(CodeMethodListQueryOrder order) {
        order.orderCheck();
        if(StringUtils.isBlank(order.getCodeId())){
            throw new BizError("源码Id不能为空");
        }
    }

    @Override
    protected void appBiz(CodeMethodListQueryOrder order, CodeMethodListQueryResult result) {

        List<CodeMethod> codeMethodList = codeMethodMapper.findCodeMethodListByCodeId(Arrays.asList(order.getCodeId()));
        if(!ObjectUtils.isEmpty(codeMethodList)){
            List<CodeMethodInfo> codeMethodInfos = new ArrayList<>();
            for(CodeMethod codeMethod : codeMethodList){
                CodeMethodInfo codeMethodInfo = new CodeMethodInfo();
                BeanCopier.create(CodeMethod.class,CodeMethodInfo.class,false).copy(codeMethod,codeMethodInfo,null);
                codeMethodInfos.add(codeMethodInfo);
            }


            result.setCodeMethodInfoList(codeMethodInfos);
        }else{
            result.setCodeMethodInfoList(new ArrayList<>());
        }
    }
}
