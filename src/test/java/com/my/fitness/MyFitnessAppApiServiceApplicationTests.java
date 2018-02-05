package com.my.fitness;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * My fitness API application abstract test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DataJpaTest
@EnableAutoConfiguration
@TestPropertySource(locations="classpath:application-test.properties")
@ComponentScan("com.my.fitness")
public abstract class MyFitnessAppApiServiceApplicationTests extends Assert {

}
