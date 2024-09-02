package com.example.demo.controller;

import com.example.demo.entity.CarUser;
import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    @Resource
    UserMapper userMapper;
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
    @PostMapping("/login")
    public ApiResponse login(@RequestParam("email") String email, @RequestParam("password") String password) {
        List<CarUser> userList = userMapper.findByEmail(email);
        System.out.println(userList);
        if (userList.isEmpty()) {
            return new ApiResponse(null, -1, "用户不存在");
        }

        CarUser user = userList.get(0);
        if (user.getPassword().equals(password)) {
            return new ApiResponse(user, 0, "登录成功");
        } else {
            return new ApiResponse(null, -1, "密码错误");
        }
    }

}

