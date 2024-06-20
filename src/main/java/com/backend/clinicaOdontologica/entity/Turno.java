package com.backend.clinicaOdontologica.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TURNOS")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
    private LocalDateTime fechaYHora;

    public Turno() {
    }

    public Turno(Long id, Paciente paciente, Odontologo odontologo, LocalDateTime fechaYHora) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaYHora = fechaYHora;
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDateTime fechaYHora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaYHora = fechaYHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        if(this.paciente == null && this.odontologo == null){
            return "Este turno no tiene paciente ni odontologo para la fecha de: " + this.fechaYHora;
        }
        else if(this.paciente == null){
            return "Este turno no tiene paciente, odontologo"+this.getOdontologo().getNombre() +"  para la fecha de: " + this.fechaYHora;
        }
        else if (this.odontologo ==null){
            return "Este turno no tiene odontologo, paciente"+this.getPaciente().getNombre() +"  para la fecha de: " + this.fechaYHora;
        }

        return "Turno para el paciente: " + this.paciente.getNombre() + " " + this.paciente.getApellido() + ", con el Odontologo: " + this.odontologo.getNombre() + " " + this.odontologo.getApellido() + " para la fecha de: " + this.fechaYHora;
    }

}
