package com.folioGlance.bff.service.impl;

import com.folioGlance.bff.dto.request.AccountRequest;
import com.folioGlance.bff.entity.Account;
import com.folioGlance.bff.mapper.AccountMapper;
import com.folioGlance.bff.repository.UserVerificationRepository;
import com.folioGlance.bff.service.KafkaService;
import com.folioGlance.bff.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class KafkaServiceImpl implements KafkaService {

  @Autowired
  private UserVerificationRepository userVerificationRepository;

  @Autowired
  private RedisService redisService ;

  @Value("${kafka.topic.name}")
  private String topicName ;

  private final KafkaTemplate<String , AccountRequest> kafkaTemplate;

  public KafkaServiceImpl(KafkaTemplate<String , AccountRequest> kafkaTemplate){
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void produce(AccountRequest accountRequest){
    kafkaTemplate.send(topicName , accountRequest);
    return;
  }

  @Override
  @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(AccountRequest accountRequest) {
    // to make sure data is saved in both (Redis as well temp db).
    System.out.println("✅ Received User Email: " + accountRequest.getEmail());

    Account account = AccountMapper.toEntity(accountRequest);

    Account savedAccountDetails=userVerificationRepository.save(account);

    if (Objects.nonNull(savedAccountDetails)&&Objects.nonNull(savedAccountDetails.getId())) {
      redisService.save(account);
      System.out.println("✅ Successfully saved in MongoDB, also saving in Redis.");
    } else {
      System.out.println("❌ Failed to save in MongoDB, skipping Redis save.");
    }
  }
}
