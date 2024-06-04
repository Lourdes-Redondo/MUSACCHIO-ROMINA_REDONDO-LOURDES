package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.repository.IDao;
import com.backend.clinicaOdontologica.service.IOdontologoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OdontologoService implements IOdontologoService {

    private IDao<Odontologo> odontologoIDao;
    private ModelMapper modelMapper;
    private Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologoEntradaDto) {
        LOGGER.info("OdontologoEntradaDto" + odontologoEntradaDto.toString());
        Odontologo odontologo = modelMapper.map(odontologoEntradaDto, Odontologo.class);
        LOGGER.info("Odontologo Entidad:" + odontologo);
        OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontologoIDao.registrar(odontologo), OdontologoSalidaDto.class);
        LOGGER.info("OdontologoSalidaDto: " + odontologoSalidaDto);

        return odontologoSalidaDto;
    }

    @Override
    public List<OdontologoSalidaDto> listarOdontologos() {

        List<OdontologoSalidaDto> odontologos = odontologoIDao.listarTodos().stream().map(odontologo -> modelMapper.map(odontologo,OdontologoSalidaDto.class)).toList();
        LOGGER.info(odontologos.toString());
        return odontologos;

    }




}
