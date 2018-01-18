package com.my.fitness.listeners;

import com.my.fitness.entities.AbstractEntity;

/**
 * "Pre-update" entity listener interface
 */
public interface PreUpdateEntityListener<T extends AbstractEntity> extends EntityListener<T> {

    /**
     * "Pre-update" handler
     * @param entityObject Entity object
     */
    void preUpdate(T entityObject);
}
