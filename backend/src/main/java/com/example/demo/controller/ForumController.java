//获取论坛首页文章
package com.example.demo.controller;
import com.example.demo.entity.Forum;
import com.example.demo.mapper.ForumMapper;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/my")
@CrossOrigin
public class ForumController {
    @Resource
    ForumMapper forumMapper;

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
    @PostMapping("/forum")
    public ApiResponse getNews(@RequestParam("user_id") String user_id) {

        List<Forum> forums = forumMapper.findAll(user_id);
        // 创建自定义响应对象并返回
        return new ApiResponse(forums, 0, "获取成功");
    }
}
