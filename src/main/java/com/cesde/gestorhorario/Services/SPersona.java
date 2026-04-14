package com.cesde.gestorhorario.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cesde.gestorhorario.Modelo.MPersona;
import com.cesde.gestorhorario.Repository.IPersona;

@Service
public class SPersona {
    @Autowired
    IPersona iPersona;

    public SPersona(IPersona iPersona) {
        this.iPersona = iPersona;
    }

    // Adicion de persona
    public MPersona adicionarPersona(MPersona mPersona) throws Exception {
        try {
            return iPersona.save(mPersona);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de registros de persona
    public List<MPersona> consultaGeneralPersona() throws Exception {
        try {
            return iPersona.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual por llave primaria
    public MPersona consultaIndividualId(String identificacionPersona) throws Exception {
        try {
            Optional<MPersona> registroEncontrado = iPersona.findById(identificacionPersona);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Persona no registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    // consulta por nombre
    public List<MPersona> consultaPorNombreDePersona(String nombrePersona) throws Exception {
        try {
            return iPersona.findByNombrePersona(nombrePersona);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // modificar un registro de persona
    public MPersona modificarPersona(String identificacionPersona, MPersona mPersona) throws Exception {
        try {
            Optional<MPersona> registroEncontrado = iPersona.findById(identificacionPersona);
            if (registroEncontrado.isPresent()) {
                MPersona nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdentificacionPersona(mPersona.getIdentificacionPersona());
                nuevoRegistro.setNombrePersona(mPersona.getNombrePersona());
                nuevoRegistro.setCorreoPersona(mPersona.getCorreoPersona());
                nuevoRegistro.setContrasenaPersona(mPersona.getContrasenaPersona());
                nuevoRegistro.setActivo(mPersona.getActivo());
                return iPersona.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar porque la Persona no esta registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar una persona
    public boolean eliminarPersona(String identificacionPersona) throws Exception {
        try {
            Optional<MPersona> registroEncontrado = iPersona.findById(identificacionPersona);
            if (registroEncontrado.isPresent()) {
                iPersona.deleteById(identificacionPersona);
                return true;
            } else
                throw new Exception("No se puede eliminar porque la Persona no esta registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // anular persona
    public MPersona anularPersona(String identificacionPersona, MPersona mPersona) throws Exception {
        try {
            Optional<MPersona> registroEncontrado = iPersona.findById(identificacionPersona);
            if (registroEncontrado.isPresent()) {
                MPersona nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setActivo(mPersona.getActivo());
                return iPersona.save(nuevoRegistro);
            } else
                throw new Exception("No se puede anular porque la Persona no esta registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
