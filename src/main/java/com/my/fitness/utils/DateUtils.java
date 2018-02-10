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

    /**
     * Trunc date down
     * @param date Date
     * @return Trunced date
     */
    public static Date truncDown(Date date) {
        Date result = new Date(date.getTime());
        result.setHours(0);
        result.setMinutes(0);
        result.setSeconds(0);
        return result;
    }

    /**
     * Trunc date up
     * @param date Date
     * @return Trunced date
     */
    public static Date truncUp(Date date) {
        Date result = new Date(date.getTime());
        result.setHours(23);
        result.setMinutes(59);
        result.setSeconds(59);
        return result;
    }
}
