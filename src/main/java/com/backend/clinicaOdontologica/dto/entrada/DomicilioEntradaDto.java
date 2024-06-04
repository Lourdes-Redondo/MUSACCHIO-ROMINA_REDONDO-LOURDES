package com.backend.clinicaOdontologica.dto.entrada;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class DomicilioEntradaDto {
    @NotBlank(message = "Debe especificarse una calle")
    @Size(min=5, message = "La calle debe tener por lo menos 5 caracteres")
    private String calle;

    @Positive(message = "El numero no puede ser nulo o menor a cero")
    private int numero;

    @NotBlank(message = "Debe especificarse una localidad")
    @Size(min=3, message = "La calle debe tener por lo menos 5 caracteres")
    private String localidad;

    @NotBlank(message = "Debe especificarse una provincia")
    @Size(min=5, message = "La calle debe tener por lo menos 5 caracteres")
    private String provincia;

    public DomicilioEntradaDto() {
    }

    public DomicilioEntradaDto(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public @NotBlank(message = "Debe especificarse una calle") @Size(min = 5, message = "La calle debe tener por lo menos 5 caracteres") String getCalle() {
        return calle;
    }

    public void setCalle(@NotBlank(message = "Debe especificarse una calle") @Size(min = 5, message = "La calle debe tener por lo menos 5 caracteres") String calle) {
        this.calle = calle;
    }

    @Positive(message = "El numero no puede ser nulo o menor a cero")
    public int getNumero() {
        return numero;
    }

    public void setNumero(@Positive(message = "El numero no puede ser nulo o menor a cero") int numero) {
        this.numero = numero;
    }

    public @NotBlank(message = "Debe especificarse una localidad") @Size(min = 3, message = "La calle debe tener por lo menos 5 caracteres") String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(@NotBlank(message = "Debe especificarse una localidad") @Size(min = 3, message = "La calle debe tener por lo menos 5 caracteres") String localidad) {
        this.localidad = localidad;
    }

    public @NotBlank(message = "Debe especificarse una provincia") @Size(min = 5, message = "La calle debe tener por lo menos 5 caracteres") String getProvincia() {
        return provincia;
    }

    public void setProvincia(@NotBlank(message = "Debe especificarse una provincia") @Size(min = 5, message = "La calle debe tener por lo menos 5 caracteres") String provincia) {
        this.provincia = provincia;
    }
}
