package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public final class MailRequest {
    @Value("${mail.user}")
    private String USER; // 发件人邮箱地址
    @Value("${mail.password}")
    private String PASSWORD; // 如果是qq邮箱可以使户端授权码

    /**
     * 发送邮件
     * @param to 收件人邮箱
     * @param text 邮件正文
     * @param title 标题
     */
    public boolean sendMail(String to, String text, String title){
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtpdm.aliyun.com");

            // 发件人的账号
            props.put("mail.user", "shuguang@email.92wap.cn");
            //发件人的密码
            props.put("mail.password", "LIUSHUguang520");

            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };

            Session mailSession = Session.getInstance(props, authenticator);

            MimeMessage message = new MimeMessage(mailSession);
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            message.setSubject(title);

            message.setContent(text, "text/html;charset=UTF-8");

            Transport.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
