package com.my.fitness.configuration;

import com.my.fitness.constants.MyFitnessApplicationConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Test database
 */
@Configuration
@Profile(MyFitnessApplicationConstants.PROFILES.TEST_PROFILE)
public class TestDatabaseConnectionConfiguration {

    /**
     * Database data source bean (embedded datasource)
     * @return Database data source
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase dataSource = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScripts(
                        "test_sql_migration/V1_01_20180117_1300__accountsAndMeasureParameters.sql"
                )
                .build();
        return dataSource;
    }

}
