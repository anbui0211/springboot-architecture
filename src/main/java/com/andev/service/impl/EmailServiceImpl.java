package com.andev.service.impl;

import com.andev.entity.mail.EmailEntity;
import com.andev.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String EMAIL_HOST = "xxxx";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendTextEmail(EmailEntity email) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(EMAIL_HOST);
        message.setTo(email.getToEmail());
        message.setSubject(email.getSubject());
        message.setText(email.getMessageBody());

        try {
            javaMailSender.send(message);
            System.out.println("Email sent successfully");
            return "Email sent successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendHtmlEmail(EmailEntity email) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(EMAIL_HOST);
            helper.setTo(email.getToEmail());
            helper.setSubject(email.getSubject());
            helper.setText(email.getMessageBody());
            javaMailSender.send(message);
            System.out.println("Email sent successfully");
            return "Email sent successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendMailAttachmentEmail(EmailEntity email) {
        return "";
    }
}