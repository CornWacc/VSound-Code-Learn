package com.corn.vsound.code.delegate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.code.info.CodeInfo;
import com.corn.vsound.code.info.CodeMethodInfo;
import com.corn.vsound.code.info.CodeOutSideUrlInfo;
import com.corn.vsound.code.info.CodeParameterInfo;
import com.corn.vsound.code.list.CodeListQueryByKeyWordOrder;
import com.corn.vsound.code.list.CodeListQueryByKeyWordResult;
import com.corn.vsound.dao.entity.CodeMethod;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.*;
import com.corn.vsound.dto.CodeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class CodeListQueryByKeyWordDelegate extends AbstractBizService<CodeListQueryByKeyWordOrder, CodeListQueryByKeyWordResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

    @Autowired
    private CodeMethodMapper codeMethodMapper;

    @Autowired
    private CodeParameterMapper codeParameterMapper;

    @Autowired
    private CodeOutSideUrlMapper codeOutSideUrlMapper;

    @Autowired
    private ProjectBaseMapper projectBaseMapper;

    @Override
    protected CodeListQueryByKeyWordResult initResult() {
        return new CodeListQueryByKeyWordResult();
    }

    @Override
    protected void orderCheck(CodeListQueryByKeyWordOrder order) {
        order.orderCheck();
    }

    @Override
    protected void appBiz(CodeListQueryByKeyWordOrder order, CodeListQueryByKeyWordResult result) {

        ProjectBase projectBase = projectBaseMapper.findProjectByProjectId(order.getProgramId());
        if(ObjectUtils.isEmpty(projectBase)){
           throw new BizError("当前项目不存在!");
        }
        List<CodeDto> codeDtos = codeBaseMapper.findCodeListByKeyWord(order.getProgramId(),order.getCodeName(),order.getCodeLevel(),order.getCodeType());
        if(!ObjectUtils.isEmpty(codeDtos)){

            List<CodeInfo> codeInfos = new ArrayList<>();
            for(CodeDto codeDto : codeDtos){
                CodeInfo codeInfo = new CodeInfo();
                BeanUtils.copyProperties(codeDto,codeInfo);
                codeInfo.setCodeMethods(getCodeMethodList(codeDto.getCodeId()));
                codeInfos.add(codeInfo);
            }
            result.setCodeInfoList(codeInfos);

        }else{
            result.setCodeInfoList(new ArrayList<>());
        }
        result.setProjectName(projectBase.getProjectName());
    }

    private List<CodeMethodInfo> getCodeMethodList(String codeId){

        List<CodeMethod> codeMethodList = codeMethodMapper.findCodeMethodByCodeId(codeId);
        if(!ObjectUtils.isEmpty(codeMethodList)){

            List<CodeMethodInfo> codeMethodInfos = JSON.parseObject(JSON.toJSONString(codeMethodList),new TypeReference<List<CodeMethodInfo>>(){});
            return codeMethodInfos;
        }else{
            return new ArrayList<>();
        }
    }

    private List<CodeParameterInfo> getCodeParameterList(String codeId){

        return new ArrayList<>();
    }

    private List<CodeOutSideUrlInfo> getCodeUrlList(String codeId){
        return new ArrayList<>();
    }

}