package com.rhabad.peluqueria_canina.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "duenios")
public class Duenios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_duenio;
    private String nombre;
    @Column(unique = true)
    private int celular;
    private String direccion;

    @OneToMany(mappedBy = "duenios", cascade = CascadeType.ALL)
    private List<Mascotas> listMascotas;


    public Long getId_duenio() {
        return id_duenio;
    }

    public void setId_duenio(Long id_duenio) {
        this.id_duenio = id_duenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Mascotas> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascotas> listMascotas) {
        this.listMascotas = listMascotas;
    }
}
