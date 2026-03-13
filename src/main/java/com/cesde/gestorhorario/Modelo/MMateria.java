package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class MMateria {
    @Id
    @Column(nullable = false)
    Integer idmateria;

    @Column(length = 20, nullable = false)
    String nombremateria;

    @Column(length = 5, nullable = false)
    Boolean activo;
}
