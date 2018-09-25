package com.my.fitness.dto;

import com.my.fitness.enums.LengthUnit;
import com.my.fitness.enums.WeightUnit;
import lombok.Getter;
import lombok.Setter;

/**
 * Account entity data transfer object
 */
@Getter @Setter
public class AccountEntityDto extends EntityDto {

    /**
     * Name
     */
    private String name;

    /**
     * Length unit
     */
    private LengthUnit lengthUnit;

    /**
     * Weight unit
     */
    private WeightUnit weightUnit;


}
