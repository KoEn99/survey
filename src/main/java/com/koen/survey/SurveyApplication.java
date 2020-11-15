package com.koen.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class SurveyApplication {
	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}
}
