package com.andev.service;

import com.andev.entity.mail.EmailEntity;

public interface EmailService {
    String sendTextEmail(EmailEntity email);

    String sendHtmlEmail(EmailEntity email);

    String sendMailAttachmentEmail(EmailEntity email);
}