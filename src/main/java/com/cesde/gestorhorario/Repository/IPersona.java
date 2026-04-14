package com.cesde.gestorhorario.Repository;


import com.cesde.gestorhorario.Modelo.MPersona;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends JpaRepository<MPersona, String> {
    List<MPersona> findByNombrePersona(String nombrePersona);


}