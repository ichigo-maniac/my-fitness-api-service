package com.my.fitness.listeners;

import com.my.fitness.entities.AbstractEntity;

/**
 * "Post-load" entity listener interface
 */
public interface PostLoadEntityListener<T extends AbstractEntity> extends EntityListener<T> {

    /**
     * "Post-load" handler
     * @param entityObject Entity object
     */
    void postLoad(T entityObject);
}
