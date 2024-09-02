package com.example.demo.mapper;

import com.example.demo.entity.Publish;
import org.apache.ibatis.annotations.Insert;

import org.springframework.transaction.annotation.Transactional;

public interface PublishMapper {
//    将所有信息个人信息和帖子内容插入
    @Insert("insert into `forum`(`username`,`content`,`user_id`,`pub_date`) VALUES(#{username},#{content},#{user_id},NOW())")
    @Transactional
    void save(Publish publish);
}
