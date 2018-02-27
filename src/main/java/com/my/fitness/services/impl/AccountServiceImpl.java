package com.my.fitness.services.impl;

import com.my.fitness.entities.AccountEntity;
import com.my.fitness.enums.LengthUnit;
import com.my.fitness.enums.SocialNetworkType;
import com.my.fitness.enums.WeightUnit;
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
     * Get or create an account
     * @param socialNetworkId   Social network id
     * @param socialNetworkType Social network type
     * @param name              Account name
     * @return Old or created account
     */
    @Override
    public AccountEntity getOrCreateAccount(String socialNetworkId, SocialNetworkType socialNetworkType, String name) {
        AccountEntity account = getAccountBySocialNetworkId(socialNetworkId, socialNetworkType);
        if (account == null) {
            AccountEntity newAccount = new AccountEntity();
            newAccount.setName(name);
            if (socialNetworkType == SocialNetworkType.FACEBOOK) {
                newAccount.setFacebookId(socialNetworkId);
            }
            if (socialNetworkType == SocialNetworkType.TWITTER) {
                newAccount.setTwitterId(socialNetworkId);
            }
            if (socialNetworkType == SocialNetworkType.VK_COM) {
                newAccount.setVkId(socialNetworkId);
            }
            /** Units */
            newAccount.setLengthUnit(LengthUnit.CENTIMETER);
            newAccount.setWeightUnit(WeightUnit.KILOGRAM);
            accountRepository.save(newAccount);
            return newAccount;
        } else {
            return account;
        }
    }

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
