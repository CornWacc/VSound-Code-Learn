package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeParameter;

public interface CodeParameterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeParameter record);

    int insertSelective(CodeParameter record);

    CodeParameter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeParameter record);

    int updateByPrimaryKey(CodeParameter record);
}