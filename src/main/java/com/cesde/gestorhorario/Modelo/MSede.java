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
@Table(name = "sede")
public class MSede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    Integer idsede;

    @Column(length = 20, nullable = false)
    String nombresede;

    @Column(length = 5, nullable = false)
    Boolean activo;

    // relaciones
    @OneToMany(mappedBy = "sede")
    @JsonIgnore
    List<MAula> aulas;

    @OneToMany(mappedBy = "sede")
    @JsonIgnore
    List<MHorarioAdmin> horariosAdmin;

    public MSede() {
    }

    public MSede(Integer idsede, String nombresede, Boolean activo) {
        this.idsede = idsede;
        this.nombresede = nombresede;
        this.activo = activo;
    }

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }

    public String getNombresede() {
        return nombresede;
    }

    public void setNombresede(String nombresede) {
        this.nombresede = nombresede;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<MAula> getAulas() {
        return aulas;
    }

    public void setAulas(List<MAula> aulas) {
        this.aulas = aulas;
    }

    public List<MHorarioAdmin> getHorariosAdmin() {
        return horariosAdmin;
    }

    public void setHorariosAdmin(List<MHorarioAdmin> horariosAdmin) {
        this.horariosAdmin = horariosAdmin;
    }
}
