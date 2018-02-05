package com.my.fitness.services;

import com.my.fitness.MyFitnessAppApiServiceApplicationTests;
import com.my.fitness.repositories.MeasureParametersRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Measure parameters service tests
 */
public class MeasureParametersServiceTest extends MyFitnessAppApiServiceApplicationTests {

    /**
     * Measure parameters service
     */
    @Autowired
    private MeasureParametersService measureParametersService;

    @Test
    public void getMeasureParametersByDateAndAccountUUIDTest() {
        Date date = new Date();
        date.setYear(2018);
        date.setMonth(0);
        date.setDate(28);
    }

    @Test
    public void getMeasureParametersByDateAndAccountTest() {
        Date date = new Date();
        date.setYear(2018);
        date.setMonth(0);
        date.setDate(28);
    }


}
