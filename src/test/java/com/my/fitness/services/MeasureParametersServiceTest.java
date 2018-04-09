package com.my.fitness.services;

import com.my.fitness.MyFitnessAppApiServiceApplicationTests;
import com.my.fitness.controllers.dto.SaveMeasureParameterDto;
import com.my.fitness.entities.AccountEntity;
import com.my.fitness.entities.MeasureParametersEntity;
import com.my.fitness.enums.WeightUnit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Measure parameters service tests
 */
public class MeasureParametersServiceTest extends MyFitnessAppApiServiceApplicationTests {

    /**
     * Constants
     */
    private static final String ACCOUNT_UUID = "4a9b636e-f065-11e6-9dac-836adef2f111";
    private static final String MEASURE_PARAMETERS_UUID = "4a9b636e-f065-11e6-9dac-836adef2f3a6";

    private static final List<String> MEASURE_PARAMETERS_UUIDS_LIST = Arrays.asList(
            "4a9b636e-f065-11e6-9dac-836adef2f3a6", "4a9b636e-f065-11e6-9dac-836adef21106",
            "4a9b636e-f065-11e6-9dac-836adef55314"
    );

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
     * Method test - measureParametersService.saveOrUpdateMeasureParameterTest
     */
    @Test
    public void saveOrUpdateMeasureParameterTest() {
        AccountEntity account = accountService.getAccountByUUID(ACCOUNT_UUID);
        /** Create a new record */
        SaveMeasureParameterDto saveMeasureParameterDto = new SaveMeasureParameterDto();
        GregorianCalendar calendar = new GregorianCalendar(2018,
                Calendar.JANUARY, 16);
        saveMeasureParameterDto.setRecordDate(calendar.getTime());
        saveMeasureParameterDto.setWeightUnit(WeightUnit.KILOGRAM);
        saveMeasureParameterDto.setWeightValue(105.5);
        MeasureParametersEntity measureParametersEntity = measureParametersService.saveOrUpdateMeasureParameter(account, saveMeasureParameterDto);
        assertTrue(measureParametersEntity.getWeightValue() == 105.5 && measureParametersEntity.getWeightUnit() == WeightUnit.KILOGRAM);
        /** Update record */
        saveMeasureParameterDto.setWeightUnit(WeightUnit.POUND);
        saveMeasureParameterDto.setWeightValue(50.2);
        MeasureParametersEntity measureParametersEntity2 = measureParametersService.saveOrUpdateMeasureParameter(account, saveMeasureParameterDto);
        assertTrue(measureParametersEntity2.getWeightValue() == 50.2 && measureParametersEntity2.getWeightUnit() == WeightUnit.POUND);
        assertTrue(measureParametersEntity.getUuid().equals(measureParametersEntity2.getUuid()));
    }

    /**
     * Method test - measureParametersService.saveOrUpdateMeasureParameterTest
     */
    @Test
    public void saveOrUpdateMeasureParameterTest2() {
        AccountEntity account = accountService.getAccountByUUID(ACCOUNT_UUID);
        /** Create a new record */
        SaveMeasureParameterDto saveMeasureParameterDto = new SaveMeasureParameterDto();
        GregorianCalendar calendar = new GregorianCalendar(2018,
                Calendar.JANUARY, 11);
        saveMeasureParameterDto.setRecordDate(calendar.getTime());
        saveMeasureParameterDto.setWeightUnit(WeightUnit.KILOGRAM);
        saveMeasureParameterDto.setWeightValue(105.5);
        MeasureParametersEntity measureParametersEntity = measureParametersService.saveOrUpdateMeasureParameter(account, saveMeasureParameterDto);
        assertTrue(measureParametersEntity.getWeightValue() == 105.5 && measureParametersEntity.getWeightUnit() == WeightUnit.KILOGRAM);
        /** Update record */
        GregorianCalendar calendar2 = new GregorianCalendar(2018,
                Calendar.JANUARY, 12);
        saveMeasureParameterDto.setRecordDate(calendar2.getTime());
        saveMeasureParameterDto.setWeightUnit(WeightUnit.POUND);
        saveMeasureParameterDto.setWeightValue(50.2);
        MeasureParametersEntity measureParametersEntity2 = measureParametersService.saveOrUpdateMeasureParameter(account, saveMeasureParameterDto);
        assertTrue(measureParametersEntity2.getWeightValue() == 50.2 && measureParametersEntity2.getWeightUnit() == WeightUnit.POUND);
        assertFalse(measureParametersEntity.getUuid().equals(measureParametersEntity2.getUuid()));
    }

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

    /**
     * Method test - measureParametersService.existMeasureParametersExceptOne
     */
    @Test
    public void existMeasureParametersExceptOneTest() {
        AccountEntity account = accountService.getAccountByUUID(ACCOUNT_UUID);
        GregorianCalendar calendar = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        assertEquals(measureParametersService.existMeasureParametersExceptOne(
                calendar.getTime(), account, MEASURE_PARAMETERS_UUID), false);
    }

    /**
     * Method test - measureParametersService.existMeasureParametersExceptOne
     */
    @Test
    public void existMeasureParametersExceptOneTest2() {
        AccountEntity account = accountService.getAccountByUUID(ACCOUNT_UUID);
        GregorianCalendar calendar = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        assertEquals(measureParametersService.existMeasureParametersExceptOne(
                calendar.getTime(), account, MEASURE_PARAMETERS_UUID), false);
    }

    /**
     * Method test - measureParametersService.getMeasureParametersByDateRange
     */
    @Test
    public void getMeasureParametersByDateRangeTest() {
        GregorianCalendar fromDate = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        GregorianCalendar toDate = new GregorianCalendar(2018,
                Calendar.JANUARY, 19);
        List<MeasureParametersEntity> measureParameters = measureParametersService.getMeasureParametersByDateRange(
                fromDate.getTime(), toDate.getTime(), ACCOUNT_UUID);
        assertOrderedUUIDListsEquals(getUUIDs(measureParameters), MEASURE_PARAMETERS_UUIDS_LIST);
    }

    /**
     * Method test - measureParametersService.getMeasureParametersByDateRange
     */
    @Test
    public void getMeasureParametersByDateRangeTest2() {
        AccountEntity account = accountService.getAccountByUUID(ACCOUNT_UUID);
        GregorianCalendar fromDate = new GregorianCalendar(2018,
                Calendar.JANUARY, 15);
        GregorianCalendar toDate = new GregorianCalendar(2018,
                Calendar.JANUARY, 19);
        List<MeasureParametersEntity> measureParameters = measureParametersService.getMeasureParametersByDateRange(
                fromDate.getTime(), toDate.getTime(), account);
        assertOrderedUUIDListsEquals(getUUIDs(measureParameters), MEASURE_PARAMETERS_UUIDS_LIST);
    }


}
