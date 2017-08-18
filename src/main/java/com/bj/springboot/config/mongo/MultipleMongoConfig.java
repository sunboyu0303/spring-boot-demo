package com.bj.springboot.config.mongo;

import com.bj.springboot.properties.MultipleMongoProperties;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by sunboyu on 2017/8/17.
 */
@Configuration
public class MultipleMongoConfig {

    @Autowired
    private MultipleMongoProperties mongoProperties;

    @Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
    @Primary
    public MongoTemplate primaryMongoTemplate(){
        MongoDbFactory mongoDbFactory = primaryFactory(mongoProperties.getPrimary());
        return new MongoTemplate(mongoDbFactory);
    }

    @Bean
    @Qualifier(SecondaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate secondaryMongoTemplate(){
        MongoDbFactory mongoDbFactory = secondaryFactory(mongoProperties.getSecondary());
        return new MongoTemplate(mongoDbFactory);
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory(MongoProperties mongo) {
        MongoClient mongoClient = new MongoClient(mongo.getHost(), mongo.getPort());
        return new SimpleMongoDbFactory(mongoClient, mongo.getDatabase());
    }

    @Bean
    public MongoDbFactory secondaryFactory(MongoProperties mongo) {
        MongoClient mongoClient = new MongoClient(mongo.getHost(), mongo.getPort());
        return new SimpleMongoDbFactory(mongoClient, mongo.getDatabase());
    }
}
