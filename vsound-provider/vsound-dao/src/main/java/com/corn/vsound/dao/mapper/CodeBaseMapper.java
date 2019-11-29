package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeBase;

public interface CodeBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeBase record);

    int insertSelective(CodeBase record);

    CodeBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeBase record);

    int updateByPrimaryKey(CodeBase record);
}