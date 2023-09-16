package com.rhabad.peluqueria_canina.repositories;

import com.rhabad.peluqueria_canina.models.Alergias;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlergiasRepository extends CrudRepository<Alergias, Long> {

    @Query("SELECT a FROM Alergias a WHERE a.nombre_alergias = :nombreAlergiaParam")
    Optional<Alergias> findAlergiasByNombreAlergias(@Param("nombreAlergiaParam") String nombre_alergia);
}
