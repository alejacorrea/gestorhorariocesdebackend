package com.cesde.gestorhorario.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cesde.gestorhorario.Modelo.MAula;

@Repository
public interface IAula extends JpaRepository<MAula, Integer> {
    List<MAula> findByNumeroDeAula(String numerodeaula);


}
