package com.rhabad.peluqueria_canina.controllers;

import com.rhabad.peluqueria_canina.models.Duenios;
import com.rhabad.peluqueria_canina.services.DueniosService;
import jakarta.websocket.OnClose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "peluqueriaCanina")
public class DueniosController {


    private DueniosService dueniosService;

    @Autowired
    public DueniosController(DueniosService dueniosService){
        this.dueniosService = dueniosService;
    }


    @PostMapping("/nuevoCliente_duenio")
    public ResponseEntity<Object> registrarDuenio(@RequestBody Duenios duenios){
        return dueniosService.nuevoDuenio(duenios);
    }
    @GetMapping("/dueniosMascotas")
    public List<Duenios> mostrarDuenios(){
        return dueniosService.mostrarDuenios();
    }
    @PutMapping("/actualizarDuenio")
    public ResponseEntity<Object> actualizarDuenio(@RequestBody Duenios duenios){
        return dueniosService.nuevoDuenio(duenios);
    }
    @DeleteMapping("/eliminarDuenio/{id}")
    public ResponseEntity<Object> eliminarDuenio(@PathVariable Long id){
        return dueniosService.eliminarDuenio(id);
    }

}
