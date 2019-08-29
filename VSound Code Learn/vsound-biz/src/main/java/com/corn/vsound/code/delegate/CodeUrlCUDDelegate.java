package com.corn.vsound.code.delegate;

import com.alibaba.fastjson.JSON;
import com.corn.boot.annotations.DoTranscation;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.boot.util.AppUtils;
import com.corn.vsound.base.CUDInterface;
import com.corn.vsound.code.info.CodeOutSideUrlInfo;
import com.corn.vsound.code.url.CodeUrlCUDOrder;
import com.corn.vsound.code.url.CodeUrlCUDResult;
import com.corn.vsound.dao.entity.CodeOutSideUrl;
import com.corn.vsound.dao.mapper.CodeOutSideUrlMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;


@Service
@DoTranscation
public class CodeUrlCUDDelegate extends AbstractBizService<CodeUrlCUDOrder, CodeUrlCUDResult> implements CUDInterface<CodeUrlCUDOrder> {

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Override
    protected CodeUrlCUDResult initResult() {
        return new CodeUrlCUDResult();
    }

    @Override
    protected void orderCheck(CodeUrlCUDOrder order) {
        order.orderCheck();
        if(StringUtils.isBlank(order.getCodeId())){
            throw new BizError("链接参数,源码Id不能为空");
        }
    }

    @Override
    protected void appBiz(CodeUrlCUDOrder order, CodeUrlCUDResult result) {

        cud(order.getType(),order.getUrlId(),order);

        List<CodeOutSideUrl> codeOutSideUrlList =codeOutSideUrlMapper.findCodeOutSideUrlByCodeId(order.getCodeId());
        if(!ObjectUtils.isEmpty(codeOutSideUrlList)){

            result.setCodeOutSideUrlInfoList(JSON.parseArray(JSON.toJSONString(codeOutSideUrlList), CodeOutSideUrlInfo.class));
        }else{
            result.setCodeOutSideUrlInfoList(new ArrayList<>());
        }
    }

    @Override
    public void add(CodeUrlCUDOrder order) {

        CodeOutSideUrl codeOutSideUrl = new CodeOutSideUrl();
        BeanUtils.copyProperties(order.getCodeOutSideUrlInfo(),codeOutSideUrl);
        codeOutSideUrl.setFromCodeId(order.getCodeId());
        codeOutSideUrl.setUrlId(AppUtils.correspondingCreate("url"));

        codeOutSideUrlMapper.insertSelective(codeOutSideUrl);
    }

    @Override
    public void del(String id) {
        codeOutSideUrlMapper.deleteCodeUrlByUrlId(id);
    }

    @Override
    public void update(CodeUrlCUDOrder order) {

        CodeOutSideUrl outSideUrl = new CodeOutSideUrl();
        BeanUtils.copyProperties(order.getCodeOutSideUrlInfo(),outSideUrl);
        codeOutSideUrlMapper.updateByPrimaryKeySelective(outSideUrl);
    }

}
