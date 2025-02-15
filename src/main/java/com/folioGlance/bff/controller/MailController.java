package com.folioGlance.bff.controller;

import com.folioGlance.bff.entity.CreateAccountRequest;
import com.folioGlance.bff.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
public class MailController {

  @Autowired
  private AccountService accountService;

  @PostMapping("create-account")
  public String createAccount(
          @Valid @RequestBody CreateAccountRequest createAccountRequest
      ){
    return accountService.createAccount(createAccountRequest);
  }
}

