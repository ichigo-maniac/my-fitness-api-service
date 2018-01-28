package com.my.fitness.services;

import com.my.fitness.entities.MeasureParametersEntity;

import java.util.Date;

/**
 * Measure parameters service interface
 */
public interface MeasureParametersService {

    /**
     * Get measure parameters by date
     * @param date Record date
     * @return Measure parameters or null
     */
    MeasureParametersEntity getMeasureParametersByDate(Date date);
}
