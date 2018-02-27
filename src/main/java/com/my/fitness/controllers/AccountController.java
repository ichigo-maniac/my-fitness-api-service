package com.my.fitness.controllers;

import com.my.fitness.controllers.dto.CreateAccountRequest;
import com.my.fitness.converters.impl.AccountEntityConverter;
import com.my.fitness.entities.AccountEntity;
import com.my.fitness.enums.SocialNetworkType;
import com.my.fitness.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
     * Get or create an account
     * @param createAccountRequest Create account request
     * @return Account info
     */
    @RequestMapping(method = RequestMethod.POST, value = "/get_or_create_account")
    public Object getOrCreateAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        AccountEntity account = accountService.getOrCreateAccount(createAccountRequest.getSocialNetworkId(),
                SocialNetworkType.valueOf(createAccountRequest.getSocialNetworkType()),
                createAccountRequest.getName());
        return accountEntityConverter.convert(account);
    }
}
