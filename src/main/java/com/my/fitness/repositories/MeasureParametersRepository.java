package com.my.fitness.repositories;

import com.my.fitness.entities.AccountEntity;
import com.my.fitness.entities.MeasureParametersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;


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
            "WHERE compare_dates(record." + MeasureParametersEntity.RECORD_DATE + ", :recordDate) = true " +
            "AND record." + MeasureParametersEntity.ACCOUNT + "." + AccountEntity.UUID + " = :accountUuid")
    MeasureParametersEntity getMeasureParametersByDateAndAccountUUID(@Param("recordDate") @Temporal(TemporalType.DATE) Date recordDate,
                                                                     @Param("accountUuid") String accountUuid);

    /**
     * Get measure parameters by date and account
     * @param recordDate Record date
     * @param account Account
     * @return Measure parameters or null
     */
    @Query("SELECT record FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE compare_dates(record." + MeasureParametersEntity.RECORD_DATE + ", :recordDate) = true " +
            "AND record." + MeasureParametersEntity.ACCOUNT + " = :account")
    MeasureParametersEntity getMeasureParametersByDateAndAccount(@Param("recordDate") Date recordDate,
                                                                 @Param("account") AccountEntity account);

    /**
     * Get measure parameters count by date and account UUID
     * @param recordDate Record date
     * @param accountUuid Account UUID
     * @return Measure parameters count
     */
    @Query("SELECT COUNT(record) FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE compare_dates(record." + MeasureParametersEntity.RECORD_DATE + ", :recordDate) = true " +
            "AND record." + MeasureParametersEntity.ACCOUNT + "." + AccountEntity.UUID + " = :accountUuid")
    Long getMeasureParametersCountByDateAndAccountUUID(@Param("recordDate") Date recordDate,
                                                       @Param("accountUuid") String accountUuid);

    /**
     * Get measure parameters count by date and account
     * @param recordDate Record date
     * @param account Account
     * @return Measure parameters count
     */
    @Query("SELECT COUNT(record) FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE compare_dates(record." + MeasureParametersEntity.RECORD_DATE + ", :recordDate) = true " +
            "AND record." + MeasureParametersEntity.ACCOUNT + " = :account")
    Long getMeasureParametersCountByDateAndAccount(@Param("recordDate") Date recordDate,
                                                   @Param("account") AccountEntity account);

    /**
     * Get measure parameters count by date and account UUID except one measure parameters entity
     * @param recordDate Record date
     * @param accountUuid Account UUID
     * @param measureParametersUuid Measure parameters uuid
     * @return Measure parameters count
     */
    @Query("SELECT COUNT(record) FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE compare_dates(record." + MeasureParametersEntity.RECORD_DATE + ", :recordDate) = true " +
            "AND record." + MeasureParametersEntity.ACCOUNT + "." + AccountEntity.UUID + " = :accountUuid " +
            "AND record." + MeasureParametersEntity.UUID + " <> :measureParametersUUID")
    Long getMeasureParametersCountByDateAndAccountUUIDExceptOne(@Param("recordDate") Date recordDate,
                                                                @Param("accountUuid") String accountUuid,
                                                                @Param("measureParametersUUID") String measureParametersUuid);

    /**
     * Get measure parameters count by date and account except one measure parameters entity
     * @param recordDate Record date
     * @param account Account
     * @param measureParametersUuid Measure parameters uuid
     * @return Measure parameters count
     */
    @Query("SELECT COUNT(record) FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE compare_dates(record." + MeasureParametersEntity.RECORD_DATE + ", :recordDate) = true " +
            "AND record." + MeasureParametersEntity.ACCOUNT + " = :account " +
            "AND record." + MeasureParametersEntity.UUID + " <> :measureParametersUUID")
    Long getMeasureParametersCountByDateAndAccountExceptOne(@Param("recordDate") Date recordDate,
                                                            @Param("account") AccountEntity account,
                                                            @Param("measureParametersUUID") String measureParametersUuid);

    /**
     * Get measure parameters by date range and account UUID
     * @param fromDate From date
     * @param toDate Tp date
     * @param accountUuid Account uuid
     * @return List of measure parameters ordered by record date
     */
    @Query("SELECT record FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE record." + MeasureParametersEntity.RECORD_DATE + " <= :toDate " +
            "AND record." + MeasureParametersEntity.RECORD_DATE + " >= :fromDate " +
            "AND record." + MeasureParametersEntity.ACCOUNT + "." + AccountEntity.UUID + " = :accountUuid " +
            "ORDER BY record." + MeasureParametersEntity.RECORD_DATE)
    List<MeasureParametersEntity> getMeasureParametersByDateRange(@Param("fromDate") Date fromDate,
                                                                  @Param("toDate") Date toDate,
                                                                  @Param("accountUuid") String accountUuid);

    /**
     * Get measure parameters by date range and account UUID
     * @param fromDate From date
     * @param toDate Tp date
     * @param account Account
     * @return List of measure parameters ordered by record date
     */
    @Query("SELECT record FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE record." + MeasureParametersEntity.RECORD_DATE + " <= :toDate " +
            "AND record." + MeasureParametersEntity.RECORD_DATE + " >= :fromDate " +
            "AND record." + MeasureParametersEntity.ACCOUNT + " = :account " +
            "ORDER BY record." + MeasureParametersEntity.RECORD_DATE)
    List<MeasureParametersEntity> getMeasureParametersByDateRange(@Param("fromDate") Date fromDate,
                                                                  @Param("toDate") Date toDate,
                                                                  @Param("account") AccountEntity account);

}
