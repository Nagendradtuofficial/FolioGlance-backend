package com.folioGlance.bff.service.impl;

import com.folioGlance.bff.entity.CreateAccountRequest;
import com.folioGlance.bff.service.AccountService;
import com.folioGlance.bff.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  MailService mailService;

  @Override
  public String createAccount(CreateAccountRequest createAccountRequest) {
    // Url generation logic here and will pass the url into the mail Service.
    return mailService.sendEmail(createAccountRequest.getEmail() , "Hi , This is a Test Email","Test Email 101");
  }
}
