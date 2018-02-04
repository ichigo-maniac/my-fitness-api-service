package com.my.fitness.services;

import com.my.fitness.entities.AccountEntity;
import com.my.fitness.entities.MeasureParametersEntity;

import java.util.Date;

/**
 * Measure parameters service interface
 */
public interface MeasureParametersService {

    /**
     * Get measure parameters by date and account UUID
     * @param recordDate Record date
     * @param accountUuid Account UUID
     * @return Measure parameters or null
     */
    MeasureParametersEntity getMeasureParametersByDateAndAccountUUID(Date recordDate, String accountUuid);

    /**
     * Get measure parameters by date and account
     * @param recordDate Record date
     * @param account Account
     * @return Measure parameters or null
     */
    MeasureParametersEntity getMeasureParametersByDateAndAccount(Date recordDate, AccountEntity account);

    /**
     * Check - are measure parameters existing
     * @param recordDate Record date
     * @param accountUuid Account uuid
     * @return Check result
     */
    boolean existMeasureParameters(Date recordDate, String accountUuid);

    /**
     * Check - are measure parameters existing
     * @param recordDate Record date
     * @param account Account
     * @return Check result
     */
    boolean existMeasureParameters(Date recordDate, AccountEntity account);

}
