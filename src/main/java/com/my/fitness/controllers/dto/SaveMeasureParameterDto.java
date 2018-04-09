package com.my.fitness.controllers.dto;

import com.my.fitness.enums.WeightUnit;

import java.io.Serializable;
import java.util.Date;

/**
 * Save measure parameter data transfer object
 */
public class SaveMeasureParameterDto implements Serializable {

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

    /**
     * Get record date
     * @return Record date
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * Set record date
     * @param recordDate Record date
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * Get weight value
     * @return Weight value
     */
    public Double getWeightValue() {
        return weightValue;
    }

    /**
     * Set weight value
     * @param weightValue Weight value
     */
    public void setWeightValue(Double weightValue) {
        this.weightValue = weightValue;
    }

    /**
     * Get weight unit
     * @return Weight unit
     */
    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    /**
     * Set weight unit
     * @param weightUnit Weight unit
     */
    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }
}
