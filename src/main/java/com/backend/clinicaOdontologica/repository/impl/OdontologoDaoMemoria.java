package com.backend.clinicaOdontologica.repository.impl;

import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.repository.IDao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OdontologoDaoMemoria implements IDao<Odontologo> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OdontologoDaoMemoria.class);
    List<Odontologo> odontologos = new ArrayList<>();

    public OdontologoDaoMemoria() {
        Odontologo o1 = new Odontologo((long)1234,(long)6543,"Pedro","Soarez");
        Odontologo o2 = new Odontologo((long)6746,(long)3326,"Julia","Andes");
        Odontologo o3 = new Odontologo((long)9643,(long)6429,"Lucas","Sosa");

        odontologos.add(o1);
        odontologos.add(o2);
        odontologos.add(o3);

    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {

        LOGGER.info("Odontologo a registrar: " + odontologo);
        Long siguienteId = (long)odontologos.size() + 1;
        Odontologo odontologoRegistrado = new Odontologo(siguienteId, odontologo.getNumeroDeMatricula(), odontologo.getNombre(),odontologo.getApellido());
        LOGGER.info("Se logro registrar al odontologo: " + odontologoRegistrado.getId() + " en memoria.");
        odontologos.add(odontologoRegistrado);
        return odontologoRegistrado;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Listado de odontologos Memoria:" + odontologos);
        return odontologos;
    }
}
