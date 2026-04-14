package com.cesde.gestorhorario.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.gestorhorario.Modelo.MMateria;
import com.cesde.gestorhorario.Repository.IMateria;

@Service
public class SMateria {
    @Autowired
    IMateria iMateria;

    public SMateria(IMateria iMateria) {
        this.iMateria = iMateria;
    }

        // Adicion de materia
    public MMateria adicionarMateria(MMateria mMateria) throws Exception {
        try {
            return iMateria.save(mMateria);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de registros de materia
    public List<MMateria> consultaGeneralMateria() throws Exception {
        try {
            return iMateria.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual por llave primaria
    public MMateria consultaIndividualId(Integer idmateria) throws Exception {
        try {
            Optional<MMateria> registroEncontrado = iMateria.findById(idmateria);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Materia no registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta por nombre de materia
    public List<MMateria> consultaPorNombreDeMateria(String nombremateria) throws Exception {
        try {
            return iMateria.findByNombreMateria(nombremateria);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // modificar un registro de materia
    public MMateria modificarMateria(Integer idmateria, MMateria mMateria) throws Exception {
        try {
            Optional<MMateria> registroEncontrado = iMateria.findById(idmateria);
            if (registroEncontrado.isPresent()) {
                MMateria nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdmateria(mMateria.getIdmateria());
                nuevoRegistro.setNombremateria(mMateria.getNombremateria());
                nuevoRegistro.setActivo(mMateria.getActivo());
                return iMateria.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar por que  el Materia no esta registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar una materia
    public boolean eliminarMateria(Integer idmateria) throws Exception {
        try {
            Optional<MMateria> registroEncontrado = iMateria.findById(idmateria);
            if (registroEncontrado.isPresent()) {
                iMateria.deleteById(idmateria);
                return true;
            } else
                throw new Exception("No se puede eliminar por que  el Materia no esta registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    // anular materia
    public MMateria anularMateria(Integer idmateria, MMateria mMateria) throws Exception {
        try{
            Optional<MMateria> registroEncontrado=iMateria.findById(idmateria);
            if(registroEncontrado.isPresent()) {
                MMateria nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setActivo(mMateria.getActivo());
                return iMateria.save(nuevoRegistro);
            }else
                throw new Exception("No se puede anular por que el materia no esta registrada");
            
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
