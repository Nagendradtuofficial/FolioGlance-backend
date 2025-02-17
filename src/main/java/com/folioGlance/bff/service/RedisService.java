package com.folioGlance.bff.service;

import com.folioGlance.bff.entity.UserDetailsEntity;

public interface RedisService {
  public void save(UserDetailsEntity userDetailsEntity);

  public UserDetailsEntity get(String id);
}
