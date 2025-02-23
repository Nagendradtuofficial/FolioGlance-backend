package com.folioGlance.bff.mapper;

import com.folioGlance.bff.dto.request.AccountRequest;
import com.folioGlance.bff.entity.Account;

public class AccountMapper {
    public static Account toEntity(AccountRequest accountRequest){
        return new Account(accountRequest.getEmail(), accountRequest.getPassword());
    }
}
