package com.my.fitness.controllers;

import com.my.fitness.controllers.dto.CreateAccountRequest;
import com.my.fitness.converters.impl.AccountEntityConverter;
import com.my.fitness.dto.AccountEntityDto;
import com.my.fitness.entities.AccountEntity;
import com.my.fitness.enums.SocialNetworkType;
import com.my.fitness.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Account controller
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    /**
     * Account service
     */
    @Autowired
    private AccountService accountService;

    /**
     * Account entity converter
     */
    @Autowired
    private AccountEntityConverter accountEntityConverter;

    /**
     * Get account by uuid
     * @param accountUUID Account uuid
     * @return Account
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get_account/{accountUUID}")
    public AccountEntityDto getAccountByUUID(@PathVariable String accountUUID) {
        AccountEntity account = accountService.getAccountByUUID(accountUUID);
        return accountEntityConverter.convert(account);
    }

    /**
     * Get or create an account
     * @param createAccountRequest Create account request
     * @return Account info
     */
    @RequestMapping(method = RequestMethod.POST, value = "/get_or_create_account")
    public AccountEntityDto getOrCreateAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        AccountEntity account = accountService.getOrCreateAccount(createAccountRequest.getSocialNetworkId(),
                SocialNetworkType.valueOf(createAccountRequest.getSocialNetworkType()),
                createAccountRequest.getName());
        return accountEntityConverter.convert(account);
    }
}
