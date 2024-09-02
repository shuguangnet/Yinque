package com.example.demo.mapper;

import com.example.demo.entity.Likes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LikesMapper {
    @Select("SELECT * FROM likes WHERE forum_id = #{forumId} AND user_id = #{userId}")
    Likes findByForumIdAndUserId(@Param("forumId") int forumId, @Param("userId") int userId);

    @Delete("DELETE FROM likes WHERE forum_id = #{forumId} AND user_id = #{userId}")
    int deleteByForumIdAndUserId(@Param("forumId") int forumId, @Param("userId") int userId);

    @Insert("INSERT INTO likes (forum_id, user_id, status) VALUES (#{forum_id}, #{user_id}, 1)")
    int save(Likes likes);
}
