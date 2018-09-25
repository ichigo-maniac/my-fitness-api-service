package com.my.fitness.dto;

import com.my.fitness.enums.WeightUnit;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Measure parameters entity data transfer object
 */
@Getter @Setter
public class MeasureParametersEntityDto extends EntityDto {

    /**
     * Record date
     */
    private Date recordDate;

    /**
     * Weight value
     */
    private Double weightValue;

    /**
     * Weight unit
     */
    private WeightUnit weightUnit;

}
