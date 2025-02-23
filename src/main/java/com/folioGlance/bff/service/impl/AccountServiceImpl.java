package com.folioGlance.bff.service.impl;

import com.folioGlance.bff.dto.request.AccountRequest;
import com.folioGlance.bff.service.AccountService;
import com.folioGlance.bff.service.KafkaService;
import com.folioGlance.bff.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  MailService mailService;

  @Autowired
  KafkaService kafkaService;

  @Override
  public String createAccount(AccountRequest AccountRequest) {
    // Url generation logic here and will pass the url into the mail Service.
      kafkaService.produce(AccountRequest);
      return "OK";
//    return mailService.sendEmail(userDetailsEntity.getEmailId() , "Hi , This is a Test Email","Test Email 101");
  }
}
