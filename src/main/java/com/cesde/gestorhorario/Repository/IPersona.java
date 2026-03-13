package com.cesde.gestorhorario.Repository;


import com.cesde.gestorhorario.Modelo.MPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends JpaRepository<MPersona, Long> {
}