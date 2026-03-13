package com.cesde.gestorhorario.Repository;


import com.cesde.gestorhorario.Modelo.MTipoPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPersona extends JpaRepository<MTipoPersona, Long> {
}