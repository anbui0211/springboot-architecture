package com.andev.service;

import com.andev.entity.mail.EmailEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaService {

    @Autowired
    private EmailService emailService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "otp-auth-topic", groupId = "otp-group-id")
    public void listenOTP(String message) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            /**
             * jsonNode
             * email
             * otp
             * */
            String email = jsonNode.get("email").asText();
            String otp = jsonNode.get("otp").asText();
            log.info("otp is {}, email is {}", otp, email);

            EmailEntity emailEntity = new EmailEntity();
            emailEntity.setToEmail(email);
            emailEntity.setSubject("Send OTP from Kafka Go");
            emailEntity.setMessageBody("OTP is:: " + otp);

            String result = emailService.sendTextEmail(emailEntity);
            log.info("result is {}", result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
