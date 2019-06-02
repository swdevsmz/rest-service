package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication
@SpringBootApplication(exclude = MessageSourceAutoConfiguration.class)
public class RestserviceApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestserviceApplication.class, args);
    }

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(RestserviceApplication.class);
//	}
}

