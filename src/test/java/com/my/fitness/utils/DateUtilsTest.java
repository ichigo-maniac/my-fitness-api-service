package com.my.fitness.utils;

import com.my.fitness.MyFitnessAppApiServiceApplicationTests;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Date utils test
 */
public class DateUtilsTest extends MyFitnessAppApiServiceApplicationTests {

    /**
     * Method test - DateUtils.compareDates
     */
    @Test
    public void compareDatesTest() {
        assertEquals(DateUtils.compareDates(null, null), true);
    }

    /**
     * Method test - DateUtils.compareDates
     */
    @Test
    public void compareDatesTest2() {
        GregorianCalendar date = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        assertEquals(DateUtils.compareDates(date.getTime(), null), false);
    }

    /**
     * Method test - DateUtils.compareDates
     */
    @Test
    public void compareDatesTest3() {
        GregorianCalendar date = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        assertEquals(DateUtils.compareDates(null, date.getTime()), false);
    }

    /**
     * Method test - DateUtils.compareDates
     */
    @Test
    public void compareDatesTest4() {
        GregorianCalendar firstDate = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        GregorianCalendar secondDate = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        assertEquals(DateUtils.compareDates(firstDate.getTime(), secondDate.getTime()), true);
    }

    /**
     * Method test - DateUtils.compareDates
     */
    @Test
    public void compareDatesTest5() {
        GregorianCalendar firstDate = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        GregorianCalendar secondDate = new GregorianCalendar(2018,
                Calendar.JANUARY, 16);
        assertEquals(DateUtils.compareDates(firstDate.getTime(), secondDate.getTime()), false);
    }
}
