package com.my.fitness.listeners;


import com.my.fitness.entities.AbstractEntity;

/**
 * "Post-persist" entity listener interface
 */
public interface PostPersistEntityListener<T extends AbstractEntity> extends EntityListener<T> {

    /**
     * "Post-persist" handler
     * @param entityObject Entity object
     */
    void postPersist(T entityObject);
}
