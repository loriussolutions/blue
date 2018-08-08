package com.lorius.revenues.blue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Flavio Santos
 */
@Configuration
@PropertySources({ @PropertySource(value = "classpath:messages.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "classpath:config.properties", ignoreResourceNotFound = true) })
public class PropertiesConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
