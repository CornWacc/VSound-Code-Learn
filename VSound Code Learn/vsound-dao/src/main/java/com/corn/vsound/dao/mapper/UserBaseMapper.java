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
    @Select("select ub.user_account as userAccount,ub.user_id as userId,ui.user_name as userName,ui.user_avatar as userAvatar from user_base ub left join user_info ui on ub.user_id = ui.user_id where ub.user_account = #{userAccount} and ub.user_password = #{userPassword}")
    UserBase findUserByUserAccountAndUserPassword(@Param("userAccount")String userAccount,
                                                  @Param("userPassword")String userPassword);
}