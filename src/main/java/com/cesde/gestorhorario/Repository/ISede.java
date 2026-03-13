package com.cesde.gestorhorario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cesde.gestorhorario.Modelo.MSede;

@Repository
public interface ISede extends JpaRepository<MSede, Integer> {

}
