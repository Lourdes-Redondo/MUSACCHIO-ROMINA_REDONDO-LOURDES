package com.backend.clinicaOdontologica;

import com.backend.clinicaOdontologica.repository.impl.OdontologoDaoH2;
import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);

	}






}

//@bean
//public ModelMapper modelMapper(){
//	return new ModelMapper();
//}