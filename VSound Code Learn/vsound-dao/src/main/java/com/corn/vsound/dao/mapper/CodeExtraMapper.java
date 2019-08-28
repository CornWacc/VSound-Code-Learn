package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeExtra;

public interface CodeExtraMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeExtra record);

    int insertSelective(CodeExtra record);

    CodeExtra selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeExtra record);

    int updateByPrimaryKey(CodeExtra record);
}