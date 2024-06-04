package com.backend.clinicaOdontologica.dto.entrada;

import com.backend.clinicaOdontologica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class PacienteEntradaDto {

    @NotBlank(message = "Debe especificarse el nombre del Paciente")
    @Size(max = 50, message = "El nombre debe ser menor a 50 caracteres")
    private String nombre;

    @NotBlank(message = "Debe especificarse el apellido del Paciente")
    @Size(max = 50, message = "El apellido debe ser menor a 50 caracteres")
    private String apellido;

    @Positive(message = "El DNI del Paciente no puede ser nulo o menor a cero")
    private int dni;

    @PastOrPresent(message = "La fecha no puede ser posterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha de ingreso del paciente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;
    @NotNull
    @Valid
    private DomicilioEntradaDto domicilioEntradaDto;

    public PacienteEntradaDto() {
    }

    public PacienteEntradaDto(String nombre, String apellido, int dni, LocalDate fechaIngreso, DomicilioEntradaDto domicilioEntradaDto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilioEntradaDto = domicilioEntradaDto;
    }

    public @NotBlank(message = "Debe especificarse el nombre del Paciente") @Size(max = 50, message = "El nombre debe ser menor a 50 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "Debe especificarse el nombre del Paciente") @Size(max = 50, message = "El nombre debe ser menor a 50 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "Debe especificarse el apellido del Paciente") @Size(max = 50, message = "El apellido debe ser menor a 50 caracteres") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "Debe especificarse el apellido del Paciente") @Size(max = 50, message = "El apellido debe ser menor a 50 caracteres") String apellido) {
        this.apellido = apellido;
    }

    @Positive(message = "El DNI del Paciente no puede ser nulo o menor a cero")
    public int getDni() {
        return dni;
    }

    public void setDni(@Positive(message = "El DNI del Paciente no puede ser nulo o menor a cero") int dni) {
        this.dni = dni;
    }

    public @PastOrPresent(message = "La fecha no puede ser posterior al día de hoy") @NotNull(message = "Debe especificarse la fecha de ingreso del paciente") LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(@PastOrPresent(message = "La fecha no puede ser posterior al día de hoy") @NotNull(message = "Debe especificarse la fecha de ingreso del paciente") LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public @NotNull @Valid DomicilioEntradaDto getDomicilioEntradaDto() {
        return domicilioEntradaDto;
    }

    public void setDomicilioEntradaDto(@NotNull @Valid DomicilioEntradaDto domicilioEntradaDto) {
        this.domicilioEntradaDto = domicilioEntradaDto;
    }
}
