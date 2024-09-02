package com.example.demo.mapper;

import com.example.demo.entity.Uppwd;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UppwdMapper {
//    查询用户信息并更新密码
    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    void update(Uppwd uppwd);

    @Select("SELECT * FROM user WHERE id = #{id}")
    Uppwd findById(Integer id);
}
