package com.cesde.gestorhorario.Repository;


import com.cesde.gestorhorario.Modelo.MTipoPersona;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPersona extends JpaRepository<MTipoPersona, Integer> {
    List<MTipoPersona> findByRolPersona(String rolPersona);



}