package com.cesde.gestorhorario.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cesde.gestorhorario.Modelo.MPersona;
import com.cesde.gestorhorario.Repositorio.IPersona;

@Service
public class SPersona {

    @Autowired
    IPersona iPersona;

    public SPersona(IPersona iPersona) {
        this.iPersona = iPersona;
    }

    // Adición de registros de persona
    public MPersona adicionarPersona(MPersona mPersona) throws Exception {
        try {
            return iPersona.save(mPersona);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general de personas
    public List<MPersona> consultaGeneralPersona() throws Exception {
        try {
            return iPersona.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por ID
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

    // Modificar persona
    public MPersona modificarPersona(String identificacionPersona, MPersona mPersona) throws Exception {
        try {
            Optional<MPersona> registroEncontrado = iPersona.findById(identificacionPersona);
            if (registroEncontrado.isPresent()) {
                MPersona nuevoRegistro = registroEncontrado.get();

                // Ajusta estos campos según tu modelo
                nuevoRegistro.setIdentificacionPersona(mPersona.getIdentificacionPersona());
                nuevoRegistro.setNombre(mPersona.getNombre());
                nuevoRegistro.setDireccion(mPersona.getDireccion());
                nuevoRegistro.setTelefono(mPersona.getTelefono());
                nuevoRegistro.setActivo(mPersona.getActivo());

                return iPersona.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar porque la persona no está registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar persona
    public boolean eliminarPersona(String identificacionPersona) throws Exception {
        try {
            Optional<MPersona> registroEncontrado = iPersona.findById(identificacionPersona);
            if (registroEncontrado.isPresent()) {
                iPersona.deleteById(identificacionPersona);
                return true;
            } else
                throw new Exception("No se puede eliminar porque la persona no está registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Anular persona (cambiar estado)
    public MPersona anularPersona(String identificacionPersona, MPersona mPersona) throws Exception {
        try {
            Optional<MPersona> registroEncontrado = iPersona.findById(identificacionPersona);
            if (registroEncontrado.isPresent()) {
                MPersona nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setActivo(mPersona.getActivo());
                return iPersona.save(nuevoRegistro);
            } else
                throw new Exception("No se puede anular porque la persona no está registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}