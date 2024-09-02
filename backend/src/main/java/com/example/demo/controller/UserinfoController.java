package com.example.demo.controller;
import com.example.demo.entity.Userinfo;
import com.example.demo.mapper.UserinfoMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserinfoController {
    @Resource
    UserinfoMapper userinfoMapper;
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
    @PostMapping("/getUserInfo")
    public ApiResponse getUserById(@RequestParam("id") Integer id) {
        List<Userinfo> userinfo = userinfoMapper.findById(id);
        if (userinfo != null) {
            return new ApiResponse(userinfo, 0, "查询成功");
        } else {
            return new ApiResponse(null, -1, "用户不存在");
        }
    }

}

