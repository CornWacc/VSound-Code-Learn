package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.ProjectBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectBase record);

    int insertSelective(ProjectBase record);

    ProjectBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectBase record);

    int updateByPrimaryKey(ProjectBase record);

    List<ProjectBase> findProjectListByKeyWord(@Param("keyWord")String keyWord);
}