package com.my.fitness.services.impl;

import com.my.fitness.api.models.CreateMeasureParameterInput;
import com.my.fitness.entities.AccountEntity;
import com.my.fitness.entities.MeasureParametersEntity;
import com.my.fitness.repositories.MeasureParametersRepository;
import com.my.fitness.services.MeasureParametersService;
import com.my.fitness.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Measure parameters service
 */
@Service("measureParametersService")
public class MeasureParametersServiceImpl implements MeasureParametersService {

    /**
     * Measure parameters repository
     */
    @Autowired
    private MeasureParametersRepository measureParametersRepository;

    /**
     * Create or update measure parameter
     * @param account                 Account entity
     * @param createMeasureParameterInput Create measure parameter data transfer object
     * @return Saved measure parameter
     */
    @Override
    public MeasureParametersEntity createOrUpdateMeasureParameter(AccountEntity account, CreateMeasureParameterInput createMeasureParameterInput) {
        MeasureParametersEntity measureParameters = getMeasureParametersByDateAndAccount(createMeasureParameterInput.getRecordDate(), account);
        if (measureParameters == null) {
            measureParameters = new MeasureParametersEntity();
            measureParameters.setAccount(account);
            measureParameters.setRecordDate(createMeasureParameterInput.getRecordDate());
        }
        measureParameters.setWeightUnit(createMeasureParameterInput.getWeightUnit());
        measureParameters.setWeightValue(createMeasureParameterInput.getWeightValue());
        return measureParametersRepository.save(measureParameters);
    }

    /**
     * Get measure parameters by date and account UUID
     * @param recordDate  Record date
     * @param accountUuid Account UUID
     * @return Measure parameters or null
     */
    @Override
    public MeasureParametersEntity getMeasureParametersByDateAndAccountUUID(Date recordDate, String accountUuid) {
        return measureParametersRepository.getMeasureParametersByDateAndAccountUUID(recordDate, accountUuid);
    }

    /**
     * Get measure parameters by date and account
     * @param recordDate Record date
     * @param account    Account
     * @return Measure parameters or null
     */
    @Override
    public MeasureParametersEntity getMeasureParametersByDateAndAccount(Date recordDate, AccountEntity account) {
        return measureParametersRepository.getMeasureParametersByDateAndAccount(recordDate, account);
    }

    /**
     * Check - are measure parameters existing
     * @param recordDate  Record date
     * @param accountUuid Account uuid
     * @return Check result
     */
    @Override
    public boolean existMeasureParameters(Date recordDate, String accountUuid) {
        return measureParametersRepository.getMeasureParametersCountByDateAndAccountUUID(recordDate, accountUuid) > 0;
    }

    /**
     * Check - are measure parameters existing
     * @param recordDate Record date
     * @param account    Account
     * @return Check result
     */
    @Override
    public boolean existMeasureParameters(Date recordDate, AccountEntity account) {
        return measureParametersRepository.getMeasureParametersCountByDateAndAccount(recordDate, account) > 0;
    }

    /**
     * Check - are measure parameters existing except one measure parameters entity
     * @param recordDate            Record date
     * @param accountUuid           Account uuid
     * @param measureParametersUuid Measure parameters uuid
     * @return Check result
     */
    @Override
    public boolean existMeasureParametersExceptOne(Date recordDate, String accountUuid, String measureParametersUuid) {
        return measureParametersRepository.getMeasureParametersCountByDateAndAccountUUIDExceptOne(recordDate, accountUuid, measureParametersUuid) > 0;
    }

    /**
     * Check - are measure parameters existing except one measure parameters entity
     * @param recordDate            Record date
     * @param account               Account
     * @param measureParametersUuid Measure parameters uuid
     * @return Check result
     */
    @Override
    public boolean existMeasureParametersExceptOne(Date recordDate, AccountEntity account, String measureParametersUuid) {
        return measureParametersRepository.getMeasureParametersCountByDateAndAccountExceptOne(recordDate, account, measureParametersUuid) > 0;
    }

    /**
     * Get measure parameters by date range and account UUID
     * @param fromDate    From date
     * @param toDate      Tp date
     * @param accountUuid Account uuid
     * @return List of measure parameters ordered by record date
     */
    @Override
    public List<MeasureParametersEntity> getMeasureParametersByDateRange(Date fromDate, Date toDate, String accountUuid) {
        return measureParametersRepository.getMeasureParametersByDateRange(
                DateUtils.truncDown(fromDate), DateUtils.truncUp(toDate), accountUuid
        );
    }

    /**
     * Get measure parameters by date range and account UUID
     * @param fromDate From date
     * @param toDate   Tp date
     * @param account  Account
     * @return List of measure parameters ordered by record date
     */
    @Override
    public List<MeasureParametersEntity> getMeasureParametersByDateRange(Date fromDate, Date toDate, AccountEntity account) {
        return measureParametersRepository.getMeasureParametersByDateRange(
                DateUtils.truncDown(fromDate), DateUtils.truncUp(toDate), account
        );
    }
}
