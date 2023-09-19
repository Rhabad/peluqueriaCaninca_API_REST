package com.rhabad.peluqueria_canina.controllers;

import com.rhabad.peluqueria_canina.models.Mascotas;
import com.rhabad.peluqueria_canina.services.MascotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "peluqueriaCanina")
public class MascotasController {
    private MascotasService mascotasService;

    @Autowired
    public MascotasController(MascotasService mascotasService){
        this.mascotasService = mascotasService;
    }

    @PostMapping("/nuevaMascota")
    public ResponseEntity<Object> nuevaMascota(@RequestBody Mascotas mascotas){
        return mascotasService.nuevaMascota(mascotas);
    }

    @GetMapping("/listasMascotas")
    public List<Mascotas> listarMascotas(){
        return mascotasService.listarMascotas();
    }

    @PutMapping("/actualizarMascota")
    public ResponseEntity<Object> actualizarMascota(@RequestBody Mascotas mascotas){
        return mascotasService.nuevaMascota(mascotas);
    }

    @DeleteMapping("/eliminarMascota/{id}")
    public ResponseEntity<Object> eliminarMascota(@PathVariable Long id){
        return mascotasService.eliminarRegistro(id);
    }


}
