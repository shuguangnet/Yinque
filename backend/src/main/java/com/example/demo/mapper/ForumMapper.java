package com.example.demo.mapper;

import com.example.demo.entity.Forum;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ForumMapper {
//    通过用户ID查询帖子
    @Select("SELECT * FROM forum WHERE user_id = #{user_id}")
    List<Forum> findAll(String user_id);
}
