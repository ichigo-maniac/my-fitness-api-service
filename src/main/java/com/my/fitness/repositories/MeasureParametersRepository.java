package com.my.fitness.repositories;

import com.my.fitness.entities.AccountEntity;
import com.my.fitness.entities.MeasureParametersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;


/**
 * Measure parameters repository
 */
public interface MeasureParametersRepository extends CrudRepository<MeasureParametersEntity, String> {

    /**
     * Get measure parameters by date and account UUID
     * @param recordDate Record date
     * @param accountUuid Account UUID
     * @return Measure parameters or null
     */
    @Query("SELECT record FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE record." + MeasureParametersEntity.RECORD_DATE + " = :recordDate " +
            "AND record." + MeasureParametersEntity.ACCOUNT + "." + AccountEntity.UUID + " = :accountUuid")
    MeasureParametersEntity getMeasureParametersByDateAndAccountUUID(Date recordDate, String accountUuid);

    /**
     * Get measure parameters by date and account
     * @param recordDate Record date
     * @param account Account
     * @return Measure parameters or null
     */
    @Query("SELECT record FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE record." + MeasureParametersEntity.RECORD_DATE + " = :recordDate " +
            "AND record." + MeasureParametersEntity.ACCOUNT + " = :account")
    MeasureParametersEntity getMeasureParametersByDateAndAccount(Date recordDate, AccountEntity account);

    /**
     * Get measure parameters count by date and account UUID
     * @param recordDate Record date
     * @param accountUuid Account UUID
     * @return Measure parameters count
     */
    @Query("SELECT COUNT(record) FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE record." + MeasureParametersEntity.RECORD_DATE + " = :recordDate " +
            "AND record." + MeasureParametersEntity.ACCOUNT + "." + AccountEntity.UUID + " = :accountUuid")
    Long getMeasureParametersCountByDateAndAccountUUID(Date recordDate, String accountUuid);

    /**
     * Get measure parameters count by date and account
     * @param recordDate Record date
     * @param account Account
     * @return Measure parameters count
     */
    @Query("SELECT COUNT(record) FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE record." + MeasureParametersEntity.RECORD_DATE + " = :recordDate " +
            "AND record." + MeasureParametersEntity.ACCOUNT + " = :account")
    Long getMeasureParametersCountByDateAndAccount(Date recordDate, AccountEntity account);

}
