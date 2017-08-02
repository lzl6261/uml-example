package com.databps.admin.config;

import com.github.mongobee.Mongobee;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import io.github.jhipster.domain.util.JSR310DateConverters.DateToZonedDateTimeConverter;
import io.github.jhipster.domain.util.JSR310DateConverters.ZonedDateTimeToDateConverter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;

@Configuration
@EnableMongoRepositories("com.databps.admin.repository")
@Import(value = MongoAutoConfiguration.class)
public class DatabaseConfiguration {

  private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

  @Bean
  public CustomConversions customConversions() {
    List<Converter<?, ?>> converters = new ArrayList<>();
    converters.add(DateToZonedDateTimeConverter.INSTANCE);
    converters.add(ZonedDateTimeToDateConverter.INSTANCE);
    return new CustomConversions(converters);
  }

  @Bean
  public Mongobee mongobee(MongoClient mongoClient, MongoTemplate mongoTemplate,
      MongoProperties mongoProperties) {
    log.debug("Configuring Mongobee");
    Mongobee mongobee = new Mongobee(mongoClient);
    mongobee.setDbName(mongoProperties.getDatabase());

    ((MappingMongoConverter)mongoTemplate.getConverter()).setTypeMapper(new DefaultMongoTypeMapper(null));

    mongobee.setMongoTemplate(mongoTemplate);
    // package to scan for migrations
    mongobee.setChangeLogsScanPackage("com.databps.admin.config.dbmigrations");
    mongobee.setEnabled(true);

    return mongobee;
  }


}
