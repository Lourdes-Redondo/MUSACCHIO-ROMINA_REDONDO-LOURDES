package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.DomicilioEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:applicationTest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;


   // @BeforeAll
    //void cargarLaBaseDeTest(){
        //aca se podrian cargar entities de ejemplo para el test, se podria usar un before each
    //}


    @Test
    @Order(1)
    void deberiaRegistrarseUnPacienteDeNombreJuanYRetornarSuId(){

        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Juan", "Perez", 12345, LocalDate.of(2024,06,24), new DomicilioEntradaDto("Calle",234,"Localidad","Provincia"));

        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        //assert
        assertNotNull(pacienteSalidaDto);
        assertNotNull(pacienteSalidaDto.getId());
        assertEquals("Juan",pacienteSalidaDto.getNombre());

    }

    @Test
    @Order(2)
    void deberiaEliminarElPacienteConId1(){

        assertDoesNotThrow(() -> pacienteService.eliminarPaciente(1L)); //La L es para el long

    }

    @Test
    @Order(3)
    void deberiaDevolverUnaListaVaciaDePacientes(){

        List<PacienteSalidaDto> listaDePacientes = pacienteService.listarPacientes();
        assertTrue(listaDePacientes.isEmpty());

    }


}