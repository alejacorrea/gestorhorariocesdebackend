package com.cesde.gestorhorario.Modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class MMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    Integer idmateria;

    @Column(length = 20, nullable = false)
    String nombremateria;

    @Column(length = 5, nullable = false)
    Boolean activo;

    // relaciones
    @OneToMany(mappedBy = "materia")
    @JsonIgnore
    List<MHorarioAdmin> horariosAdmin;

    public MMateria() {
    }

    public MMateria(Integer idmateria, String nombremateria, Boolean activo) {
        this.idmateria = idmateria;
        this.nombremateria = nombremateria;
        this.activo = activo;
    }

    public Integer getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<MHorarioAdmin> getHorariosAdmin() {
        return horariosAdmin;
    }

    public void setHorariosAdmin(List<MHorarioAdmin> horariosAdmin) {
        this.horariosAdmin = horariosAdmin;
    }
}
