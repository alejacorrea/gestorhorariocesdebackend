package com.cesde.gestorhorario.Repository;

import com.cesde.gestorhorario.Modelo.MHorarioAdmin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioAdmin extends JpaRepository<MHorarioAdmin, Integer> {
    List<MHorarioAdmin> findByNombreProfesor(String nombreProfesor);

}
