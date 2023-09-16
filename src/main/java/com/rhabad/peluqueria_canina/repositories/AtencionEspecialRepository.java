package com.rhabad.peluqueria_canina.repositories;

import com.rhabad.peluqueria_canina.models.AtencionEspecial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtencionEspecialRepository extends CrudRepository<AtencionEspecial, Long> {

    @Query("SELECT a FROM AtencionEspecial a WHERE a.tipo_atencion = :tipoAtencion")
    Optional<AtencionEspecial> findByTipoAtencion(@Param("tipoAtencion") String tipoAtencion);
}
