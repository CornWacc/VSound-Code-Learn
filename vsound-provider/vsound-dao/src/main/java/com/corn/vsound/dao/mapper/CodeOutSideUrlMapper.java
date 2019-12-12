package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeOutSideUrl;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CodeOutSideUrlMapper {
    int deleteByPrimaryKey(String urlId);

    int insert(CodeOutSideUrl record);

    int insertSelective(CodeOutSideUrl record);

    CodeOutSideUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeOutSideUrl record);

    int updateByPrimaryKey(CodeOutSideUrl record);

    List<CodeOutSideUrl> findCodeOutSideUrlByCodeId(@Param("codeId") String codeId);

    @Select("select * from code_out_side_url where url_id = #{urlId}")
    @ResultMap("BaseResultMap")
    CodeOutSideUrl findCodeOutSideUrlByUrlId(@Param("urlId")String urlId);
}