package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.repository.impl.OdontologoDaoH2;
import com.backend.clinicaOdontologica.repository.impl.OdontologoDaoMemoria;
import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {


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