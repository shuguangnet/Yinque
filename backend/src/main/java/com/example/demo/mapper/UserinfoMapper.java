package com.example.demo.mapper;

import com.example.demo.entity.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserinfoMapper {
    @Select("select  * from  `user` where `id`=#{id}")
    List<Userinfo> findById(@Param("id") Integer id);
}
