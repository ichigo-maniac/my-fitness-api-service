package com.my.fitness;

import com.my.fitness.configuration.TestDatabaseConnectionConfiguration;
import com.my.fitness.constants.MyFitnessApplicationConstants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConnectionConfiguration.class})
@SpringBootTest
@ActiveProfiles(MyFitnessApplicationConstants.PROFILES.TEST_PROFILE)
public class MyFitnessAppApiServiceApplicationTests extends Assert {

	@Test
	public void contextLoads() {
	}

}
