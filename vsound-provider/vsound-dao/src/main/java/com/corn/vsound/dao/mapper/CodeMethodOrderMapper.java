package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeMethodOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeMethodOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeMethodOrder record);

    int insertSelective(CodeMethodOrder record);

    CodeMethodOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeMethodOrder record);

    int updateByPrimaryKey(CodeMethodOrder record);

    int batchInsert(@Param("orderList") List<CodeMethodOrder> codeMethodOrderList);
}