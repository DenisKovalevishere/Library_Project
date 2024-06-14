package com.kovalev.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:not_git.properties"})
public class AllConfig {

}
