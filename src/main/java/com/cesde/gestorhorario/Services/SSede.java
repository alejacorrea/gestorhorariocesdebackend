package com.cesde.gestorhorario.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.gestorhorario.Modelo.MSede;
import com.cesde.gestorhorario.Repository.ISede;

@Service
public class SSede {
    @Autowired
    ISede iSede;

    public SSede(ISede iSede) {
        this.iSede = iSede;
    }

        // Adicion de sede
    public MSede adicionarSede(MSede mSede) throws Exception {
        try {
            return iSede.save(mSede);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de registros de sede
    public List<MSede> consultaGeneralSede() throws Exception {
        try {
            return iSede.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual por llave primaria
    public MSede consultaIndividualId(Integer idsede) throws Exception {
        try {
            Optional<MSede> registroEncontrado = iSede.findById(idsede);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Sede no registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta por nombre de sede
    public List<MSede> consultaPorNombreDeSede(String nombresede) throws Exception {
        try {
            return iSede.findByNombresede(nombresede);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // modificar un registro de sede
    public MSede modificarSede(Integer idsede, MSede mSede) throws Exception {
        try {
            Optional<MSede> registroEncontrado = iSede.findById(idsede);
            if (registroEncontrado.isPresent()) {
                MSede nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdsede(mSede.getIdsede());
                nuevoRegistro.setNombresede(mSede.getNombresede());
                nuevoRegistro.setActivo(mSede.getActivo());
                return iSede.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar por que  el Sede no esta registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar una sede
    public boolean eliminarSede(Integer idsede) throws Exception {
        try {
            Optional<MSede> registroEncontrado = iSede.findById(idsede);
            if (registroEncontrado.isPresent()) {
                iSede.deleteById(idsede);
                return true;
            } else
                throw new Exception("No se puede eliminar por que  el Sede no esta registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    // anular sede
    public MSede anularSede(Integer idsede, MSede mSede) throws Exception {
        try{
            Optional<MSede> registroEncontrado=iSede.findById(idsede);
            if(registroEncontrado.isPresent()) {
                MSede nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setActivo(mSede.getActivo());
                return iSede.save(nuevoRegistro);
            }else
                throw new Exception("No se puede anular por que el sede no esta registrada");
            
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}