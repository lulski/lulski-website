package com.lulski.blog.sage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SageApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SageApplication.class, args);

		System.out.println(">>> dumping beanName:");
		 for (String beanName : context.getBeanDefinitionNames()){
			 System.out.println(beanName);
		 }
	}

}
