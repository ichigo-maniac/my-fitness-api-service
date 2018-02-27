package com.my.fitness.controllers;

import com.my.fitness.controllers.dto.CreateAccountRequest;
import com.my.fitness.dto.AccountEntityDto;
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
     * Get or create an account
     * @param createAccountRequest Create account request
     * @return Account info
     */
    @RequestMapping(method = RequestMethod.POST, value = "/get_or_create_account")
    public Object getOrCreateAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        return null;
    }
}
