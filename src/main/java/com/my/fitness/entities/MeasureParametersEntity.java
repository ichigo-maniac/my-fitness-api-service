package com.my.fitness.entities;

import com.my.fitness.enums.WeightUnit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Measure parameters entity class
 */
@Entity(name = MeasureParametersEntity.ENTITY_NAME)
@Table(name = "MEASURE_PARAMETERS")
@Getter @Setter
public class MeasureParametersEntity extends AbstractEntity {

    /**
     * Entity name
     */
    public static final String ENTITY_NAME = "MeasureParameters";

    /**
     * Record date
     */
    @Column(name = "record_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date recordDate;
    public static final String RECORD_DATE = "recordDate";

    /**
     * Product
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_uuid", referencedColumnName = "uuid", nullable = false)
    private AccountEntity account;
    public static final String ACCOUNT = "account";

    /**
     * Weight value
     */
    @Column(name = "weight_value")
    private Double weightValue;
    public static final String WEIGHT_VALUE = "weightValue";

    /**
     * Weight unit
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "weight_unit", nullable = false)
    private WeightUnit weightUnit;
    public static final String WEIGHT_UNIT = "weightUnit";

}
