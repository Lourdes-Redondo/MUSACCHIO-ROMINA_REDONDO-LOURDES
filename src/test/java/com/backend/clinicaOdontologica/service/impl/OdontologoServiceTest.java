package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.DomicilioEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:applicationTest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaRegistrarseUnOdontologoDeNombrePedroYRetornarSuId(){

        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto(348345L, "Pedro", "Rodriguez");
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

        //assert
        assertNotNull(odontologoSalidaDto);
        assertNotNull(odontologoSalidaDto.getId());
        assertEquals("Pedro",odontologoSalidaDto.getNombre());

    }

    @Test
    @Order(2)
    void deberiaEliminarElOdontologoConId1(){

        assertDoesNotThrow(() -> odontologoService.eliminarOdontologo(1L)); //La L es para el long

    }

    @Test
    @Order(3)
    void deberiaDevolverUnaListaVaciaDeOdontologos(){

        List<OdontologoSalidaDto> listaDeOdontologos = odontologoService.listarOdontologos();
        assertTrue(listaDeOdontologos.isEmpty());

    }


}