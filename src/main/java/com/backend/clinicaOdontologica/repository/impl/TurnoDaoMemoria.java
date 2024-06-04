package com.backend.clinicaOdontologica.repository.impl;

import com.backend.clinicaOdontologica.entity.Domicilio;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.entity.Turno;
import com.backend.clinicaOdontologica.repository.IDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class TurnoDaoMemoria implements IDao<Turno> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OdontologoDaoMemoria.class);
    private List<Turno> turnos;


    public TurnoDaoMemoria() {

        Paciente paciente1 = new Paciente("Romina","Ramirez",128747, LocalDate.of(2024,11,23),new Domicilio("Avenida F",123,"Palermo","BSAS"));
        Odontologo odontologo1 = new Odontologo((long)34454654,"Jose","Fernandez");
        Turno turno1 = new Turno(paciente1,odontologo1, LocalDateTime.of(LocalDate.of(2024,12,3), LocalTime.of(13,30,00)));

        turnos.add(turno1);

    }

    @Override
    public Turno registrar(Turno turno) {
        LOGGER.info("Turno a registrar en Memoria: " + turno);
        Long siguienteId = (long) turnos.size() + 1;
        Turno turnoRegistrado = new Turno(siguienteId,turno.getPaciente(),turno.getOdontologo(),turno.getFechaYHora());
        LOGGER.info("Turno registrado en Memoria :" + turnoRegistrado);
        turnos.add(turnoRegistrado);
        return turnoRegistrado;
    }

    @Override
    public List<Turno> listarTodos() {
        LOGGER.info("Lista de turnos en Memoria: " + turnos);
        return turnos;
    }
}
