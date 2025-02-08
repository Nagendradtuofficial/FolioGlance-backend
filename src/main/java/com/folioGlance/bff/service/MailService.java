package com.folioGlance.bff.service;


public interface MailService {
  public String sendEmail(String recipientMailId , String body , String subject);
}
