package com.example.demo.mapper;

import com.example.demo.entity.Reg;
import org.apache.ibatis.annotations.Insert;

import org.springframework.transaction.annotation.Transactional;

public interface RegMapper {
//    注册账号，将填写的信息插入
    @Insert("insert into `user`(`username`,`password`,`email`) VALUES(#{username},#{password},#{email})")
    @Transactional
    void save(Reg reg);
}
