package com.cesde.gestorhorario.Modelo;

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
