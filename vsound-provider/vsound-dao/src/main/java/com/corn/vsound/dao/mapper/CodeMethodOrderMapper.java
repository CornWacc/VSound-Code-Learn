package com.corn.vsound.dao.mapper;

import com.corn.vsound.dao.entity.CodeMethodOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CodeMethodOrderMapper {

    int deleteByPrimaryKey(String orderId);

    int insert(CodeMethodOrder record);

    int insertSelective(CodeMethodOrder record);

    CodeMethodOrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(CodeMethodOrder record);

    int updateByPrimaryKey(CodeMethodOrder record);

    int batchInsert(@Param("orderList") List<CodeMethodOrder> codeMethodOrderList);

    @Select("select * from code_method_order where code_method_id = #{methodId}")
    @ResultMap("BaseResultMap")
    List<CodeMethodOrder> findCodeMethodOrderListByMethodId(@Param("methodId")String methodId);

//    int replaceMethodOrder(@Param("methodOrderList")List<CodeMethodOrder> methodOrders);

    int batchDeleteMethodOrder(@Param("methodIds")List<String> methodIds);
}