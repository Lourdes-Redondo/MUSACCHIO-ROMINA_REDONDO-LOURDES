package com.backend.clinicaOdontologica.dto.entrada;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class OdontologoEntradaDto {

    @Positive(message = "La matricula del odontologo no puede ser nula o menor a cero")
    private Long numeroDeMatricula;
    @NotBlank(message = "Debe especificarse el nombre del odontologo")
    @Size(max = 50, message = "El nombre debe ser menor a 50 caracteres")
    private String nombre;
    @NotBlank(message = "Debe especificarse el apellido del odontologo")
    @Size(max = 50, message = "El apellido debe ser menor a 50 caracteres")
    private String apellido;


    public OdontologoEntradaDto() {
    }

    public OdontologoEntradaDto(Long numeroDeMatricula, String nombre, String apellido) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public @Positive(message = "La matricula del odontologo no puede ser nula o menor a cero") Long getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public void setNumeroDeMatricula(@Positive(message = "La matricula del odontologo no puede ser nula o menor a cero") Long numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public @NotBlank(message = "Debe especificarse el nombre del odontologo") @Size(max = 50, message = "El nombre debe ser menor a 50 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "Debe especificarse el nombre del odontologo") @Size(max = 50, message = "El nombre debe ser menor a 50 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "Debe especificarse el apellido del odontologo") @Size(max = 50, message = "El apellido debe ser menor a 50 caracteres") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "Debe especificarse el apellido del odontologo") @Size(max = 50, message = "El apellido debe ser menor a 50 caracteres") String apellido) {
        this.apellido = apellido;
    }
}
