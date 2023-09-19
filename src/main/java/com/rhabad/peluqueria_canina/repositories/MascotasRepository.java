package com.rhabad.peluqueria_canina.repositories;

import com.rhabad.peluqueria_canina.models.Mascotas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotasRepository extends CrudRepository<Mascotas, Long> {
}
