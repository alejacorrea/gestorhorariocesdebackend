package com.cesde.gestorhorario.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.gestorhorario.Modelo.MHorarioProfesor;
import com.cesde.gestorhorario.Repository.IHorarioProfesor;

@Service
public class SHorarioProfesor {
    @Autowired
    IHorarioProfesor iHorarioProfesor;

    public SHorarioProfesor(IHorarioProfesor iHorarioProfesor) {
        this.iHorarioProfesor = iHorarioProfesor;
    }

        // Adicion de registros de horario profesor
    public MHorarioProfesor adicionarHorario(MHorarioProfesor mHorarioProfesor) throws Exception {
        try {
            return iHorarioProfesor.save(mHorarioProfesor);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de registros de horario profesor
    public List<MHorarioProfesor> consultaGeneralHorarioProfesor() throws Exception {
        try {
            return iHorarioProfesor.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual por llave primaria
    public MHorarioProfesor consultaIndividualId(Integer idHorarioProfesor) throws Exception {
        try {
            Optional<MHorarioProfesor> registroEncontrado = iHorarioProfesor.findById(idHorarioProfesor);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Horario de profesor no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta por materia
    public List<MHorarioProfesor> consultaPorMateriaHorarioProfesor(String materiaProfesor) throws Exception {
        try {
            return iHorarioProfesor.findByMateriaProfesor(materiaProfesor);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // modificar un horario de un profesor
    public MHorarioProfesor modificarHorario(Integer idHorarioProfesor, MHorarioProfesor mHorarioProfesor) throws Exception {
        try {
            Optional<MHorarioProfesor> registroEncontrado = iHorarioProfesor.findById(idHorarioProfesor);
            if (registroEncontrado.isPresent()) {
                MHorarioProfesor nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdHorarioProfesor(mHorarioProfesor.getIdHorarioProfesor());
                nuevoRegistro.setMateriaProfesor(mHorarioProfesor.getMateriaProfesor());
                nuevoRegistro.setFechaInicioProfesor(mHorarioProfesor.getFechaInicioProfesor());
                nuevoRegistro.setFechaFinalizacionProfesor(mHorarioProfesor.getFechaFinalizacionProfesor());
                nuevoRegistro.setInstituto(mHorarioProfesor.getInstituto());
                nuevoRegistro.setHoraInicioProfesor(mHorarioProfesor.getHoraInicioProfesor());
                nuevoRegistro.setHoraFinProfesor(mHorarioProfesor.getHoraFinProfesor());
                nuevoRegistro.setRecurrenciaDiaProfesor(mHorarioProfesor.getRecurrenciaDiaProfesor());
                nuevoRegistro.setIdentificacionPersona(mHorarioProfesor.getIdentificacionPersona());
                nuevoRegistro.setActivo(mHorarioProfesor.getActivo());
                return iHorarioProfesor.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar por que  el Horario de profesor no esta registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar un registro de horario profesor
    public boolean eliminarHorario(Integer idHorarioProfesor) throws Exception {
        try {
            Optional<MHorarioProfesor> registroEncontrado = iHorarioProfesor.findById(idHorarioProfesor);
            if (registroEncontrado.isPresent()) {
                iHorarioProfesor.deleteById(idHorarioProfesor);
                return true;
            } else
                throw new Exception("No se puede eliminar por que  el Horario de profesor no esta registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    // anular registro de horario profesor
    public MHorarioProfesor anularHorario(Integer idHorarioProfesor, MHorarioProfesor mHorarioProfesor) throws Exception {
        try{
            Optional<MHorarioProfesor> registroEncontrado=iHorarioProfesor.findById(idHorarioProfesor);
            if(registroEncontrado.isPresent()) {
                MHorarioProfesor nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setActivo(mHorarioProfesor.getActivo());
                return iHorarioProfesor.save(nuevoRegistro);
            }else
                throw new Exception("No se puede anular por que el horario de profesor no esta registrado");
            
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
