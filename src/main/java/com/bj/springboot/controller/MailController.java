package com.bj.springboot.controller;

import com.bj.springboot.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunboyu on 2017/8/13.
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    private String to = "277938396@qq.com";
    private String subject = "个人简历";

    @RequestMapping("/sendMessage")
    public void sendMessage(){
        mailService.sendSimpleMail(to, subject, "Hi 博宇，好，\n" +
                "　请帮忙评估是否合适，请参见附件的简历。");
    }

    @RequestMapping("/sendHtmlMessage")
    public void sendHtmlMessage(){
        String context = "<html>" +
                "<body>" +
                "    <h3>Hi 博宇，好，\n" +
                "　请帮忙评估是否合适，请参见附件的简历!</h3>" +
                "</body>" +
                "</html>";
        mailService.sendHtmlMail(to, subject, context);
    }

    @RequestMapping("/sendAttachmentsMessage")
    public void sendAttachmentsMessage(){

        String filePath= this.getClass().getResource("/").getPath() + "boot.log";
        mailService.sendAttachmentsMail(to, "主题：带附件的邮件", "有附件，请查收！", filePath);
    }
}