package com.google.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringTestApplication {
	@Value("${value1}") private String value1;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringTestApplication.class, args);
		SpringTestApplication bean = ctx.getBean(SpringTestApplication.class);
		bean.hello();
		Person person = ctx.getBean(Person.class);
		person.hello();
	}
	
	public void hello() {
		System.out.println(value1);
	}
}
