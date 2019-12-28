package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeMethodOrder;

public interface CodeMethodOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeMethodOrder record);

    int insertSelective(CodeMethodOrder record);

    CodeMethodOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeMethodOrder record);

    int updateByPrimaryKey(CodeMethodOrder record);
}