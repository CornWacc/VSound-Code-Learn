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
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.dto.CodeDto;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CodeListQueryByKeyWordDelegate extends AbstractBizService<CodeListQueryByKeyWordOrder, CodeListQueryByKeyWordResult> {

    @Autowired
    private CodeBaseMapper codeBaseMapper;

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
           throw new BizError("对应项目查询失败");
        }

        List<CodeDto> codeDtoList = codeBaseMapper.findCodeListByKeyWord(order.getProgramId(),order.getCodeName(),order.getCodeLevel(),order.getCodeType());
        if(!ObjectUtils.isEmpty(codeDtoList)){
            List<CodeInfo> list = new ArrayList<>();
            for(CodeDto codeDto : codeDtoList){
                CodeInfo codeInfo = new CodeInfo();
                BeanUtils.copyProperties(codeDto,codeInfo);
                codeInfo.setCodeMethods(parseList(codeDto.getCodeMethods(), new TypeReference<List<CodeMethodInfo>> () {}));
                codeInfo.setCodeParameters(parseList(codeDto.getCodeParameters(),new TypeReference<List<CodeParameterInfo>>(){}));
                codeInfo.setOutSideUrl(parseList(codeDto.getOutSideUrl(),new TypeReference<List<CodeOutSideUrlInfo>>(){}));
                list.add(codeInfo);
            }
            result.setCodeInfoList(list);

        }else{
            result.setCodeInfoList(new ArrayList<>());
        }
        result.setProjectName(projectBase.getProjectName());
    }

    private List parseList(String jsonList,TypeReference typeReference){
        if(StringUtils.isNotBlank(jsonList)){
            List list = (List) JSON.parseObject(jsonList,typeReference);
            if(!ObjectUtils.isEmpty(list)){
                return list;
            }else{
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public static void main(String[] args) {
        List<CodeParameterInfo> codeMethodInfos = new ArrayList<>();
        CodeParameterInfo codeMethodInfo = new CodeParameterInfo();
        codeMethodInfo.setParameterName("名字");
        codeMethodInfo.setParameterType("String");
        codeMethodInfo.setParameterRemark("测试");
        codeMethodInfos.add(codeMethodInfo);
        String s  = JSON.toJSONString(codeMethodInfos);
        System.out.println(s);

        List<CodeParameterInfo> codeMethodInfos1 = JSON.parseObject(s,new TypeReference<List<CodeParameterInfo>>(){});
        System.out.println(new Gson().toJson(codeMethodInfos1));

        List<CodeOutSideUrlInfo> codeOutSideUrlInfos = new ArrayList<>();
        CodeOutSideUrlInfo info = new CodeOutSideUrlInfo();
        info.setOutSideUrlPath("baidu.com");
        info.setOutSideUrlRemark("测试");
        codeOutSideUrlInfos.add(info);
        System.out.println( JSON.toJSONString(codeOutSideUrlInfos));
    }
}
