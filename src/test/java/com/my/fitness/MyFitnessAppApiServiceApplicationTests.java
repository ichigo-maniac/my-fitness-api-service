package com.my.fitness;

import com.my.fitness.entities.AbstractEntity;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    /**
     * Get entities UUIDs
     * @param entities List of entities
     * @return List of UUID
     */
    protected <T extends AbstractEntity> List<String> getUUIDs(List<T> entities) {
        List<String> result = new ArrayList<String>(entities.size());
        for (T entity : entities) {
            result.add(entity.getUuid());
        }
        return result;
    }


    /***
     * Assert UUID lists equals
     * @param firstList First list of UUIDs
     * @param secondList Second list of UUIDs
     */
    protected void assertOrderedUUIDListsEquals(List<String> firstList, List<String> secondList) {
        if (firstList.size() != secondList.size()) {
            assertEquals("First list doesn't have same size as second list", firstList.size(), secondList.size());
        }
        boolean areListsEqual = true;
        for (int i = 0; i < firstList.size(); i++) {
            if (!firstList.get(i).equals(secondList.get(i))) {
                areListsEqual = false;
            }
        }
        assertEquals("Lists are not equal", areListsEqual, true);
    }

    /***
     * Assert UUID lists equals
     * @param firstList First list of UUIDs
     * @param secondList Second list of UUIDs
     */
    protected void assertUuidListsEquals(List<String> firstList, List<String> secondList) {
        if (firstList.size() != secondList.size()) {
            assertEquals("First list doesn't have same size as second list", firstList.size(), secondList.size());
        }
        Collections.sort(firstList);
        Collections.sort(secondList);
        assertArrayEquals("Lists are not equal", firstList.toArray(), secondList.toArray());
    }
}
