package com.my.fitness.entities;

import com.my.fitness.enums.WeightUnit;
import javax.persistence.*;
import java.util.Date;

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
     * Record date
     */
    @Basic(optional = false)
    @Column(name = "record_date")
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
    @Basic(optional = true)
    @Column(name = "weight_value")
    private Double weightValue;
    public static final String WEIGHT_VALUE = "weightValue";

    /**
     * Weight unit
     */
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "weight_unit")
    private WeightUnit weightUnit;
    public static final String WEIGHT_UNIT = "weightUnit";

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
     * Get account
     * @return Account
     */
    public AccountEntity getAccount() {
        return account;
    }

    /**
     * Set account
     * @param account Account
     */
    public void setAccount(AccountEntity account) {
        this.account = account;
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
