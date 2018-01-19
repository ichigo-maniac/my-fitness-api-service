package com.my.fitness.entities;

import javax.persistence.*;

/**
 * Measure parameters entity class
 */
@Entity(name = MeasureParametersEntity.ENTITY_NAME)
@Table(name = "MEASURE_PARAMETERS")
public class MeasureParametersEntity extends AbstractEntity {

    /**
     * Entity name
     */
    public static final String ENTITY_NAME = "MeasureParameters";

    /**
     * Product
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_uuid", referencedColumnName = "uuid", nullable = false)
    private AccountEntity account;
    public static final String ACCOUNT = "account";


}
