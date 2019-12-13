package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeMethod;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CodeMethodMapper {
    int deleteByPrimaryKey(String methodId);

    int insert(CodeMethod record);

    int insertSelective(CodeMethod record);

    CodeMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeMethod record);

    int updateByPrimaryKey(CodeMethod record);

    @Select("select * from code_method where method_id = #{methodId}")
    @ResultMap("BaseResultMap")
    CodeMethod findCodeMethodByMethodId(@Param("methodId")String methodId);

    List<CodeMethod> findCodeMethodListByCodeId(@Param("codeId")String codeId);

    int deleteCodeMethodsByCodeIds(@Param("codeIds")List<String> codeIds);

}