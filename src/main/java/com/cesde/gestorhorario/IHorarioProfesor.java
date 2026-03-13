package com.cesde.gestorhorario.Repository;

import com.cesde.gestorhorario.Modelo.MHorarioProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioProfesor extends JpaRepository<MHorarioProfesor, Integer> {

}