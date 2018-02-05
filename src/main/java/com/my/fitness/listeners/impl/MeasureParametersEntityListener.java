package com.my.fitness.listeners.impl;

import com.my.fitness.entities.MeasureParametersEntity;
import com.my.fitness.listeners.PrePersistEntityListener;
import com.my.fitness.listeners.PreUpdateEntityListener;
import com.my.fitness.services.MeasureParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Measure parameters entity listener
 */
@Service("measureParametersEntityListener")
public class MeasureParametersEntityListener implements PrePersistEntityListener<MeasureParametersEntity>, PreUpdateEntityListener<MeasureParametersEntity> {

    /**
     * Measure parameters service
     */
    @Autowired
    private MeasureParametersService measureParametersService;

    /**
     * "Pre-persist" handler
     * @param entityObject Entity object
     */
    @Override
    public void prePersist(MeasureParametersEntity entityObject) {

    }

    /**
     * "Pre-update" handler
     * @param entityObject Entity object
     */
    @Override
    public void preUpdate(MeasureParametersEntity entityObject) {

    }

    /**
     * Get entity type
     * @return Entity type
     */
    @Override
    public Class<MeasureParametersEntity> getEntityType() {
        return MeasureParametersEntity.class;
    }
}
