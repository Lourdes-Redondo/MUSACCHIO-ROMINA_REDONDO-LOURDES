package com.backend.clinicaOdontologica.controller;
import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.service.IOdontologoService;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("odontologos")
@CrossOrigin
public class OdontologoController {

    private IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    @PostMapping("/registrar")
    public OdontologoSalidaDto registrarPaciente(@RequestBody @Valid OdontologoEntradaDto odontologoEntradaDto){
        return odontologoService.registrarOdontologo(odontologoEntradaDto);
    }


    @GetMapping("/listar")
    public List<OdontologoSalidaDto> listarPacientes(){
        return odontologoService.listarOdontologos();
    }


    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarOdontologo(@RequestParam Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>("Paciente eliminado correctamente", HttpStatus.NO_CONTENT);
    }

    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo(@RequestBody @Valid OdontologoEntradaDto odontologoEntradaDto, @PathVariable Long id){
        return new ResponseEntity<>(odontologoService.actualizarOdontologo(odontologoEntradaDto, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoSalidaDto> buscarOdontologoPorId(@PathVariable Long id){
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id), HttpStatus.OK);
    }

}
