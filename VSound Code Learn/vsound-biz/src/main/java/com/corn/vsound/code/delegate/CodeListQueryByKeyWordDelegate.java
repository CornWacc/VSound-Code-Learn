package com.corn.vsound.code.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.boot.error.BizError;
import com.corn.vsound.code.info.CodeInfo;
import com.corn.vsound.code.list.CodeListQueryByKeyWordOrder;
import com.corn.vsound.code.list.CodeListQueryByKeyWordResult;
import com.corn.vsound.dao.entity.ProjectBase;
import com.corn.vsound.dao.mapper.CodeBaseMapper;
import com.corn.vsound.dao.mapper.ProjectBaseMapper;
import com.corn.vsound.dto.CodeDto;
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
                list.add(codeInfo);
            }
            result.setCodeInfoList(list);

        }else{
            result.setCodeInfoList(new ArrayList<>());
        }
        result.setProjectName(projectBase.getProjectName());
    }
}
