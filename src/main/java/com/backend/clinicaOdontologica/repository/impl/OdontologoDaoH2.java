package com.backend.clinicaOdontologica.repository.impl;

import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.repository.IDao;

import java.util.ArrayList;
import java.util.List;

import com.backend.clinicaOdontologica.dbconnection.H2Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    //private final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    private static final Logger LOGGER = LoggerFactory.getLogger(OdontologoDaoMemoria.class);


    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologoRegistrado = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,odontologo.getNumeroDeMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            odontologoRegistrado = new Odontologo(odontologo.getNumeroDeMatricula(),odontologo.getNombre(),odontologo.getApellido());

            while(resultSet.next()){

                odontologoRegistrado.setId(resultSet.getLong("id"));

            }

            connection.commit();
            LOGGER.info("Se logro registrar al odontologo: " + odontologoRegistrado.getId() + " en H2.");

        }
        catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.error("Tuvimos un problema. " + e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
        }


        return odontologoRegistrado;
    }


    @Override
    public List<Odontologo> listarTodos() {

        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try{
            connection = H2Connection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Odontologo odontologo = new Odontologo(resultSet.getLong("id"), resultSet.getLong("numerodematricula"), resultSet.getString("nombre"), resultSet.getString("apellido"));
                odontologos.add(odontologo);

            }


        }

        catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
                ex.printStackTrace();
            }
        }


        LOGGER.info("Listado de odontologos H2: " + odontologos);
        return odontologos;
    }
}
