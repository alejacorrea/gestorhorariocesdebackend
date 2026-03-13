package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sede")
public class MSede {
    @Id
    @Column(nullable = false)
    Integer idsede;

    @Column(length = 20, nullable = false)
    String nombresede;

    @Column(length = 5, nullable = false)
    Boolean activo;
}
