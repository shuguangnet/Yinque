package com.example.demo.controller;

import com.example.demo.entity.Likes;
import com.example.demo.mapper.LikesMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/my")
@CrossOrigin
public class LikesController {
    @Resource
    LikesMapper likesMapper;

    // 定义自定义的响应对象
    static class ApiResponse {
        private Object data;
        private int status;
        private String message;

        public ApiResponse(Object data, int status, String message) {
            this.data = data;
            this.status = status;
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }

    @PostMapping("/like")
    public ApiResponse postLike(Likes likes) {
        int forumId = likes.getForum_id();
        int userId = likes.getUser_id();

        Likes existingLike = likesMapper.findByForumIdAndUserId(forumId, userId);
        if (existingLike != null) {
            likesMapper.deleteByForumIdAndUserId(forumId, userId);
            return new ApiResponse(null, 0, "点赞已取消");
        } else {
            likesMapper.save(likes);
            return new ApiResponse(null, 0, "点赞成功");
        }
    }
}

