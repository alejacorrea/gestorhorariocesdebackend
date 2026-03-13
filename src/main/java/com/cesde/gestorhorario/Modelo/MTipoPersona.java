package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.*;


@Entity
@Table (name = "tipoPersona")

public class MTipoPersona {

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 40)
    String rolPersona;

    public MTipoPersona(Long id, String rolPersona) {
        this.id = id;
        this.rolPersona = rolPersona;
    }

    public MTipoPersona() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolPersona() {
        return rolPersona;
    }

    public void setRolPersona(String rolPersona) {
        this.rolPersona = rolPersona;
    }
}
