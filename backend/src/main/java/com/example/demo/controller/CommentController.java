package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.mapper.CommentMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import javax.annotation.Resource;

@RestController
@RequestMapping("/my")
@CrossOrigin
public class CommentController {
    @Resource
    CommentMapper commentMapper;

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
    @CrossOrigin
    @PostMapping("/comment")
    public ApiResponse postComment(Comment comment) {
        commentMapper.save(comment); // 保存评论

        return new ApiResponse(null, 0, "发布成功");
    }

}
