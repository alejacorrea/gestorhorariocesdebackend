package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aula")
public class MAula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idaula;

    @Column(length = 20, nullable = false)
    String numerodeaula;

    @Column(nullable = false)
    Integer capacidadaula;

    @Column(length = 5, nullable = false)
    Boolean activo;

    public MAula() {
    }

    public MAula(Integer idaula, String numerodeaula, Integer capacidadaula, Boolean activo) {
        this.idaula = idaula;
        this.numerodeaula = numerodeaula;
        this.capacidadaula = capacidadaula;
        this.activo = activo;
    }

    public Integer getIdaula() {
        return idaula;
    }

    public void setIdaula(Integer idaula) {
        this.idaula = idaula;
    }

    public String getNumerodeaula() {
        return numerodeaula;
    }

    public void setNumerodeaula(String numerodeaula) {
        this.numerodeaula = numerodeaula;
    }

    public Integer getCapacidadaula() {
        return capacidadaula;
    }

    public void setCapacidadaula(Integer capacidadaula) {
        this.capacidadaula = capacidadaula;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
