package com.folioGlance.bff.controller;

import com.folioGlance.bff.entity.UserDetailsEntity;
import com.folioGlance.bff.service.AccountService;
import com.folioGlance.bff.service.MailService;
import com.folioGlance.bff.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private RedisService redisService;

  @PostMapping("create-account")
  public String createAccount(
      @RequestBody UserDetailsEntity userDetailsEntity
      ){
    return accountService.createAccount(userDetailsEntity);
  }

  @GetMapping("verify-account")
  public UserDetailsEntity verifyAccount(
    @RequestParam(required = true, name = "email") String email
  ){
    return redisService.get(email);
  }
}

