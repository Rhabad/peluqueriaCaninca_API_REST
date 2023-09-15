package com.rhabad.peluqueria_canina.repositories;

import com.rhabad.peluqueria_canina.models.Duenios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DueniosRepository extends CrudRepository<Duenios, Long> {

    Optional<Duenios> findDueniosByCelular(int celular);

}
