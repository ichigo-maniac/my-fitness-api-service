package com.my.fitness.entities;

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
     * Stocks
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = MeasureParametersEntity.ACCOUNT, cascade = CascadeType.ALL)
    private List<MeasureParametersEntity> measureParameters;
    public static final String MEASURE_PARAMETERS = "measureParameters";

}
