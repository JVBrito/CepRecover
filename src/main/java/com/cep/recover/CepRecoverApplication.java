package com.cep.recover;

import com.cep.recover.api.rest.TransactionController;
import com.cep.recover.core.application.service.MongoTransactionService;
import com.cep.recover.infrastructure.persistence.service.MongoTransactionServiceImpl;
import com.cep.recover.infrastructure.rest.services.GoogleMapsGeocodingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {TransactionController.class, MongoTransactionService.class, MongoTransactionServiceImpl.class, GoogleMapsGeocodingServiceImpl.class})
public class CepRecoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CepRecoverApplication.class, args);
	}

}
