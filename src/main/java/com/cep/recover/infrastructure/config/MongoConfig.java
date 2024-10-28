package com.cep.recover.infrastructure.config;

import com.mongodb.client.MongoClient;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Objects;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Autowired
    private Environment env;

    @NotNull
    @Override
    protected String getDatabaseName() {
        return Objects.requireNonNull(env.getProperty("spring.data.mongodb.database"));
    }

}