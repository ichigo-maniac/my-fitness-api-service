package com.my.fitness.services;

import com.my.fitness.entities.AccountEntity;

/**
 * Account service interface
 */
public interface AccountService {

    /**
     * Get account by UUID
     * @param accountUUID Account UUID
     * @return Account
     */
    AccountEntity getAccountByUUID(String accountUUID);
}
