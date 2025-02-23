package com.folioGlance.bff.service;

import com.folioGlance.bff.dto.request.AccountRequest;

public interface KafkaService {
  public void produce(AccountRequest AccountRequest);

  public void consume(AccountRequest AccountRequest);
}
