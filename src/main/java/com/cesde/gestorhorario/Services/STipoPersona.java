package com.cesde.gestorhorario.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cesde.gestorhorario.Modelo.MTipoPersona;
import com.cesde.gestorhorario.Repository.ITipoPersona;

@Service
public class STipoPersona {
    @Autowired
    ITipoPersona iTipoPersona;

    public STipoPersona(ITipoPersona iTipoPersona) {
        this.iTipoPersona = iTipoPersona;
    }

    // Adicion de tipo persona
    public MTipoPersona adicionarTipoPersona(MTipoPersona mTipoPersona) throws Exception {
        try {
            return iTipoPersona.save(mTipoPersona);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de registros de tipo persona
    public List<MTipoPersona> consultaGeneralTipoPersona() throws Exception {
        try {
            return iTipoPersona.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual por llave primaria
    public MTipoPersona consultaIndividualId(Integer idRol) throws Exception {
        try {
            Optional<MTipoPersona> registroEncontrado = iTipoPersona.findById(idRol);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Tipo Persona no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    // consulta por Rol
    public List<MTipoPersona> consultaPorRol(String rolPersona) throws Exception {
        try {
            return iTipoPersona.findByRolPersona(rolPersona);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // modificar un registro de tipo persona
    public MTipoPersona modificarTipoPersona(Integer idRol, MTipoPersona mTipoPersona) throws Exception {
        try {
            Optional<MTipoPersona> registroEncontrado = iTipoPersona.findById(idRol);
            if (registroEncontrado.isPresent()) {
                MTipoPersona nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdRol(mTipoPersona.getIdRol());
                nuevoRegistro.setRolPersona(mTipoPersona.getRolPersona());
                return iTipoPersona.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar porque el Tipo Persona no esta registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar un tipo persona
    public boolean eliminarTipoPersona(Integer idRol) throws Exception {
        try {
            Optional<MTipoPersona> registroEncontrado = iTipoPersona.findById(idRol);
            if (registroEncontrado.isPresent()) {
                iTipoPersona.deleteById(idRol);
                return true;
            } else
                throw new Exception("No se puede eliminar porque el Tipo Persona no esta registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
