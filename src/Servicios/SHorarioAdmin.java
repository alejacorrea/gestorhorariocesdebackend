package com.cesde.gestorhorario.Servicios;

import org.springframework.stereotype.Service;

import com.cesde.gestorhorario.Modelo.MHorarioAdmin;

@Service
public class SHorarioAdmin {
    @Autowired
    IHorarioProfesor iHorarioProfesor;

    public SHorarioAdmin(IHorarioProfesor iHorarioProfesor) {
        this.iHorarioProfesor = iHorarioProfesor;
    }

        // Adicion de registros de clientes
    public MHorarioAdmin adicionarHorario(MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            return iHorarioAdmin.save(mHorarioAdmin);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}




