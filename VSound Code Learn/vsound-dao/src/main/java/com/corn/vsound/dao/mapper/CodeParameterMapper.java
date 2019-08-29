package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeParameter;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CodeParameterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeParameter record);

    int insertSelective(CodeParameter record);

    CodeParameter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeParameter record);

    int updateByPrimaryKey(CodeParameter record);

    @Select("select * from code_parameter where from_code_id = #{codeId}")
    @ResultMap("BaseResultMap")
    List<CodeParameter> findParameterListByCodeId(@Param("codeId")String codeId);

    @Delete("delete from code_parameter where parameter_id = #{parameterId}")
    int delCodeParameterByParameterId(@Param("parameterId")String parameterId);
}