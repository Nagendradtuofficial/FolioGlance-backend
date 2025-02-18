package com.folioGlance.bff.service.impl;

import com.folioGlance.bff.entity.CreateAccountRequest;
import com.folioGlance.bff.service.KafkaService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

  @Value("${kafka.topic.name}")
  private String topicName ;

  private final KafkaTemplate<String , CreateAccountRequest> kafkaTemplate;

  public KafkaServiceImpl(KafkaTemplate<String , CreateAccountRequest> kafkaTemplate){
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void produce(CreateAccountRequest CreateAccountRequest){
    kafkaTemplate.send(topicName , CreateAccountRequest);
    return;
  }

  @Override
  @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(CreateAccountRequest createAccountRequest) {
    // to make sure data is saved in both (Redis as well temp db).
        System.out.println("✅ Received User Email: " + createAccountRequest.getEmail());
  }

}
