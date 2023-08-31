package com.airport;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class AirportCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportCaseStudyApplication.class, args);
	}
	
	  @Bean
	  public ModelMapper modelMapper() {
	    return new ModelMapper();
	  }
	  
//	  @Bean(name="entityManagerFactory")
//	  public LocalSessionFactoryBean sessionFactory() {
//	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//	      return sessionFactory;
//	  }

}
