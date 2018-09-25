package com.my.fitness.api.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Create account request data transfer object
 */
@Getter @Setter
public class CreateAccountRequestInput implements Serializable {

    /**
     * Social network id
     */
    private String socialNetworkId;

    /**
     * Social network type
     */
    private String socialNetworkType;

    /**
     * Account name
     */
    private String name;

}
