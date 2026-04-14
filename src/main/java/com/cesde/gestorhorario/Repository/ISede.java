package com.cesde.gestorhorario.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cesde.gestorhorario.Modelo.MSede;

@Repository
public interface ISede extends JpaRepository<MSede, Integer> {
    List<MSede> findByNombreSede(String nombresede);


}
