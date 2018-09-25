package com.my.fitness.api;

import com.my.fitness.api.models.CreateAccountRequestInput;
import com.my.fitness.converters.impl.AccountEntityConverter;
import com.my.fitness.dto.AccountEntityDto;
import com.my.fitness.entities.AccountEntity;
import com.my.fitness.enums.SocialNetworkType;
import com.my.fitness.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Account api controller
 */
@RestController
@RequestMapping("/account")
public class AccountApi {

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
    @GetMapping(value = "/get_account/{accountUUID}")
    public AccountEntityDto getAccountByUUID(@PathVariable String accountUUID) {
        AccountEntity account = accountService.getAccountByUUID(accountUUID);
        return accountEntityConverter.convert(account);
    }

    /**
     * Get or create an account
     * @param createAccountRequest Create account request
     * @return Account info
     */
    @PostMapping(value = "/get_or_create_account")
    public AccountEntityDto getOrCreateAccount(@RequestBody CreateAccountRequestInput createAccountRequest) {
        AccountEntity account = accountService.getOrCreateAccount(createAccountRequest.getSocialNetworkId(),
                SocialNetworkType.valueOf(createAccountRequest.getSocialNetworkType()),
                createAccountRequest.getName());
        return accountEntityConverter.convert(account);
    }
}
