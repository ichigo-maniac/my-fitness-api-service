package com.my.fitness.listeners.impl;

import com.my.fitness.entities.AbstractEntity;
import com.my.fitness.listeners.PrePersistEntityListener;
import com.my.fitness.listeners.PreUpdateEntityListener;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * Abstract entity listener
 */
@Service("abstractEntityListener")
public class AbstractEntityListener implements PrePersistEntityListener<AbstractEntity>, PreUpdateEntityListener<AbstractEntity> {

    /**
     * "Pre-persist" handler
     * @param entityObject Entity object
     */
    @Override
    public void prePersist(AbstractEntity entityObject) {
        if (entityObject.getCreationTime() == null) {
            entityObject.setCreationTime(new Date());
        }
        if (entityObject.getModificationTime() == null) {
            entityObject.setModificationTime(new Date());
        }
    }

    /**
     * "Pre-update" handler
     * @param entityObject Entity object
     */
    @Override
    public void preUpdate(AbstractEntity entityObject) {
        entityObject.setModificationTime(new Date());
    }

    /**
     * Get entity type
     * @return Entity type
     */
    @Override
    public Class<AbstractEntity> getEntityType() {
        return AbstractEntity.class;
    }

}
