package com.my.fitness.services;

import com.my.fitness.MyFitnessAppApiServiceApplicationTests;
import com.my.fitness.entities.AccountEntity;
import com.my.fitness.entities.MeasureParametersEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Measure parameters service tests
 */
public class MeasureParametersServiceTest extends MyFitnessAppApiServiceApplicationTests {

    /**
     * Constants
     */
    private static final String ACCOUNT_UUID = "4a9b636e-f065-11e6-9dac-836adef2f111";
    private static final String MEASURE_PARAMETERS_UUID = "4a9b636e-f065-11e6-9dac-836adef2f3a6";

    /**
     * Measure parameters service
     */
    @Autowired
    private MeasureParametersService measureParametersService;

    /**
     * Account service
     */
    @Autowired
    private AccountService accountService;

    /**
     * Method test - measureParametersService.getMeasureParametersByDateAndAccountUUID
     */
    @Test
    public void getMeasureParametersByDateAndAccountUUIDTest() {
        GregorianCalendar calendar = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        MeasureParametersEntity measureParameters = measureParametersService.getMeasureParametersByDateAndAccountUUID(
                calendar.getTime(), ACCOUNT_UUID);
        assertEquals(MEASURE_PARAMETERS_UUID, measureParameters.getUuid());
    }

    /**
     * Method test - measureParametersService.getMeasureParametersByDateAndAccount
     */
    @Test
    public void getMeasureParametersByDateAndAccountTest() {
        AccountEntity account = accountService.getAccountByUUID(ACCOUNT_UUID);
        GregorianCalendar calendar = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        MeasureParametersEntity measureParameters = measureParametersService.getMeasureParametersByDateAndAccount(
                calendar.getTime(), account);
        assertEquals(MEASURE_PARAMETERS_UUID, measureParameters.getUuid());
    }

    /**
     * Method test - measureParametersService.existMeasureParameters
     */
    @Test
    public void existMeasureParametersTest() {
        GregorianCalendar calendar = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        assertEquals(measureParametersService.existMeasureParameters(
                calendar.getTime(), ACCOUNT_UUID), true);
    }

    /**
     * Method test - measureParametersService.existMeasureParameters
     */
    @Test
    public void existMeasureParametersTest2() {
        AccountEntity account = accountService.getAccountByUUID(ACCOUNT_UUID);
        GregorianCalendar calendar = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        assertEquals(measureParametersService.existMeasureParameters(
                calendar.getTime(), account), true);
    }


}
