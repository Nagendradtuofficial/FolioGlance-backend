package com.folioGlance.bff.service;

import com.folioGlance.bff.entity.CreateAccountRequest;

public interface KafkaService {
  public void produce(CreateAccountRequest createAccountRequest);

  public void consume(CreateAccountRequest createAccountRequest);
}
