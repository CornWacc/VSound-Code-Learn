package com.corn.vsound.code.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.code.update.CodeUpdateOrder;
import com.corn.vsound.code.update.CodeUpdateResult;
import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dao.entity.CodeExtra;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.dao.mapper.CodeExtraMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@DoTranscation
public class CodeUpdateDelegate extends AbstractBizService<CodeUpdateOrder, CodeUpdateResult> {

    private static final String BASE_UPDATE = "BASE";


    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Autowired
    private CodeExtraMapper codeExtraMapper;

    @Override
    protected CodeUpdateResult initResult() {
        return new CodeUpdateResult();
    }

    @Override
    protected void orderCheck(CodeUpdateOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(CodeUpdateOrder order, CodeUpdateResult result) {

        String codeId = order.getCodeId();
        if(StringUtils.isNotBlank(codeId)){

            if(StringUtils.isNotBlank(order.getUpdateType()) && order.getUpdateType().equals(BASE_UPDATE)){
                CodeBase codeBase = new CodeBase();
                codeBase.setCodeName(order.getCodeName());
                codeBase.setCodeType(order.getCodeType());
                codeBase.setCodeLevel(order.getCodeLevel());
                codeBase.setCodeId(order.getCodeId());

                codeBaseMapper.updateByPrimaryKeySelective(codeBase);
            }else{
                CodeExtra codeExtra = new CodeExtra();
                codeExtra.setCodeId(order.getCodeId());
                codeExtra.setCodeRemark(order.getCodeRemark());
                codeExtra.setUsePosition(order.getUsePosition());

                codeExtraMapper.updateByPrimaryKeySelective(codeExtra);
            }

        }else{
            throw new BizError("源码Id不能为空");
        }
    }
}
