package com.rhabad.peluqueria_canina.services;

import com.rhabad.peluqueria_canina.models.Duenios;
import com.rhabad.peluqueria_canina.repositories.DueniosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class DueniosService {

    HashMap<String, Object> datos;

    private DueniosRepository dueniosRepository;

    //inyectamos la dependencia
    @Autowired
    public DueniosService(DueniosRepository dueniosRepository){
        this.dueniosRepository = dueniosRepository;
    }


    //crear un nuevo registro/como tambien actualizar
    public ResponseEntity<Object> nuevoDuenio(Duenios duenios){
        datos = new HashMap<>();
        Optional<Duenios> due = dueniosRepository.findDueniosByCelular(duenios.getCelular());

        /*comprobamos si ya existe un campo de celular similar en los registros
        * si es asi, saltara error*/
        if (due.isPresent() && duenios.getId_duenio() == null){
            datos.put("error", true);
            datos.put("message", "Numero telefonico ya existente");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        datos.put("message", "Guardado con exito");

        if (duenios.getId_duenio() != null){
            datos.put("message", "Actualizado con exito");
        }

        dueniosRepository.save(duenios);
        datos.put("data", duenios);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    //mostrar los todos los registros
    public List<Duenios> mostrarDuenios(){
        return (List<Duenios>) this.dueniosRepository.findAll();
    }

    //eliminar regitro en base al id
    public ResponseEntity<Object> eliminarDuenio(Long id){
        datos = new HashMap<>();

        boolean existe = dueniosRepository.existsById(id);

        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe un dueño con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        dueniosRepository.deleteById(id);
        datos.put("message", "Dueño eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }


}
