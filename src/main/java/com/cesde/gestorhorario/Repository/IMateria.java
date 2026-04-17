package com.cesde.gestorhorario.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cesde.gestorhorario.Modelo.MMateria;

@Repository
public interface IMateria extends JpaRepository<MMateria, Integer> {
    List<MMateria> findByNombremateria(String nombremateria);

}
