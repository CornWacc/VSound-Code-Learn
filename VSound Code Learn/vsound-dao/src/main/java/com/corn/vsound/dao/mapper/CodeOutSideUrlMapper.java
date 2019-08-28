package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeOutSideUrl;

public interface CodeOutSideUrlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeOutSideUrl record);

    int insertSelective(CodeOutSideUrl record);

    CodeOutSideUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeOutSideUrl record);

    int updateByPrimaryKey(CodeOutSideUrl record);
}