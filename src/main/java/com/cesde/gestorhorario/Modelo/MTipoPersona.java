package com.cesde.gestorhorario.Modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table (name = "tipopersona")

public class MTipoPersona {

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idRol;

    @Column(nullable = false, length = 40)
    String rolPersona;

    //relaciones
    @OneToMany(mappedBy = "tipoPersona")
    @JsonIgnore
    List<MPersona> persona;


    public MTipoPersona(Integer idRol, String rolPersona) {
        this.idRol = idRol;
        this.rolPersona = rolPersona;
    }

    public MTipoPersona() {
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRolPersona() {
        return rolPersona;
    }

    public void setRolPersona(String rolPersona) {
        this.rolPersona = rolPersona;
    }
}
