package com.cesde.gestorhorario.Modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aula")
public class MAula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    Integer idaula;

    @Column(length = 20, nullable = false)
    String numerodeaula;

    @Column(nullable = false)
    Integer capacidadaula;

    @Column(length = 5, nullable = false)
    Boolean activo;

    // relaciones
    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id_sede")
    MSede sede;

    @OneToMany(mappedBy = "aula")
    @JsonIgnore
    List<MHorarioAdmin> horariosAdmin;

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

    public MSede getSede() {
        return sede;
    }

    public void setSede(MSede sede) {
        this.sede = sede;
    }

    public List<MHorarioAdmin> getHorariosAdmin() {
        return horariosAdmin;
    }

    public void setHorariosAdmin(List<MHorarioAdmin> horariosAdmin) {
        this.horariosAdmin = horariosAdmin;
    }
}
