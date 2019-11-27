package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeMethod;

public interface CodeMethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeMethod record);

    int insertSelective(CodeMethod record);

    CodeMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeMethod record);

    int updateByPrimaryKey(CodeMethod record);
}