package com.vibhorkolte.contentcalendar;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(ContentCalendarApplication.class, args);
		// Get all the beans
//		context.getBeanDefinitionNames();
//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		// Get a single bean by name
		System.out.println(context.getBean("contentCalendarApplication"));
	}

}
