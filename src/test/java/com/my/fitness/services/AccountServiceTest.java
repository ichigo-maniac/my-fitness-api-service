package com.my.fitness.services;

import com.my.fitness.MyFitnessAppApiServiceApplicationTests;
import com.my.fitness.entities.AccountEntity;
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

}
