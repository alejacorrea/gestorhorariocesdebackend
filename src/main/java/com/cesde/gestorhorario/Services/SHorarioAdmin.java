package com.cesde.gestorhorario.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cesde.gestorhorario.Modelo.MHorarioAdmin;
import com.cesde.gestorhorario.Repository.IHorarioAdmin;

@Service
public class SHorarioAdmin {
    @Autowired
    IHorarioAdmin iHorarioAdmin;

    public SHorarioAdmin(IHorarioAdmin iHorarioAdmin) {
        this.iHorarioAdmin = iHorarioAdmin;
    }

    // Adicion de horario admin
    public MHorarioAdmin adicionarHorarioAdmin(MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            return iHorarioAdmin.save(mHorarioAdmin);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de registros de horario admin
    public List<MHorarioAdmin> consultaGeneralHorarioAdmin() throws Exception {
        try {
            return iHorarioAdmin.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual por llave primaria
    public MHorarioAdmin consultaIndividualId(Integer idhorario) throws Exception {
        try {
            Optional<MHorarioAdmin> registroEncontrado = iHorarioAdmin.findById(idhorario);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Horario Admin no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    // consulta por nombre profesor
    public List<MHorarioAdmin> consultaPorNombreProfesoHorarioAdmins(String nombreProfesor) throws Exception {
        try {
            return iHorarioAdmin.findByNombreProfesor(nombreProfesor);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // modificar un registro de horario admin
    public MHorarioAdmin modificarHorarioAdmin(Integer idhorario, MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            Optional<MHorarioAdmin> registroEncontrado = iHorarioAdmin.findById(idhorario);
            if (registroEncontrado.isPresent()) {
                MHorarioAdmin nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdhorario(mHorarioAdmin.getIdhorario());
                nuevoRegistro.setFechainicio(mHorarioAdmin.getFechainicio());
                nuevoRegistro.setFechafin(mHorarioAdmin.getFechafin());
                nuevoRegistro.setHorainicio(mHorarioAdmin.getHorainicio());
                nuevoRegistro.setHorafin(mHorarioAdmin.getHorafin());
                nuevoRegistro.setInicioperiodo(mHorarioAdmin.getInicioperiodo());
                nuevoRegistro.setFinperiodo(mHorarioAdmin.getFinperiodo());
                nuevoRegistro.setRecurrenciadiaadmin(mHorarioAdmin.getRecurrenciadiaadmin());
                nuevoRegistro.setActivo(mHorarioAdmin.getActivo());
                return iHorarioAdmin.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar porque el Horario Admin no esta registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar un horario admin
    public boolean eliminarHorarioAdmin(Integer idhorario) throws Exception {
        try {
            Optional<MHorarioAdmin> registroEncontrado = iHorarioAdmin.findById(idhorario);
            if (registroEncontrado.isPresent()) {
                iHorarioAdmin.deleteById(idhorario);
                return true;
            } else
                throw new Exception("No se puede eliminar porque el Horario Admin no esta registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // anular horario admin
    public MHorarioAdmin anularHorarioAdmin(Integer idhorario, MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            Optional<MHorarioAdmin> registroEncontrado = iHorarioAdmin.findById(idhorario);
            if (registroEncontrado.isPresent()) {
                MHorarioAdmin nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setActivo(mHorarioAdmin.getActivo());
                return iHorarioAdmin.save(nuevoRegistro);
            } else
                throw new Exception("No se puede anular porque el Horario Admin no esta registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
