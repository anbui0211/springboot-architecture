package com.andev.controller.email;

import com.andev.entity.mail.EmailEntity;
import com.andev.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("send_text")
    public String sendTextEmail(@RequestBody EmailEntity email){
        return emailService.sendTextEmail(email);
    }

    @PostMapping("send_html")
    public String sendHtmlEmail(@RequestBody EmailEntity email){
        return emailService.sendHtmlEmail(email);
    }
}