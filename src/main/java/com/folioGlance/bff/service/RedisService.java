package com.folioGlance.bff.service;

import com.folioGlance.bff.entity.Account;
import com.folioGlance.bff.entity.Account;

public interface RedisService {
    public void save(Account account);

    public Account get(String id);
}