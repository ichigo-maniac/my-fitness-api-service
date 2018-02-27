package com.my.fitness.services;

import com.my.fitness.entities.AccountEntity;
import com.my.fitness.enums.SocialNetworkType;

/**
 * Account service interface
 */
public interface AccountService {

    /**
     * Get or create an account
     * @param socialNetworkId Social network id
     * @param socialNetworkType Social network type
     * @param name Account name
     * @return Old or created account
     */
    AccountEntity getOrCreateAccount(String socialNetworkId, SocialNetworkType socialNetworkType, String name);

    /**
     * Get account by UUID
     * @param accountUUID Account UUID
     * @return Account
     */
    AccountEntity getAccountByUUID(String accountUUID);

    /**
     * Get account by social network id
     * @param socialNetworkId Social network id
     * @param socialNetworkType Social network type
     * @return Account
     */
    AccountEntity getAccountBySocialNetworkId(String socialNetworkId, SocialNetworkType socialNetworkType);
}
