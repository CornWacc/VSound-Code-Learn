package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeParameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeParameterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeParameter record);

    int insertSelective(CodeParameter record);

    CodeParameter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeParameter record);

    int updateByPrimaryKey(CodeParameter record);

    List<CodeParameter> findCodeParameterListByCodeId(@Param("codeId")String codeId);
}