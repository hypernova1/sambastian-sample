package org.sam.api.infra.database;

import org.sam.server.annotation.component.Bean;
import org.sam.server.annotation.component.Component;
import org.sam.sqlexecutor.DataSource;
import org.sam.sqlexecutor.DataSourceConfig;

@Component
public class SqlMapperConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceConfig config = new DataSourceConfig();
        config.setDriverName("org.h2.Driver");
        config.setUrl("jdbc:h2:file:./src/main/resources/database/data");
        config.setUser("sa");
        config.setPassword("");
        return new DataSource(config);
    }

}
