package com.corn.vsound.service.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.dao.entity.CodeOutSideUrl;
import com.corn.vsound.dao.mapper.CodeOutSideUrlMapper;
import com.corn.vsound.facade.code.info.CodeOutSideUrlInfo;
import com.corn.vsound.facade.code.order.CodeOutSideUrlCUDOrder;
import com.corn.vsound.facade.code.order.CodeOutSideUrlListQueryOrder;
import com.corn.vsound.facade.code.result.CodeOutSideUrlListQueryResult;
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
 * @createTime 2019/12/12
 */
@Service
public class CodeOutSideUrlListQueryDelegate extends AbstractBizService<CodeOutSideUrlListQueryOrder, CodeOutSideUrlListQueryResult> {

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Override
    protected CodeOutSideUrlListQueryResult initResult() {
        return new CodeOutSideUrlListQueryResult();
    }

    @Override
    protected void orderCheck(CodeOutSideUrlListQueryOrder order) {
        order.orderCheck();
        if(StringUtils.isBlank(order.getCodeId())){
            throw new BizError("源码Id不能为空");
        }
    }

    @Override
    protected void appBiz(CodeOutSideUrlListQueryOrder order, CodeOutSideUrlListQueryResult result) {

        List<CodeOutSideUrl> codeOutSideUrls = codeOutSideUrlMapper.findCodeOutSideUrlByCodeId(order.getCodeId());
        if(!ObjectUtils.isEmpty(codeOutSideUrls)){
            List<CodeOutSideUrlInfo> codeOutSideUrlInfos = new ArrayList<>();
            BeanCopier copier = BeanCopier.create(CodeOutSideUrl.class,CodeOutSideUrlInfo.class,false);
            for(CodeOutSideUrl codeOutSideUrl : codeOutSideUrls){
                CodeOutSideUrlInfo codeOutSideUrlInfo = new CodeOutSideUrlInfo();
                copier.copy(codeOutSideUrl,codeOutSideUrlInfo,null);
                codeOutSideUrlInfos.add(codeOutSideUrlInfo);
            }
            result.setCodeOutSideUrlInfoList(codeOutSideUrlInfos);
        }else{
            result.setCodeOutSideUrlInfoList(new ArrayList<>());
        }
    }
}
