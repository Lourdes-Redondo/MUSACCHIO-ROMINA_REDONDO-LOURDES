package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.entity.Paciente;
import com.backend.clinicaOdontologica.entity.Turno;
import com.backend.clinicaOdontologica.repository.TurnoRepository;
import com.backend.clinicaOdontologica.service.ITurnoService;
import com.backend.clinicaOdontologica.exceptions.BadRequestException;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {


    private TurnoRepository turnoRepository;
    private final ModelMapper modelMapper;
    private Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);;


    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper) {

        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException {
        LOGGER.info("TurnoEntradaDto" + turnoEntradaDto.toString());
        Turno turno = modelMapper.map(turnoEntradaDto, Turno.class);
        LOGGER.info("Turno Entidad:" + turno);
        if(turno.getOdontologo() == null){
            new BadRequestException("No hay registro del odontologo");
        } else if (turno.getPaciente() == null) {
            new BadRequestException("No hay registro del paciente");
        }

        TurnoSalidaDto turnoSalidaDto = modelMapper.map(turnoRepository.save(turno), TurnoSalidaDto.class);
        LOGGER.info("TurnoSalidaDto: " + turnoSalidaDto);

        return turnoSalidaDto;
    }

    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        List<TurnoSalidaDto> turnos = turnoRepository.findAll().stream().map(turno -> modelMapper.map(turno,TurnoSalidaDto.class)).toList();
        LOGGER.info("Listado de los turnos registrados: " + turnos.toString());
        return turnos;

    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {

        if(buscarTurnoPorId(id) != null){

            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el Turno con id: " + id);

        }else{
            LOGGER.error("No se pudo eliminar el turno de id: " + id + " ya que no se encuentra registrado.");
            throw new ResourceNotFoundException("No existe el registro del turno con id: " + id);
        }

    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {

        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);
        TurnoSalidaDto turnoEncontrado = null;

        if(turnoBuscado != null){

            turnoEncontrado = modelMapper.map(turnoBuscado, TurnoSalidaDto.class);
            LOGGER.info("Turno encontrado : " + turnoEncontrado);

        }else LOGGER.error("No se encontro el paciente con id " + id);



        return turnoEncontrado;
    }

    @Override
    public TurnoSalidaDto actualizarTurno(TurnoEntradaDto turnoEntradaDto, Long id) {
        Turno turnoRecibido = modelMapper.map(turnoEntradaDto, Turno.class);
        Turno turnoAActualizar = turnoRepository.findById(id).orElse(null);
        TurnoSalidaDto turnoSalidaDto = null;

        if(turnoAActualizar != null){

            turnoRecibido.setId(turnoAActualizar.getId());
            turnoRecibido.getOdontologo().setId(turnoAActualizar.getOdontologo().getId());
            turnoRecibido.getPaciente().setId(turnoAActualizar.getPaciente().getId());
            turnoAActualizar = turnoRecibido;

            turnoRepository.save(turnoAActualizar);
            turnoSalidaDto = modelMapper.map(turnoAActualizar, TurnoSalidaDto.class);
            LOGGER.warn("Turno actualizado: ", turnoSalidaDto.toString());

        } else {
            LOGGER.error("No fue posible actualizar el turno porque no se encuentra en nuestra base de datos con ese id");

        }

        return turnoSalidaDto;
    }

    private void configureMapping(){

        modelMapper.typeMap(PacienteEntradaDto.class,Paciente.class).addMappings(mapper -> mapper.map(PacienteEntradaDto::getDomicilioEntradaDto,Paciente::setDomicilio));
        modelMapper.typeMap(TurnoEntradaDto.class,Turno.class).addMappings(mapper -> mapper.map(TurnoEntradaDto::getPacienteEntradaDto,Turno::setPaciente));
        modelMapper.typeMap(TurnoEntradaDto.class,Turno.class).addMappings(mapper -> mapper.map(TurnoEntradaDto::getOdontologoEntradaDto, Turno::setOdontologo));

    }



}
