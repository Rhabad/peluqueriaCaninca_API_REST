package com.rhabad.peluqueria_canina.controllers;

import com.rhabad.peluqueria_canina.models.AtencionEspecial;
import com.rhabad.peluqueria_canina.services.AtencionEspecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "peluqueriaCanina")
public class AtencionEspecialController {
    private AtencionEspecialService atencionEspecialService;

    @Autowired
    public AtencionEspecialController(AtencionEspecialService atencionEspecialService){
        this.atencionEspecialService = atencionEspecialService;
    }

    @PostMapping("/nuevaAtencion")
    public ResponseEntity<Object> nuevaAtencion(@RequestBody AtencionEspecial atencionEspecial){
        return atencionEspecialService.nuevaAtencion(atencionEspecial);
    }

    @GetMapping("/leerAtencion")
    public List<AtencionEspecial> leerAtencion(){
        return atencionEspecialService.leerAtencionEspecial();
    }

    @PutMapping("/actualizarAtencion")
    public ResponseEntity<Object> actualizarAtencion(@RequestBody AtencionEspecial atencionEspecial){
        return atencionEspecialService.nuevaAtencion(atencionEspecial);
    }

    @DeleteMapping("/eliminarAtencion/{id}")
    public ResponseEntity<Object> eliminarAtencion(@PathVariable Long id){
        return atencionEspecialService.eliminarAtencion(id);
    }
}
