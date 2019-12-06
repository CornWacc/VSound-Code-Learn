package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeOutSideUrl;

import java.util.List;

public interface CodeOutSideUrlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeOutSideUrl record);

    int insertSelective(CodeOutSideUrl record);

    CodeOutSideUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeOutSideUrl record);

    int updateByPrimaryKey(CodeOutSideUrl record);

    List<CodeOutSideUrl> findCodeOutSideUrlByCodeId(String codeId);
}