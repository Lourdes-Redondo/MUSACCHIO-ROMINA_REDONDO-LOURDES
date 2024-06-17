package com.backend.clinicaOdontologica.dto.entrada;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

public class TurnoEntradaDto {

    @Valid
    private PacienteEntradaDto pacienteEntradaDto;
    @Valid
    private OdontologoEntradaDto odontologoEntradaDto;
    @FutureOrPresent(message = "La fecha del turno no puede ser anterior a la fecha de Hoy")
    private LocalDateTime fechaYHora;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(PacienteEntradaDto pacienteEntradaDto, OdontologoEntradaDto odontologo, LocalDateTime fechaYHora) {
        this.pacienteEntradaDto = pacienteEntradaDto;
        this.odontologoEntradaDto = odontologo;
        this.fechaYHora = fechaYHora;
    }

    public @Valid PacienteEntradaDto getPacienteEntradaDto() {
        return pacienteEntradaDto;
    }

    public void setPacienteEntradaDto(@Valid PacienteEntradaDto pacienteEntradaDto) {
        this.pacienteEntradaDto = pacienteEntradaDto;
    }

    public @Valid OdontologoEntradaDto getOdontologoEntradaDto() {
        return odontologoEntradaDto;
    }

    public void setOdontologo(@Valid OdontologoEntradaDto odontologo) {
        this.odontologoEntradaDto = odontologo;
    }

    public @FutureOrPresent(message = "La fecha del turno no puede ser anterior a la fecha de Hoy") LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(@FutureOrPresent(message = "La fecha del turno no puede ser anterior a la fecha de Hoy") LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
