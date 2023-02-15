package com.example.bootbooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LoggerConfig {

	@Bean
	@Scope("prototype")
	public Logger getLogger(final InjectionPoint ip) {
		String className = ip.getMethodParameter().getContainingClass().getCanonicalName();
		return LoggerFactory.getLogger(className);

	}
}
