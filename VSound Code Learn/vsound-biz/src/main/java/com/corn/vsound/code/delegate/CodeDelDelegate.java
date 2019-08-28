package com.corn.vsound.code.delegate;

import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.vsound.code.del.CodeDelOrder;
import com.corn.vsound.code.del.CodeDelResult;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.dao.mapper.CodeExtraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@DoTranscation
public class CodeDelDelegate extends AbstractBizService<CodeDelOrder, CodeDelResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Autowired
    private CodeExtraMapper codeExtraMapper;

    @Override
    protected CodeDelResult initResult() {
        return new CodeDelResult();
    }

    @Override
    protected void orderCheck(CodeDelOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(CodeDelOrder order, CodeDelResult result) {

        codeBaseMapper.deleteByPrimaryKey(order.getCodeId());
//        codeExtraMapper.deleteByPrimaryKey(order.getCodeId()); //todo 兼容新版本 表扩展后需要把源码下的所有方法/参数/链接删除
    }
}
