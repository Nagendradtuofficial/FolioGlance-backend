package com.folioGlance.bff.service.impl;

import com.folioGlance.bff.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
  @Autowired
  private JavaMailSender javaMailSender;

  @Value("$(spring.mail.username)")
  private String senderMailId ;

  @Override
  public String sendEmail(String recipientMailId , String body , String subject) {

    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom(senderMailId);
    simpleMailMessage.setTo(recipientMailId);
    simpleMailMessage.setText(body);
    simpleMailMessage.setSubject(subject);

    javaMailSender.send(simpleMailMessage);
    return "Mail Sent";
  }
}
