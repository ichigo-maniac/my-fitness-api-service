package com.my.fitness.api.models;

import com.my.fitness.enums.WeightUnit;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Save measure parameter data transfer object
 */
@Getter
@Setter
public class CreateMeasureParameterInput implements Serializable {

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
