package com.my.fitness.converters.impl;

import com.my.fitness.converters.Converter;
import com.my.fitness.dto.EntityDto;
import com.my.fitness.entities.AbstractEntity;
import com.my.fitness.enums.LoadOptions;
import java.util.Date;

/**
 * Abstract entity converter
 */
public abstract class AbstractEntityConverter<SOURCE extends AbstractEntity, RESULT extends EntityDto> implements Converter<SOURCE, RESULT> {

    /**
     * Fill a result object from a source object
     * @param source  Source object
     * @param result  Result object
     * @param options Load options
     */
    @Override
    public void fillIn(SOURCE source, RESULT result, LoadOptions... options) {
        if (source == null || result == null) {
            return;
        }
        result.setUuid(source.getUuid());
        result.setCreationTime(source.getCreationTime() == null ? null : new Date(source.getCreationTime().getTime()));
        result.setModificationTime(source.getModificationTime() == null ? null : new Date(source.getModificationTime().getTime()));
    }
}
