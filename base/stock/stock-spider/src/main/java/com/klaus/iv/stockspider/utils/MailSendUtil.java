package com.klaus.iv.stockspider.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailSendUtil {


    private JavaMailSender mailSender;

    @Autowired
    public MailSendUtil(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Value("${spring.mail.username}")
    private String sender;

    /**
     * 发送文本邮件
     * @param to 邮件接受者
     * @param subject 主题
     * @param content 内容
     * @throws MailException
     */
    public void sendSimpleMail(String to, String subject, String content) throws MailException {
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件发送者
        message.setFrom(sender);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }


    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws MessagingException
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        //MimeMessageHelper支持发送复杂的邮件模板
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();

        //addAttachment方法即为添加附件的方法
        helper.addAttachment(fileName, file);

        //addInline为添加图片，第一个是图片ID，第二个是图片文件Resource
//        helper.addInline()

        mailSender.send(message);
    }


    /**
     * 发送HTML邮件
     * @param to 接收者邮箱
     * @param subject 主题
     * @param content  内容
     * @throws MessagingException
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        //true 表⽰示需要创建⼀一个 multipart message
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setFrom(sender);
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(content, true);
        mailSender.send(message);
    }



}
