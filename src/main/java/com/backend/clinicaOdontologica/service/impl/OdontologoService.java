package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.repository.OdontologoRepository;
import com.backend.clinicaOdontologica.service.IOdontologoService;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OdontologoService implements IOdontologoService {


    private final ModelMapper modelMapper;
    private Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);;
    private OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository, ModelMapper modelMapper) {

        this.odontologoRepository = odontologoRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologoEntradaDto) {
        LOGGER.info("OdontologoEntradaDto" + odontologoEntradaDto.toString());
        Odontologo odontologo = modelMapper.map(odontologoEntradaDto, Odontologo.class);
        LOGGER.info("Odontologo Entidad:" + odontologo);
        OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontologoRepository.save(odontologo), OdontologoSalidaDto.class);
        LOGGER.info("OdontologoSalidaDto: " + odontologoSalidaDto);

        return odontologoSalidaDto;
    }

    @Override
    public List<OdontologoSalidaDto> listarOdontologos() {

        List<OdontologoSalidaDto> odontologos = odontologoRepository.findAll().stream().map(odontologo -> modelMapper.map(odontologo,OdontologoSalidaDto.class)).toList();
        LOGGER.info("Listado de los odontologos registrados:" + odontologos.toString());
        return odontologos;

    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {

        if (buscarOdontologoPorId(id) != null){

            odontologoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el Odontologo con id: " + id);

        }
        else {
            LOGGER.error("No se pudo eliminar el odontologo de id: " + id + " ya que no se encuentra registrado.");
            throw new ResourceNotFoundException("No existe registro de odontologo con id: " + id);
        }

    }

    @Override
    public OdontologoSalidaDto buscarOdontologoPorId(Long id) {

        Odontologo odontologoBuscado = odontologoRepository.findById(id).orElse(null);
        OdontologoSalidaDto odontologoEncontrado = null;

        if(odontologoBuscado != null){
            odontologoEncontrado = modelMapper.map(odontologoBuscado, OdontologoSalidaDto.class);
            LOGGER.info("Odonotologo encontrado: " + odontologoEncontrado.toString());
        }
        else LOGGER.error("No se ha encontrado el odontologo con id: " + id);

        return odontologoEncontrado;
    }

    @Override
    public OdontologoSalidaDto actualizarOdontologo(OdontologoEntradaDto odontologoEntradaDto, Long id) {
        Odontologo odontologoRecibido = modelMapper.map(odontologoEntradaDto, Odontologo.class);
        Odontologo odontologoAActualizar = odontologoRepository.findById(id).orElse(null);
        OdontologoSalidaDto odontologoSalidaDto = null;

        if(odontologoAActualizar != null){

            odontologoRecibido.setId(odontologoAActualizar.getId());
            odontologoAActualizar = odontologoRecibido;

            odontologoRepository.save(odontologoAActualizar);
            odontologoSalidaDto = modelMapper.map(odontologoAActualizar, OdontologoSalidaDto.class);
            LOGGER.warn("Odontologo actualizado: ", odontologoSalidaDto.toString());

        } else {
            LOGGER.error("No fue posible actualizar el odontologo porque no se encuentra en nuestra base de datos con id: " + id);
            //lanzar excepcion
        }

        return odontologoSalidaDto;
    }


}
