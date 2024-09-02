package com.example.demo.mapper;

import com.example.demo.entity.CarUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
//    登录账号
    @Select("select  * from  `user` where `email`=#{email}")
    List<CarUser> findByEmail(@Param("email") String email);
}
