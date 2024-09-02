package com.example.demo.mapper;

import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Insert;

import org.springframework.transaction.annotation.Transactional;

public interface CommentMapper {
//    SQL语句 将 姓名、内容、帖子ID、用户ID、发布时间插入到comments表中
    @Insert("insert into `comments`(`username`,`text`,`forum_id`,`user_id`,`pub_date`) VALUES(#{username},#{text},#{forum_id},#{user_id},NOW())")
    @Transactional
    void save(Comment comment);
}
