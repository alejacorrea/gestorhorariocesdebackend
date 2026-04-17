package com.cesde.gestorhorario.Repository;

import com.cesde.gestorhorario.Modelo.MHorarioProfesor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioProfesor extends JpaRepository<MHorarioProfesor, Integer> {
    List<MHorarioProfesor> findByMateriaProfesor(String materiaProfesor);

}