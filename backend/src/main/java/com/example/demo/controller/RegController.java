package com.example.demo.controller;

import com.example.demo.entity.Reg;
import com.example.demo.mapper.RegMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RegController {
    @Resource
    RegMapper regMapper;

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
    @PostMapping("/regpost")
    public ApiResponse reg(Reg reg, @RequestHeader("Content-Type") String contentType) {
        // 在方法参数中获取Content-Type请求头的值
        System.out.println("Content-Type: " + contentType);
        regMapper.save(reg);
        return new ApiResponse("null", 0, "注册成功");
    }
    @GetMapping("/code")
    public ApiResponse code() {
        // 在方法参数中获取Content-Type请求头的值

        MailRequest mailRequest = new MailRequest();
        mailRequest.sendMail("1270540423@qq.com","478635","银阙珠宫");


        return new ApiResponse("null", 0, "发送成功");
    }

}
