package com.kovalev.initalizer;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PostreSQL {
   
  public static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:latest");

  public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        TestPropertyValues.of(
          "spring.datasource.url=" + container.getJdbcUrl(),
          "spring.datasource.username=" + container.getUsername(),
          "spring.datasource.password=" + container.getPassword()
      ).applyTo(applicationContext);
    }
  }
}
