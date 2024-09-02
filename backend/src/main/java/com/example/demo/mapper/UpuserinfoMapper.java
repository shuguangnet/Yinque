package com.example.demo.mapper;

import com.example.demo.entity.Upuserinfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UpuserinfoMapper {
//    通过id查询用户信息后更新个人信息
    @Select("SELECT * FROM user WHERE id = #{id}")
    Upuserinfo findById(Integer id);
    @Update("UPDATE user SET username = #{username}, email = #{email}, qq = #{qq}, phone = #{phone}, content = #{content} WHERE id = #{id}")
    void update(Upuserinfo existingUserinfo);
}
