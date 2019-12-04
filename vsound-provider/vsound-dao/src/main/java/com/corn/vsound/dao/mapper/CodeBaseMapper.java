package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeBase record);

    int insertSelective(CodeBase record);

    CodeBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeBase record);

    int updateByPrimaryKey(CodeBase record);

    List<CodeBase> pageFindCodeBaseListByProjectIdOrKeyWord(@Param("projectId")String projectId,
                                                            @Param("keyWord")String keyWord,
                                                            @Param("codeType")String codeType);

}