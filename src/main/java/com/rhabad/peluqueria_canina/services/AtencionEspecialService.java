package com.rhabad.peluqueria_canina.services;

import com.rhabad.peluqueria_canina.models.AtencionEspecial;
import com.rhabad.peluqueria_canina.repositories.AtencionEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AtencionEspecialService {

    HashMap<String, Object> datos;
    private AtencionEspecialRepository atencionEspecialRepository;

    @Autowired
    public AtencionEspecialService(AtencionEspecialRepository atencionEspecialRepository){
        this.atencionEspecialRepository = atencionEspecialRepository;
    }


    //crear nuevo registro de atencionEspecial
    public ResponseEntity<Object> nuevaAtencion(AtencionEspecial atencionEspecial){
        datos = new HashMap<>();
        Optional<AtencionEspecial> ate = atencionEspecialRepository.findByTipoAtencion(atencionEspecial.getTipo_atencion());

        if (ate.isPresent() && atencionEspecial.getId_atencion_especial() == null){
            datos.put("error", true);
            datos.put("message", "Atencion ya existente, coloque otro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        datos.put("message", "guardado con exito");

        if (atencionEspecial.getId_atencion_especial() != null){
            datos.put("message", "actualizado con exito");
        }

        atencionEspecialRepository.save(atencionEspecial);
        datos.put("data", atencionEspecial);
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    //leer los registros
    public List<AtencionEspecial> leerAtencionEspecial(){
        return (List<AtencionEspecial>) atencionEspecialRepository.findAll();
    }

    //eliminar registros
    public ResponseEntity<Object> eliminarAtencion(Long id){
        datos = new HashMap<>();
        boolean existe = atencionEspecialRepository.existsById(id);

        if (!existe){
            datos.put("error", true);
            datos.put("message", "error al eliminar, id no existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        atencionEspecialRepository.deleteById(id);
        datos.put("message", "eliminado con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

}
