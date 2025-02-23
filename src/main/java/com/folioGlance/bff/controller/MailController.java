package com.folioGlance.bff.controller;

import com.folioGlance.bff.dto.request.AccountRequest;
import com.folioGlance.bff.service.AccountService;
import com.folioGlance.bff.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
public class MailController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private RedisService redisService;

  @PostMapping("create-account")
  public String createAccount(
          @Valid @RequestBody AccountRequest AccountRequest
      ){
    return accountService.createAccount(AccountRequest);
  }

}

