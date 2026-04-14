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

        // Adicion de registros de clientes
    public MHorarioProfesor adicionarHorario(MHorarioProfesor mHorarioProfesor) throws Exception {
        try {
            return iHorarioProfesor.save(mHorarioProfesor);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de registros de clientes
    public List<MHorarioProfesor> consultaGeneralCliente() throws Exception {
        try {
            return iHorarioProfesor.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual por llave primaria
    public MHorarioProfesor consultaIndividualId(Integer id_HorarioProfesor) throws Exception {
        try {
            Optional<MHorarioProfesor> registroEncontrado = iHorarioProfesor.findById(id_HorarioProfesor);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Horario de profesor no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta por materia
    public List<MHorarioProfesor> consultaPorMateriHorarioProfesors(String materia) throws Exception {
        try {
            return iHorarioProfesor.findByMateria(materia);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // modificar un horario de un profesor
    public MHorarioProfesor modificarHorario(Integer id_HorarioProfesor
, MHorarioProfesor mHorarioProfesor) throws Exception {
        try {
            Optional<MHorarioProfesor> registroEncontrado = iHorarioProfesor.findById(id_HorarioProfesor);
            if (registroEncontrado.isPresent()) {
                MHorarioProfesor nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setId_HorarioProfesor(mHorarioProfesor.getId_HorarioProfesor());
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

    // eliminar un registro de cliente
    public boolean eliminarHorario(Integer id_HorarioProfesor) throws Exception {
        try {
            Optional<MHorarioProfesor> registroEncontrado = iHorarioProfesor.findById(id_HorarioProfesor);
            if (registroEncontrado.isPresent()) {
                iHorarioProfesor.deleteById(id_HorarioProfesor);
                return true;
            } else
                throw new Exception("No se puede eliminar por que  el Horario de profesor no esta registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    // anular registro de cliente
    public MHorarioProfesor anularHorario(Integer id_HorarioProfesor, MHorarioProfesor mHorarioProfesor) throws Exception {
        try{
            Optional<MHorarioProfesor> registroEncontrado=iHorarioProfesor.findById(id_HorarioProfesor);
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
