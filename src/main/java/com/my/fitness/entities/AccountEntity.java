package com.my.fitness.entities;

import com.my.fitness.enums.LengthUnit;
import com.my.fitness.enums.WeightUnit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Account entity class
 */
@Entity(name = AccountEntity.ENTITY_NAME)
@Table(name = "ACCOUNTS")
@Getter @Setter
public class AccountEntity extends AbstractEntity {

    /**
     * Entity name
     */
    public static final String ENTITY_NAME = "Account";

    /**
     * Name
     */
    @Column(name = "name", nullable = false)
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
    @Column(name = "length_unit", nullable = false)
    @Enumerated(EnumType.STRING)
    private LengthUnit lengthUnit;
    public static final String LENGTH_UNIT = "lengthUnit";

    /**
     * Weight unit
     */
    @Column(name = "weight_unit", nullable = false)
    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;
    public static final String WEIGHT_UNIT = "weightUnit";

    /**
     * Facebook id
     */
    @Column(name = "facebook_id")
    private String facebookId;
    public static final String FACEBOOK_ID = "facebookId";

    /**
     * Vk.com id
     */
    @Column(name = "vk_id")
    private String vkId;
    public static final String VK_ID = "vkId";

    /**
     * Twitter id
     */
    @Column(name = "twitter_id")
    private String twitterId;
    public static final String TWITTER_ID = "twitterId";

}
