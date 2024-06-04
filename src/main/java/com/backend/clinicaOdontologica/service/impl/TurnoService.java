package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.entity.Turno;
import com.backend.clinicaOdontologica.repository.IDao;
import com.backend.clinicaOdontologica.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TurnoService implements ITurnoService {

    private IDao<Turno> turnoIDao;
    private ModelMapper modelMapper;
    private Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);;


    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) {
        LOGGER.info("TurnoEntradaDto" + turnoEntradaDto.toString());
        Turno turno = modelMapper.map(turnoEntradaDto, Turno.class);
        LOGGER.info("Turno Entidad:" + turno);
        TurnoSalidaDto turnoSalidaDto = modelMapper.map(turnoIDao.registrar(turno), TurnoSalidaDto.class);
        LOGGER.info("TurnoSalidaDto: " + turnoSalidaDto);

        return turnoSalidaDto;
    }

    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        List<TurnoSalidaDto> turnos = turnoIDao.listarTodos().stream().map(turno -> modelMapper.map(turno,TurnoSalidaDto.class)).toList();
        LOGGER.info(turnos.toString());
        return turnos;

    }

    private void configureMapping(){

        modelMapper.typeMap(PacienteEntradaDto.class,Paciente.class).addMappings(mapper -> mapper.map(PacienteEntradaDto::getDomicilioEntradaDto,Paciente::setDomicilio));
        modelMapper.typeMap(TurnoEntradaDto.class,Turno.class).addMappings(mapper -> mapper.map(TurnoEntradaDto::getPacienteEntradaDto,Turno::setPaciente));

    }
}
