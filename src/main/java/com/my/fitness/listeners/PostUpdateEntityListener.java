package com.my.fitness.listeners;

import com.my.fitness.entities.AbstractEntity;

/**
 * "Post-update" entity listener interface
 */
public interface PostUpdateEntityListener<T extends AbstractEntity> extends EntityListener<T> {

    /**
     * "Post-update" handler
     * @param entityObject Entity object
     */
    void postUpdate(T entityObject);
}
