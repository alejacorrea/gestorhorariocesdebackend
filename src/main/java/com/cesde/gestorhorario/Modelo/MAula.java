package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aula")
public class MAula {
    @Id
    @Column(nullable = false)
    Integer idaula;

    @Column(length = 20, nullable = false)
    String numerodeaula;

    @Column(nullable = false)
    Integer capacidadaula;

    @Column(length = 5, nullable = false)
    Boolean activo;
}
