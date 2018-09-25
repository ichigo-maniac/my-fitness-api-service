package com.my.fitness.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity data transfer object
 */
@Getter
@Setter
public class EntityDto implements Serializable {

    private static final long serialVersionUID = -7398836737277111538L;

    /**
     * Entity id
     */
    private String uuid;

    /**
     * Creation time
     */
    private Date creationTime;

    /**
     * Modification time
     */
    private Date modificationTime;

    /**
     * Get hash code
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

    /**
     * Equals
     * @param object Object
     * @return Compare result
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final EntityDto other = (EntityDto) object;
        if (this.getUuid() != other.getUuid()
                && (this.getUuid() == null || !this.getUuid().equals(other.getUuid()))) {
            return false;
        }
        return true;
    }
}
