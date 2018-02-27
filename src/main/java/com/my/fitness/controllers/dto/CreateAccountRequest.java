package com.my.fitness.controllers.dto;

import java.io.Serializable;

/**
 * Create account request data transfer object
 */
public class CreateAccountRequest implements Serializable {

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

    /**
     * Get social network id
     * @return Social network id
     */
    public String getSocialNetworkId() {
        return socialNetworkId;
    }

    /**
     * Set social network id
     * @param socialNetworkId Social network id
     */
    public void setSocialNetworkId(String socialNetworkId) {
        this.socialNetworkId = socialNetworkId;
    }

    /**
     * Get social network type
     * @return Social network type
     */
    public String getSocialNetworkType() {
        return socialNetworkType;
    }

    /**
     * Set social network type
     * @param socialNetworkType Social network type
     */
    public void setSocialNetworkType(String socialNetworkType) {
        this.socialNetworkType = socialNetworkType;
    }

    /**
     * Get account name
     * @return Account name
     */
    public String getName() {
        return name;
    }

    /**
     * Set account name
     * @param name Account name
     */
    public void setName(String name) {
        this.name = name;
    }
}
