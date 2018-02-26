package com.my.fitness.services;

import com.my.fitness.MyFitnessAppApiServiceApplicationTests;
import com.my.fitness.entities.AccountEntity;
import com.my.fitness.enums.SocialNetworkType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Account service tests
 */
public class AccountServiceTest extends MyFitnessAppApiServiceApplicationTests {

    /**
     * Constants
     */
    private static final String ACCOUNT_UUID = "4a9b636e-f065-11e6-9dac-836adef2f111";
    private static final String VK_AND_TWITTER_ACCOUNT_UUID = "4a9b636e-f065-11e6-9dac-836adef00000";

    /**
     * Account service
     */
    @Autowired
    private AccountService accountService;

    /**
     * Method test - accountService.getAccountByUUID
     */
    @Test
    public void getAccountByUUIDTest() {
        AccountEntity account = accountService.getAccountByUUID(ACCOUNT_UUID);
        assertEquals(account.getUuid(), ACCOUNT_UUID);
    }

    /**
     * Method test - accountService.getAccountBySocialNetworkId
     */
    @Test
    public void getAccountBySocialNetworkIdTest() {
        AccountEntity account = accountService.getAccountBySocialNetworkId("dummy_facebook_id", SocialNetworkType.FACEBOOK);
        assertEquals(account.getUuid(), ACCOUNT_UUID);
    }

    /**
     * Method test - accountService.getAccountBySocialNetworkId
     */
    @Test
    public void getAccountBySocialNetworkIdTest2() {
        AccountEntity account = accountService.getAccountBySocialNetworkId("dummy_vk_id", SocialNetworkType.VK_COM);
        assertEquals(account.getUuid(), VK_AND_TWITTER_ACCOUNT_UUID);
    }

    /**
     * Method test - accountService.getAccountBySocialNetworkId
     */
    @Test
    public void getAccountBySocialNetworkIdTest3() {
        AccountEntity account = accountService.getAccountBySocialNetworkId("dummy_twitter_id", SocialNetworkType.TWITTER);
        assertEquals(account.getUuid(), VK_AND_TWITTER_ACCOUNT_UUID);
    }

}
