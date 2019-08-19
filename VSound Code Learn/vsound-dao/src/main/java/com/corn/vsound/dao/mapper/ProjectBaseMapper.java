package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.ProjectBase;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectBase record);

    int insertSelective(ProjectBase record);

    ProjectBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectBase record);

    int updateByPrimaryKey(ProjectBase record);

    @Select("select * from project_base")
    @ResultMap("BaseResultMap")
    List<ProjectBase> findProjectList();
}