package com.rhabad.peluqueria_canina.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mascotas")
public class Mascotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_mascotas;
    private String nombre_perro;
    private String raza;
    private String color;
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_duenio_fk")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Duenios duenios;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_atencion_especial_fk")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AtencionEspecial atencionEspecial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alergias_fk")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Alergias alergias;



    public Long getNum_mascotas() {
        return num_mascotas;
    }

    public void setNum_mascotas(Long num_mascotas) {
        this.num_mascotas = num_mascotas;
    }

    public String getNombre_perro() {
        return nombre_perro;
    }

    public void setNombre_perro(String nombre_perro) {
        this.nombre_perro = nombre_perro;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Duenios getDuenios() {
        return duenios;
    }

    public void setDuenios(Duenios duenios) {
        this.duenios = duenios;
    }

    public AtencionEspecial getAtencionEspecial() {
        return atencionEspecial;
    }

    public void setAtencionEspecial(AtencionEspecial atencionEspecial) {
        this.atencionEspecial = atencionEspecial;
    }

    public Alergias getAlergias() {
        return alergias;
    }

    public void setAlergias(Alergias alergias) {
        this.alergias = alergias;
    }
}
