package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeMethod;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CodeMethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeMethod record);

    int insertSelective(CodeMethod record);

    CodeMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeMethod record);

    int updateByPrimaryKey(CodeMethod record);


    @Select("select * from code_method where from_code_id = #{codeId}")
    @ResultMap("BaseResultMap")
    List<CodeMethod> findCodeMethodByCodeId(@Param("codeId")String codeId);

    int batchAddMethod(@Param("methodInfos")List<CodeMethod> codeMethods,
                       @Param("codeId")String codeId);

    @Delete("delete from code_method where method_id = #{methodId}")
    int delCodeMethodByMehodId(@Param("methodId")String methodId);
}