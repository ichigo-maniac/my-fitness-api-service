package com.my.fitness.entities;

import com.my.fitness.enums.LengthUnit;
import com.my.fitness.enums.WeightUnit;

import javax.persistence.*;
import java.util.List;

/**
 * Account entity class
 */
@Entity(name = AccountEntity.ENTITY_NAME)
@Table(name = "ACCOUNTS")
public class AccountEntity extends AbstractEntity {

    /**
     * Entity name
     */
    public static final String ENTITY_NAME = "Account";

    /**
     * Measure parameters
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = MeasureParametersEntity.ACCOUNT, cascade = CascadeType.ALL)
    private List<MeasureParametersEntity> measureParameters;
    public static final String MEASURE_PARAMETERS = "measureParameters";

    /**
     * Length unit
     */
    @Basic(optional = false)
    @Column(name = "length_unit")
    @Enumerated(EnumType.STRING)
    private LengthUnit lengthUnit;
    public static final String LENGTH_UNIT = "lengthUnit";

    /**
     * Weight unit
     */
    @Basic(optional = false)
    @Column(name = "weight_unit")
    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;
    public static final String WEIGHT_UNIT = "weightUnit";

    /**
     * Get measure parameters
     * @return Measure parameters
     */
    public List<MeasureParametersEntity> getMeasureParameters() {
        return measureParameters;
    }

    /**
     * Set measure parameters
     * @param measureParameters Measure parameters
     */
    public void setMeasureParameters(List<MeasureParametersEntity> measureParameters) {
        this.measureParameters = measureParameters;
    }

    /**
     * Get length unit
     * @return Length unit
     */
    public LengthUnit getLengthUnit() {
        return lengthUnit;
    }

    /**
     * Set length unit
     * @param lengthUnit Length unit
     */
    public void setLengthUnit(LengthUnit lengthUnit) {
        this.lengthUnit = lengthUnit;
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
