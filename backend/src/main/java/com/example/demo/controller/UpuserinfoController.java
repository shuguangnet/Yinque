package com.example.demo.controller;
import com.example.demo.entity.Upuserinfo;
import com.example.demo.mapper.UpuserinfoMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UpuserinfoController {
    @Resource
    UpuserinfoMapper upuserinfoMapper;

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

    @PostMapping("/upuserinfo")
    public ApiResponse updateUser( Upuserinfo userinfo) {
        Upuserinfo existingUserinfo = upuserinfoMapper.findById(userinfo.getId());
        if (existingUserinfo != null) {
            existingUserinfo.setUsername(userinfo.getUsername());
            existingUserinfo.setEmail(userinfo.getEmail());
            existingUserinfo.setQq(userinfo.getQq());
            existingUserinfo.setPhone(userinfo.getPhone());
            existingUserinfo.setContent(userinfo.getContent());

            upuserinfoMapper.update(existingUserinfo);

            return new ApiResponse(null, 0, "用户信息更新成功");
        } else {
            return new ApiResponse(null, -1, "用户不存在");
        }
    }
}

