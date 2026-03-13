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

    public MTipoPersona(Integer idrol, String rolPersona) {
        this.idRol = idrol;
        this.rolPersona = rolPersona;
    }

    public MTipoPersona() {
    }

    public Integer getIdrol() {
        return idRol;
    }

    public void setIdrol(Integer idrol) {
        this.idRol = idrol;
    }

    public String getRolPersona() {
        return rolPersona;
    }

    public void setRolPersona(String rolPersona) {
        this.rolPersona = rolPersona;
    }
}
