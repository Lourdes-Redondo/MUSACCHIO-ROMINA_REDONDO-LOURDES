package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.DomicilioEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.exceptions.BadRequestException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:applicationTest.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;


    @Test
    @Order(1)
    void deberiaRegistrarseUnTurno() throws BadRequestException {

        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(new PacienteEntradaDto("Felipe", "Gomez", 578446, LocalDate.of(2024,8,11), new DomicilioEntradaDto("Calle",864,"Localidad","Provincia")), new OdontologoEntradaDto(876246L, "Jose", "Lauren"), LocalDateTime.of(LocalDate.of(2024,5,22), LocalTime.of(15,00,00)));
        TurnoSalidaDto turnoSalidaDto = turnoService.registrarTurno(turnoEntradaDto);

        assertNotNull(turnoSalidaDto);
        assertNotNull(turnoSalidaDto.getId());

    }

    @Test
    @Order(2)
    void deberiaBorrarUnTurno(){

        assertDoesNotThrow(() -> turnoService.eliminarTurno(1L));

    }

    @Test
    @Order(3)
    void deberiaDevolverUnaListaVacia(){

        List<TurnoSalidaDto> listaDeTurnos = turnoService.listarTurnos();
        assertTrue(listaDeTurnos.isEmpty());

    }



}