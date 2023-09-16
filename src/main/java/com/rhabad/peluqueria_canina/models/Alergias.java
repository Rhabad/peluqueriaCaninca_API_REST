package com.rhabad.peluqueria_canina.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alergias")
public class Alergias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alergias;
    @Column(name = "nombre_alergia",unique = true)
    private String nombre_alergias;

    @OneToMany(mappedBy = "alergias")
    private List<Mascotas> listMascotas;

    public Long getId_alergias() {
        return id_alergias;
    }

    public void setId_alergias(Long id_alergias) {
        this.id_alergias = id_alergias;
    }

    public String getNombre_alergias() {
        return nombre_alergias;
    }

    public void setNombre_alergias(String nombre_alergias) {
        this.nombre_alergias = nombre_alergias;
    }

    public List<Mascotas> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascotas> listMascotas) {
        this.listMascotas = listMascotas;
    }
}
