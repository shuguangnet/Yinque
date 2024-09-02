package com.example.demo.mapper;

import com.example.demo.entity.Getcomment;
import com.example.demo.entity.Likes;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GetcommentMapper {
//    通过帖子ID查询评论
    @Select("SELECT * FROM comments WHERE forum_id = #{forum_id}")
    List<Getcomment> findAll(Integer forum_id);
//    查询点赞情况
    @Select("SELECT * FROM likes WHERE status = 1 AND forum_id=#{forum_id} AND user_id=#{user_id}")
    List<Likes> findsAll(Integer forum_id,Integer user_id);
}
