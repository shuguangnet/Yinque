package com.example.demo.controller;
import com.example.demo.entity.Uppwd;
import com.example.demo.mapper.UppwdMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UppwdController {
    @Resource
    UppwdMapper uppwdMapper;

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

    @PostMapping("/updatepwd")
    public ApiResponse updatePassword(@RequestParam("id") Integer id, @RequestParam("password") String password) {
        Uppwd uppwd = uppwdMapper.findById(id);
        if (uppwd != null) {
            uppwd.setPassword(password);
            uppwdMapper.update(uppwd);
            return new ApiResponse(null, 0, "密码更新成功");
        } else {
            return new ApiResponse(null, -1, "用户不存在");
        }
    }
}
