package com.backend.clinicaOdontologica;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import com.backend.clinicaOdontologica.repository.impl.OdontologoDaoH2;
import com.backend.clinicaOdontologica.repository.impl.OdontologoDaoMemoria;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClinicaOdontologicaApplicationTests {

	private OdontologoService odontologoService;

	@Test
	void deberiaRetornarUnaListaDeOdontologosEnH2(){

		odontologoService = new OdontologoService(new OdontologoDaoH2());
		assertFalse(odontologoService.listarOdontologos().isEmpty());
	}

	@Test
	void deberiaRetornarUnaListaDeOdontologosEnMemoria(){

		odontologoService = new OdontologoService(new OdontologoDaoMemoria());
		assertFalse(odontologoService.listarOdontologos().isEmpty());

	}

}
