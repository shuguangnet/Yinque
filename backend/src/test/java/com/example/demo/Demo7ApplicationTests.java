package com.example.demo;

import com.example.demo.controller.MailRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo7ApplicationTests {


	@Autowired
	private MailRequest mailRequest;
	@Test
	void contextLoads() {
		mailRequest.sendMail("1270540423@qq.com","123","1223");
	}

}
