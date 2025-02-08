package com.folioGlance.bff.controller;

import com.folioGlance.bff.entity.UserDetailsEntity;
import com.folioGlance.bff.service.AccountService;
import com.folioGlance.bff.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

  @Autowired
  private AccountService accountService;

  @PostMapping("create-account")
  public String createAccount(
      @RequestBody UserDetailsEntity userDetailsEntity
      ){
    return accountService.createAccount(userDetailsEntity);
  }
}

