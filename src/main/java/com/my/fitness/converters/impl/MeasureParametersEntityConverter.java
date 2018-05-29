package com.my.fitness.converters.impl;

import com.my.fitness.dto.MeasureParametersEntityDto;
import com.my.fitness.entities.MeasureParametersEntity;
import com.my.fitness.enums.LoadOptions;
import org.springframework.stereotype.Service;

/**
 * Measure parameters entity converter
 */
@Service("measureParametersEntityConverter")
public class MeasureParametersEntityConverter extends AbstractEntityConverter<MeasureParametersEntity, MeasureParametersEntityDto> {

    /**
     * Convert a source object to a result object
     * @param measureParametersEntity Source object
     * @param options                 Load options
     * @return Result object
     */
    @Override
    public MeasureParametersEntityDto convert(MeasureParametersEntity measureParametersEntity, LoadOptions... options) {
        if (measureParametersEntity == null) {
            return null;
        }
        MeasureParametersEntityDto result = new MeasureParametersEntityDto();
        fillIn(measureParametersEntity, result, options);
        return result;
    }

    /**
     * Fill a result object from a source object
     * @param measureParametersEntity    Source object
     * @param measureParametersEntityDto Result object
     * @param options                    Load options
     */
    @Override
    public void fillIn(MeasureParametersEntity measureParametersEntity, MeasureParametersEntityDto measureParametersEntityDto, LoadOptions... options) {
        super.fillIn(measureParametersEntity, measureParametersEntityDto, options);
        measureParametersEntityDto.setRecordDate(measureParametersEntity.getRecordDate());
        measureParametersEntityDto.setWeightUnit(measureParametersEntity.getWeightUnit());
        measureParametersEntityDto.setWeightValue(measureParametersEntity.getWeightValue());
    }
}
