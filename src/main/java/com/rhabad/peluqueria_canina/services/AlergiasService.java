package com.rhabad.peluqueria_canina.services;

import com.rhabad.peluqueria_canina.models.Alergias;
import com.rhabad.peluqueria_canina.repositories.AlergiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AlergiasService {

    HashMap<String, Object> datos;
    private AlergiasRepository alergiasRepository;

    @Autowired
    public AlergiasService(AlergiasRepository alergiasRepository){
        this.alergiasRepository = alergiasRepository;
    }

    //crear nuevo registro
    public ResponseEntity<Object> nuevaAlergia(Alergias alergias){
        datos = new HashMap<>();
        Optional<Alergias> aler = alergiasRepository.findAlergiasByNombreAlergias(alergias.getNombre_alergias());

        if (aler.isPresent() && alergias.getId_alergias() == null){
            datos.put("error", true);
            datos.put("message", "Alergia ya existente; ¡no posible clonar misma alergia!");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
                    );
        }

        datos.put("message", "Guardado con exito.");

        if (alergias.getId_alergias() != null){
            datos.put("message", "Actualizado con exito.");
        }

        alergiasRepository.save(alergias);
        datos.put("data", alergias);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    //mostrar todos los registros
    public List<Alergias> leerAlergias(){
        return (List<Alergias>) alergiasRepository.findAll();
    }

    //eliminar un registro
    public ResponseEntity<Object> eliminarAlergia(Long id){
        datos = new HashMap<>();

        boolean existe = alergiasRepository.existsById(id);

        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        alergiasRepository.deleteById(id);
        datos.put("message", "Alergia eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }

}
