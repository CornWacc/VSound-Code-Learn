package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeBase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CodeBaseMapper {

    int deleteByPrimaryKey(String codeId);

    int insert(CodeBase record);

    int insertSelective(CodeBase record);

    CodeBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeBase record);

    int updateByPrimaryKey(CodeBase record);

    List<CodeBase> pageFindCodeBaseListByProjectIdOrKeyWord(@Param("projectId")String projectId,
                                                            @Param("keyWord")String keyWord,
                                                            @Param("codeType")String codeType);

    @Select("select * from code_base where code_id = #{codeId}")
    @ResultMap("BaseResultMap")
    CodeBase findCodeBaseByCodeId(@Param("codeId")String codeId);

    int deleteCodesByCodeIds(@Param("codeIds")List<String> codeIds);
}