package com.autopark.autopark;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getEmbeddedDataSource() throws IOException {
        return EmbeddedPostgres.start().getPostgresDatabase();
    }

}
