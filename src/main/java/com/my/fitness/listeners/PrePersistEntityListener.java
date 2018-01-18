package com.my.fitness.listeners;

import com.my.fitness.entities.AbstractEntity;

/**
 * "Pre-persist" entity listener interface
 */
public interface PrePersistEntityListener<T extends AbstractEntity> extends EntityListener<T> {

    /**
     * "Pre-persist" handler
     * @param entityObject Entity object
     */
    void prePersist(T entityObject);
}
