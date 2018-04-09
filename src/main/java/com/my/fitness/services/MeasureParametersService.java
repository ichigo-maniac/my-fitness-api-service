package com.my.fitness.services;

import com.my.fitness.controllers.dto.SaveMeasureParameterDto;
import com.my.fitness.entities.AccountEntity;
import com.my.fitness.entities.MeasureParametersEntity;

import java.util.Date;
import java.util.List;

/**
 * Measure parameters service interface
 */
public interface MeasureParametersService {

    /**
     * Save or update measure parameter
     * @param account Account entity
     * @param saveMeasureParameterDto Save measure parameter data transfer object
     * @return Saved measure parameter
     */
    MeasureParametersEntity saveOrUpdateMeasureParameter(AccountEntity account, SaveMeasureParameterDto saveMeasureParameterDto);

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

    /**
     * Check - are measure parameters existing except one measure parameters entity
     * @param recordDate Record date
     * @param accountUuid Account uuid
     * @param measureParametersUuid Measure parameters uuid
     * @return Check result
     */
    boolean existMeasureParametersExceptOne(Date recordDate, String accountUuid, String measureParametersUuid);

    /**
     * Check - are measure parameters existing except one measure parameters entity
     * @param recordDate Record date
     * @param account Account
     * @param measureParametersUuid Measure parameters uuid
     * @return Check result
     */
    boolean existMeasureParametersExceptOne(Date recordDate, AccountEntity account, String measureParametersUuid);

    /**
     * Get measure parameters by date range and account UUID
     * @param fromDate From date
     * @param toDate Tp date
     * @param accountUuid Account uuid
     * @return List of measure parameters ordered by record date
     */
    List<MeasureParametersEntity> getMeasureParametersByDateRange(Date fromDate, Date toDate, String accountUuid);

    /**
     * Get measure parameters by date range and account UUID
     * @param fromDate From date
     * @param toDate Tp date
     * @param account Account
     * @return List of measure parameters ordered by record date
     */
    List<MeasureParametersEntity> getMeasureParametersByDateRange(Date fromDate, Date toDate, AccountEntity account);

}
