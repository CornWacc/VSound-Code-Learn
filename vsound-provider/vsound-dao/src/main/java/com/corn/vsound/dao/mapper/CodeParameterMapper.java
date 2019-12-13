package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeParameter;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CodeParameterMapper {
    int deleteByPrimaryKey(String parameterId);

    int insert(CodeParameter record);

    int insertSelective(CodeParameter record);

    CodeParameter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeParameter record);

    int updateByPrimaryKey(CodeParameter record);

    List<CodeParameter> findCodeParameterListByCodeId(@Param("codeId")String codeId);

    @Select("select * from code_parameter where parameter_id = #{parameterId}")
    @ResultMap("BaseResultMap")
    CodeParameter findCodeParameterByParameterId(@Param("parameterId")String parameterId);

    int deleteCodeParametersByCodeIds(@Param("codeIds")List<String> codeIds);
}