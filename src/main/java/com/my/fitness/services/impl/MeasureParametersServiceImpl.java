package com.my.fitness.services.impl;

import com.my.fitness.entities.MeasureParametersEntity;
import com.my.fitness.repositories.MeasureParametersRepository;
import com.my.fitness.services.MeasureParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
     * Get measure parameters by date
     * @param date Record date
     * @return Measure parameters or null
     */
    @Override
    public MeasureParametersEntity getMeasureParametersByDate(Date date) {
        return measureParametersRepository.getMeasureParametersByDate(date);
    }
}
