package com.example.demo.controller;

import com.example.demo.entity.Publish;
import com.example.demo.mapper.PublishMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import javax.annotation.Resource;

@RestController
@RequestMapping("/my")
@CrossOrigin
public class PublishController {
    @Resource
    PublishMapper publishMapper;

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
    @PostMapping("/publish")
    public ApiResponse postComment(Publish publish) {
        publishMapper.save(publish); // 发布文章

        return new ApiResponse(null, 0, "发布成功");
    }

}
