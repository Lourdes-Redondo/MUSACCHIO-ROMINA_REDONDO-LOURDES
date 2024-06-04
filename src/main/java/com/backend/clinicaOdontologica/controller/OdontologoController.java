package com.backend.clinicaOdontologica.controller;
import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.service.IOdontologoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {

    private IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //POST
    @PostMapping("/registrar")
    public OdontologoSalidaDto registrarPaciente(@RequestBody @Valid OdontologoEntradaDto odontologoEntradaDto){
        return odontologoService.registrarOdontologo(odontologoEntradaDto);
    }

    //GET
    @GetMapping("/listar")
    public List<OdontologoSalidaDto> listarPacientes(){
        return odontologoService.listarOdontologos();
    }

}
