package com.my.fitness.services.impl;

import com.my.fitness.entities.AccountEntity;
import com.my.fitness.repositories.AccountRepository;
import com.my.fitness.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Account service
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    /**
     * Account repository
     */
    @Autowired
    private AccountRepository accountRepository;

    /**
     * Get account by UUID
     * @param accountUUID Account UUID
     * @return Account
     */
    @Override
    public AccountEntity getAccountByUUID(String accountUUID) {
        return accountRepository.getAccountByUUID(accountUUID);
    }
}
