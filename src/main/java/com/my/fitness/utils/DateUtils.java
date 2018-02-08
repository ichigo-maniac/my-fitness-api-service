package com.my.fitness.utils;

import java.util.Date;

/**
 * Date utils
 */
public class DateUtils {

    /**
     * Compare date
     * @param firstDate First date
     * @param secondDate Second date
     * @return Compare result
     */
    public static boolean compareDates(Date firstDate, Date secondDate) {
        if (firstDate == null && secondDate == null) {
            return true;
        }
        if ((firstDate != null && secondDate == null) || (firstDate == null && secondDate != null)) {
            return false;
        }
        if (firstDate.getYear() != secondDate.getYear()) {
            return false;
        }
        if (firstDate.getMonth() != secondDate.getMonth()) {
            return false;
        }
        if (firstDate.getDate() != secondDate.getDate()) {
            return false;
        }
        return true;
    }
}
