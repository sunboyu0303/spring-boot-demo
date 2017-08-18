package com.bj.springboot.service;

/**
 * Created by sunboyu on 2017/8/13.
 */
public interface MailService {

    void sendSimpleMail(String to, String subject, String content);

    void sendHtmlMail(String to, String subject, String content);

    void sendAttachmentsMail(String to, String subject, String content, String filePath);
}
