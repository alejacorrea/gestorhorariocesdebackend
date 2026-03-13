package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.DialectOverride;

@Entity
@Table (name = "tipoPersona")
@DialectOverride.Check(constraints = "rol_persona IN ('Administrador', 'Profesor')")

public class MTipoPersona {

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String rolPersona;

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
