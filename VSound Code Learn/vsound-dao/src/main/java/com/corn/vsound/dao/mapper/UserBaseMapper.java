package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.UserBase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    UserBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);

    /**
     * 用于用户登录
     * */
    @Select("select * from user_base where user_account = #{userAccount} and user_password = #{userPassword}")
    @ResultMap("BaseResultMap")
    UserBase findUserByUserAccountAndUserPassword(@Param("userAccount")String userAccount,
                                                  @Param("userPassword")String userPassword);
}