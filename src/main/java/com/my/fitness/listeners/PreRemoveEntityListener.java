package com.my.fitness.listeners;

import com.my.fitness.entities.AbstractEntity;

/**
 * "Pre-remove" entity listener interface
 */
public interface PreRemoveEntityListener<T extends AbstractEntity> extends EntityListener<T> {

    /**
     * "Pre-remove" handler
     * @param entityObject Entity object
     */
    void preRemove(T entityObject);
}
