package com.rhabad.peluqueria_canina.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "atencion_especial")
public class AtencionEspecial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_atencion_especial;
    @Column(unique = true)
    private String tipo_atencion;

    @OneToMany(mappedBy = "atencionEspecial")
    private List<Mascotas> listMascotas;


    public Long getId_atencion_especial() {
        return id_atencion_especial;
    }

    public void setId_atencion_especial(Long id_atencion_especial) {
        this.id_atencion_especial = id_atencion_especial;
    }

    public String getTipo_atencion() {
        return tipo_atencion;
    }

    public void setTipo_atencion(String tipo_atencion) {
        this.tipo_atencion = tipo_atencion;
    }

    public List<Mascotas> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascotas> listMascotas) {
        this.listMascotas = listMascotas;
    }
}
