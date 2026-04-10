package com.cesde.gestorhorario.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cesde.gestorhorario.Modelo.MTipoPersona;
import com.cesde.gestorhorario.Repositorio.ITipoPersona;

@Service    
public class STipoPersona {

    @Autowired    
    ITipoPersona iTipoPersona;

    public STipoPersona(ITipoPersona iTipoPersona) {
        this.iTipoPersona = iTipoPersona;
    }

    // Adición de registros de tipo persona
    public MTipoPersona adicionarTipoPersona(MTipoPersona mTipoPersona) throws Exception {
        try {
            return iTipoPersona.save(mTipoPersona);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general de tipo persona
    public List<MTipoPersona> consultaGeneralTipoPersona() throws Exception {
        try {
            return iTipoPersona.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por ID
    public MTipoPersona consultaIndividualId(Integer idRol) throws Exception {
        try {
            Optional<MTipoPersona> registroEncontrado = iTipoPersona.findById(idRol);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Tipo de persona no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar tipo persona
    public MTipoPersona modificarTipoPersona(Integer idRol, MTipoPersona mTipoPersona) throws Exception {
        try {
            Optional<MTipoPersona> registroEncontrado = iTipoPersona.findById(idRol);
            if (registroEncontrado.isPresent()) {
                MTipoPersona nuevoRegistro = registroEncontrado.get();

                // Ajusta según tu modelo
                nuevoRegistro.setIdRol(mTipoPersona.getIdRol());
                nuevoRegistro.setDescripcion(mTipoPersona.getDescripcion());
                nuevoRegistro.setActivo(mTipoPersona.getActivo());

                return iTipoPersona.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar porque el tipo persona no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar tipo persona
    public boolean eliminarTipoPersona(Integer idRol) throws Exception {
        try {
            Optional<MTipoPersona> registroEncontrado = iTipoPersona.findById(idRol);
            if (registroEncontrado.isPresent()) {
                iTipoPersona.deleteById(idRol);
                return true;
            } else
                throw new Exception("No se puede eliminar porque el tipo persona no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Anular tipo persona (cambiar estado)
    public MTipoPersona anularTipoPersona(Integer idRol, MTipoPersona mTipoPersona) throws Exception {
        try {
            Optional<MTipoPersona> registroEncontrado = iTipoPersona.findById(idRol);
            if (registroEncontrado.isPresent()) {
                MTipoPersona nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setActivo(mTipoPersona.getActivo());
                return iTipoPersona.save(nuevoRegistro);
            } else
                throw new Exception("No se puede anular porque el tipo persona no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
