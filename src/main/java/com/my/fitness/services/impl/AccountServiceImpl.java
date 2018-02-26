package com.my.fitness.services.impl;

import com.my.fitness.entities.AccountEntity;
import com.my.fitness.enums.SocialNetworkType;
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

    /**
     * Get account by social network id
     * @param socialNetworkId   Social network id
     * @param socialNetworkType Social network type
     * @return Account
     */
    @Override
    public AccountEntity getAccountBySocialNetworkId(String socialNetworkId, SocialNetworkType socialNetworkType) {
        if (socialNetworkId == null || socialNetworkType == null) {
            throw new RuntimeException("Social network id and social network type must be not null");
        }
        if (SocialNetworkType.FACEBOOK == socialNetworkType) {
            return accountRepository.getAccountByFacebookId(socialNetworkId);
        }
        if (SocialNetworkType.VK_COM == socialNetworkType) {
            return accountRepository.getAccountByVkId(socialNetworkId);
        }
        if (SocialNetworkType.TWITTER == socialNetworkType) {
            return accountRepository.getAccountByTwitterId(socialNetworkId);
        }
        throw new RuntimeException("Unknown social network type " + socialNetworkType.getValue());
    }
}
