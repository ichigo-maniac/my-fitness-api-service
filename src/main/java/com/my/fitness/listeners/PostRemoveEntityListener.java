package com.my.fitness.listeners;

import com.my.fitness.entities.AbstractEntity;

/**
 * "Post-remove" entity listener interface
 */
public interface PostRemoveEntityListener<T extends AbstractEntity> extends EntityListener<T> {

    /**
     * "Post-remove" handler
     * @param entityObject Entity object
     */
    void postRemove(T entityObject);
}
