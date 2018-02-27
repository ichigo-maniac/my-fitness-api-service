package com.my.fitness.converters.impl;

import com.my.fitness.dto.AccountEntityDto;
import com.my.fitness.entities.AccountEntity;
import com.my.fitness.enums.LoadOptions;
import org.springframework.stereotype.Service;

/**
 * Account entity converter
 */
@Service("accountEntityConverter")
public class AccountEntityConverter extends AbstractEntityConverter<AccountEntity, AccountEntityDto> {

    /**
     * Convert a source object to a result object
     * @param source  Source object
     * @param options Load options
     * @return Result object
     */
    @Override
    public AccountEntityDto convert(AccountEntity source, LoadOptions... options) {
        if (source == null) {
            return null;
        }
        AccountEntityDto result = new AccountEntityDto();
        fillIn(source, result, options);
        return result;
    }

    /**
     * Fill a result object from a source object
     * @param source  Source object
     * @param result  Result object
     * @param options Load options
     */
    @Override
    public void fillIn(AccountEntity source, AccountEntityDto result, LoadOptions... options) {
        if (source == null || result == null) {
            return;
        }
        super.fillIn(source, result, options);
    }
}
