package com.example.demo.controller;

import com.example.demo.entity.Videos;
import com.example.demo.mapper.VideosMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VideosController {
    @Resource
    VideosMapper videosMapper;

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
    @PostMapping("/videos")
    public ApiResponse getNews() {
        List<Videos> videos = videosMapper.findAll();
        // 创建自定义响应对象并返回
        return new ApiResponse(videos, 0, "获取成功");
    }
}
