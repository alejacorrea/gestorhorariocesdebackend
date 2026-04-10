package com.cesde.gestorhorario.Servicios;

import org.springframework.stereotype.Service;

@Service
public class SHorarioAdmin {
    @Autowired
    IHorarioProfesor iHorarioProfesor;

    public SHorarioAdmin(IHorarioProfesor iHorarioProfesor) {
        this.iHorarioProfesor = iHorarioProfesor;
    }
}
