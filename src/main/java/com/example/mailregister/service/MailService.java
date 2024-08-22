package com.example.mailregister.service;

public interface MailService {
    /**
     *  发送多媒体类型邮件
     */
    void sendMimeMail(String to, String subject, String content);

    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
