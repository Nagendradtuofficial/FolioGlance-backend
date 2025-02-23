package com.folioGlance.bff.repository;

import com.folioGlance.bff.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserVerificationRepository extends MongoRepository<Account, String> {

}
