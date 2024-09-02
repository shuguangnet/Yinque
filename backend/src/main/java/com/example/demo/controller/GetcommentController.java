//获取论坛首页文章
package com.example.demo.controller;
import com.example.demo.entity.Getcomment;
import com.example.demo.entity.Likes;
import com.example.demo.mapper.GetcommentMapper;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/my")
@CrossOrigin
public class GetcommentController {
    @Resource
    GetcommentMapper getcommentMapper;

    // 定义自定义的响应对象
    static class ApiResponse {
        private final Object like;
        private Object data;
        private int status;
        private String message;

        public ApiResponse(Object data, Object like, int status, String message) {
            this.data = data;
            this.status = status;
            this.message = message;
            this.like=like;
        }

        public Object getData() {
            return data;
        }

        public int getStatus() {
            return status;
        }
        public Object getlike(){
            return like;
        }

        public String getMessage() {
            return message;
        }
    }

    @CrossOrigin
    @PostMapping("/getcomment")
    public ApiResponse getcomment(@RequestParam("forum_id") Integer forum_id,Integer user_id) {

        List<Getcomment> getcomment = getcommentMapper.findAll(forum_id);
//        int likesCount = getcommentMapper.countLikesByStatus(1);
        List<Likes> like = getcommentMapper.findsAll(forum_id,user_id);
        // 创建自定义响应对象并返回
        return new ApiResponse(getcomment, like,0, "获取成功");
    }
}
