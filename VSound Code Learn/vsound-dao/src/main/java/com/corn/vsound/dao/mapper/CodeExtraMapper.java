package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeExtra;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface CodeExtraMapper {
    int deleteByPrimaryKey(String id);

    int insert(CodeExtra record);

    int insertSelective(CodeExtra record);

    CodeExtra selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeExtra record);

    int updateByPrimaryKey(CodeExtra record);


    @Select("select * from code_extra where code_id = #{codeId}")
    @ResultMap("BaseResultMap")
    CodeExtra findCodeParamsByCodeId(@Param("codeId")String codeId);
}