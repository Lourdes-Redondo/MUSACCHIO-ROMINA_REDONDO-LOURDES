package com.backend.clinicaOdontologica.repository;
import com.backend.clinicaOdontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    Odontologo findByNumeroDeMatricula(int numeroDeMatricula);
    Odontologo findByNumeroDeMatriculaAndNombre(int numeroDeMatricula, String nombre);


}
