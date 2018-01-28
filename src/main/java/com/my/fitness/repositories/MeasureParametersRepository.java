package com.my.fitness.repositories;

import com.my.fitness.entities.MeasureParametersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;


/**
 * Measure parameters repository
 */
public interface MeasureParametersRepository extends CrudRepository<MeasureParametersEntity, String> {

    /**
     * Get measure parameters by date
     * @param recordDate Record date
     * @return Measure parameters or null
     */
    @Query("SELECT record FROM " + MeasureParametersEntity.ENTITY_NAME + " as record " +
            "WHERE record." + MeasureParametersEntity.RECORD_DATE + " = :recordDate ")
    MeasureParametersEntity getMeasureParametersByDate(Date recordDate);
}
