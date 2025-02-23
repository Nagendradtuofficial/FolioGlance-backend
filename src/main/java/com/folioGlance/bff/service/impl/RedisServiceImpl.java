package com.folioGlance.bff.service.impl;

import com.folioGlance.bff.entity.Account;
import com.folioGlance.bff.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, Account> redisTemplate;


    @Override
    public void save(Account userDetailsEntity){
        redisTemplate.opsForValue().set(userDetailsEntity.getEmail() , userDetailsEntity);
    }

    @Override
    public Account get(String id) {
        Account account = redisTemplate.opsForValue().get(id);
        return account;
    }
}