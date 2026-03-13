package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class MPersona {

    @Id
    @Column(name = "identificacion_persona", length = 15)
    String identificacionPersona;

    @Column(length = 40, nullable = false)
    String nombrePersona;

    @Column(length = 100, nullable = false, unique = true)
    String correoPersona;

    @Column(length = 100, nullable = false)
    String contrasenaPersona;

    @Column(length = 5)
    Boolean activo;
}
