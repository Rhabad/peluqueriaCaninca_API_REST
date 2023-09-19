package com.rhabad.peluqueria_canina.services;

import com.rhabad.peluqueria_canina.models.Alergias;
import com.rhabad.peluqueria_canina.models.AtencionEspecial;
import com.rhabad.peluqueria_canina.models.Duenios;
import com.rhabad.peluqueria_canina.models.Mascotas;
import com.rhabad.peluqueria_canina.repositories.AlergiasRepository;
import com.rhabad.peluqueria_canina.repositories.AtencionEspecialRepository;
import com.rhabad.peluqueria_canina.repositories.DueniosRepository;
import com.rhabad.peluqueria_canina.repositories.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class MascotasService {
    private DueniosRepository dueniosRepository;
    private AlergiasRepository alergiasRepository;
    private AtencionEspecialRepository atencionEspecialRepository;
    private MascotasRepository mascotasRepository;

    HashMap<String, Object> datos;

    @Autowired
    public MascotasService(DueniosRepository dueniosRepository, AlergiasRepository alergiasRepository,
                           AtencionEspecialRepository atencionEspecialRepository, MascotasRepository mascotasRepository){
        this.mascotasRepository = mascotasRepository;
        this.dueniosRepository = dueniosRepository;
        this.alergiasRepository = alergiasRepository;
        this.atencionEspecialRepository = atencionEspecialRepository;
    }


    //crear nuevo registro de mascota
    public ResponseEntity<Object> nuevaMascota(Mascotas mascotas){
        datos = new HashMap<>();
        Optional<Duenios> due = dueniosRepository.findById(mascotas.getDuenios().getId_duenio());
        Optional<Alergias> aler = alergiasRepository.findById(mascotas.getAlergias().getId_alergias());
        Optional<AtencionEspecial> ate = atencionEspecialRepository.findById(mascotas.getAtencionEspecial().getId_atencion_especial());

        if (due.isEmpty() && aler.isEmpty() && ate.isEmpty()){
            datos.put("error", true);
            datos.put("message", "Algunas de las foreign key es nula o no existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message", "guardado con exito");

        if (mascotas.getNum_mascotas() != null){
            datos.put("message", "actualizado con exito");
        }


        mascotas.setDuenios(due.get());
        mascotas.setAlergias(aler.get());
        mascotas.setAtencionEspecial(ate.get());

        mascotasRepository.save(mascotas);
        datos.put("data", mascotas);
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    //leer los registros
    public List<Mascotas> listarMascotas(){
        return (List<Mascotas>) mascotasRepository.findAll();
    }

    //eliminar registro
    public ResponseEntity<Object> eliminarRegistro(Long id){
        datos = new HashMap<>();
        boolean existe = mascotasRepository.existsById(id);

        if (!existe){
            datos.put("error", true);
            datos.put("message", "ID no existente, error al eliminar");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        mascotasRepository.deleteById(id);
        datos.put("message", "registro eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }


}
