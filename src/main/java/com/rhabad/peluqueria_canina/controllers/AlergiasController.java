package com.rhabad.peluqueria_canina.controllers;

import com.rhabad.peluqueria_canina.models.Alergias;
import com.rhabad.peluqueria_canina.services.AlergiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "peluqueriaCanina")
public class AlergiasController {

    private AlergiasService alergiasService;

    @Autowired
    public AlergiasController(AlergiasService alergiasService){
        this.alergiasService = alergiasService;
    }


    @PostMapping("/nuevaAlergia")
    public ResponseEntity<Object> nuevaAlergia(@RequestBody Alergias alergias){
        return alergiasService.nuevaAlergia(alergias);
    }


    @GetMapping("/mostrarAlergias")
    public List<Alergias> mostrarAlergias(){
        return alergiasService.leerAlergias();
    }


    @PutMapping("/actualizarAlergia")
    public ResponseEntity<Object> actualizarAlergia(@RequestBody Alergias alergias){
        return alergiasService.nuevaAlergia(alergias);
    }

    @DeleteMapping("/eliminarAlergia/{id}")
    public ResponseEntity<Object> eliminarAlergia(@PathVariable Long id){
        return alergiasService.eliminarAlergia(id);
    }

}
