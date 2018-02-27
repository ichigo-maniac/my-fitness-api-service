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
     * Name
     */
    @Basic(optional = false)
    private String name;
    public static final String NAME = "name";

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
     * Facebook id
     */
    @Basic(optional = true)
    @Column(name = "facebook_id")
    private String facebookId;
    public static final String FACEBOOK_ID = "facebookId";

    /**
     * Vk.com id
     */
    @Basic(optional = true)
    @Column(name = "vk_id")
    private String vkId;
    public static final String VK_ID = "vkId";

    /**
     * Twitter id
     */
    @Basic(optional = true)
    @Column(name = "twitter_id")
    private String twitterId;
    public static final String TWITTER_ID = "twitterId";

    /**
     * Get name
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

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

    /**
     * Get facebook id
     * @return Facebook id
     */
    public String getFacebookId() {
        return facebookId;
    }

    /**
     * Set facebook id
     * @param facebookId Facebook id
     */
    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    /**
     * Get vk.com id
     * @return Vk.com id
     */
    public String getVkId() {
        return vkId;
    }

    /**
     * Set vk.com id
     * @param vkId Vk.com id
     */
    public void setVkId(String vkId) {
        this.vkId = vkId;
    }

    /**
     * Get twitter id
     * @return Twitter id
     */
    public String getTwitterId() {
        return twitterId;
    }

    /**
     * Set twitter id
     * @param twitterId Twitter id
     */
    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }
}
