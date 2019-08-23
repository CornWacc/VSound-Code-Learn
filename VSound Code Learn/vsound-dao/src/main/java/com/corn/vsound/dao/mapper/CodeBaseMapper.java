package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeBase;
import com.corn.vsound.dto.CodeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeBaseMapper {
    int deleteByPrimaryKey(String codeId);

    int insert(CodeBase record);

    int insertSelective(CodeBase record);

    CodeBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeBase record);

    int updateByPrimaryKey(CodeBase record);

    List<CodeDto> findCodeListByKeyWord(@Param("programId")String programId,
                                        @Param("codeName")String codeName,
                                        @Param("codeLevel")Integer codeLevel,
                                        @Param("codeType")String codeType);

}