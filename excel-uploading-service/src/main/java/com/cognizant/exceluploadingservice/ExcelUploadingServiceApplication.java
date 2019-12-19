package com.cognizant.exceluploadingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExcelUploadingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelUploadingServiceApplication.class, args);
	}

}
