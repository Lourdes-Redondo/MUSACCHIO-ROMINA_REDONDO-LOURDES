package com.backend.clinicaOdontologica.dto.entrada;


import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class TurnoEntradaDto {

    @Positive(message = "La ID del paciente debe ser un numero positivo")
    private Long pacienteId;
    @Positive(message = "La ID del odontologo debe ser un numero positivo")
    private Long odontologoId;
    @FutureOrPresent(message = "La fecha del turno no puede ser anterior a la fecha de Hoy")
    private LocalDateTime fechaYHora;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(Long pacienteId, Long odontologoId, LocalDateTime fechaYHora) {
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
        this.fechaYHora = fechaYHora;
    }

    public @Positive(message = "La ID del paciente debe ser un numero positivo") Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(@Positive(message = "La ID del paciente debe ser un numero positivo") Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public @Positive(message = "La ID del odontologo debe ser un numero positivo") Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(@Positive(message = "La ID del odontologo debe ser un numero positivo") Long odontologoId) {
        this.odontologoId = odontologoId;
    }

    public @FutureOrPresent(message = "La fecha del turno no puede ser anterior a la fecha de Hoy") LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(@FutureOrPresent(message = "La fecha del turno no puede ser anterior a la fecha de Hoy") LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
