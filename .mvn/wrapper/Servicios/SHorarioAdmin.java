package com.cesde.gestorhorario.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cesde.gestorhorario.Modelo.MHorarioAdmin;
import com.cesde.gestorhorario.Repositorio.IHorarioAdmin;

@Service
public class SHorarioAdmin {

    @Autowired
    IHorarioAdmin iHorarioAdmin;

    public SHorarioAdmin(IHorarioAdmin iHorarioAdmin) {
        this.iHorarioAdmin = iHorarioAdmin;
    }

    // Adición de registros de horario
    public MHorarioAdmin adicionarHorario(MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            return iHorarioAdmin.save(mHorarioAdmin);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general de horarios
    public List<MHorarioAdmin> consultaGeneralHorario() throws Exception {
        try {
            return iHorarioAdmin.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por ID
    public MHorarioAdmin consultaPorId(Integer idHorario) throws Exception {
        try {
            Optional<MHorarioAdmin> registroEncontrado = iHorarioAdmin.findById(idHorario);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Horario no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    

    // Modificar un horario
    public MHorarioAdmin modificarHorario(Integer idHorario, MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            Optional<MHorarioAdmin> registroEncontrado = iHorarioAdmin.findById(idHorario);
            if (registroEncontrado.isPresent()) {
                MHorarioAdmin nuevoRegistro = registroEncontrado.get();

                // Ajusta estos campos según tu modelo
                nuevoRegistro.setIdHorario(mHorarioAdmin.getIdHorario());
                nuevoRegistro.setFechaInicio(mHorarioAdmin.getFechaInicio());
                nuevoRegistro.setFechaFin(mHorarioAdmin.getFechaFin());
                nuevoRegistro.setActivo(mHorarioAdmin.getActivo());

                return iHorarioAdmin.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar porque el horario no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar horario
    public boolean eliminarHorario(Integer idHorario) throws Exception {
        try {
            Optional<MHorarioAdmin> registroEncontrado = iHorarioAdmin.findById(idHorario);
            if (registroEncontrado.isPresent()) {
                iHorarioAdmin.deleteById(idHorario);
                return true;
            } else
                throw new Exception("No se puede eliminar porque el horario no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Anular horario (cambiar estado)
    public MHorarioAdmin anularHorario(Integer idHorario, MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            Optional<MHorarioAdmin> registroEncontrado = iHorarioAdmin.findById(idHorario);
            if (registroEncontrado.isPresent()) {
                MHorarioAdmin nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setActivo(mHorarioAdmin.getActivo());
                return iHorarioAdmin.save(nuevoRegistro);
            } else
                throw new Exception("No se puede anular porque el horario no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
