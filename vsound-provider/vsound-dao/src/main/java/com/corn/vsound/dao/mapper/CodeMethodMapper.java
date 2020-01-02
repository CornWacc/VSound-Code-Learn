package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.dto.CodeMethodOrderDto;
import com.corn.vsound.dao.entity.CodeMethod;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeMethodMapper {

    int deleteByPrimaryKey(String id);

    int insert(CodeMethod record);

    int insertSelective(CodeMethod record);

    CodeMethod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeMethodOrderDto record);

    int updateByPrimaryKey(CodeMethod record);

    /**
     * 根据所属源码id查询方法列表
     * */
    List<CodeMethodOrderDto> findCodeMethodListByCodeId(@Param("codeId")String codeId);

    /**
     * 根据方法id查询方法
     * */
    CodeMethodOrderDto findCodeMethodByMethodId(@Param("methodId")String methodId);

    /**
     * 根据源码Ids删除对应的方法
     * */
    int deleteCodeMethodsByCodeIds(@Param("codeIds")List<String> codeIds);
}