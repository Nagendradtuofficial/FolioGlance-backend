package com.folioGlance.bff.service.impl;

import com.folioGlance.bff.entity.UserDetailsEntity;
import com.folioGlance.bff.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

  @Autowired
  private RedisTemplate<String, UserDetailsEntity> redisTemplate;


  @Override
  public void save(UserDetailsEntity userDetailsEntity){
    redisTemplate.opsForValue().set(userDetailsEntity.getEmailId() , userDetailsEntity);
  }

  @Override
  public UserDetailsEntity get(String id) {
    UserDetailsEntity userDetailsEntity = redisTemplate.opsForValue().get(id);
    return (userDetailsEntity != null) ? userDetailsEntity : new UserDetailsEntity();
  }


}
