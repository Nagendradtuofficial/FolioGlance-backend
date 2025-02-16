package com.folioGlance.bff.service;

import com.folioGlance.bff.entity.UserDetailsEntity;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaService {
  public void produce(UserDetailsEntity userDetailsEntity);

  public void consume(UserDetailsEntity userDetailsEntity);
}
