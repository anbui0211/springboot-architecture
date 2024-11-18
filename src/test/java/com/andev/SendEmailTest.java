package com.andev;

import com.andev.util.EmailSenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {

    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Test
    public void sendTextEmail() {
        String to = "phuanlut0000@gmail.com";
        String subject = "Text OTP Simple";
        String content = "This is a test send mail";

        emailSenderUtil.sendTextEmail(to, subject, content);
    }

    @Test
    public void sendHTMLEmail() throws IOException {
        String to = "phuanlut0000@gmail.com";
        String subject = "Text OTP HTML";
        String content = "OTP 123";

        Resource resource = new ClassPathResource("/templates/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        emailSenderUtil.sendTextEmail(to, subject, htmlContent);
    }
}
