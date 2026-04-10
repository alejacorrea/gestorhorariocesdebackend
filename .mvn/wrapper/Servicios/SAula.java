package com.cesde.gestorhorario.Servicios;

import org.springframework.stereotype.Service;

import com.cesde.gestorhorario.Modelo.MAula;

@Service
public class SAula {
    @Autowired
    IAula iAula;

    public SAula(IAula iAula) {
        this.iAula = iAula;
    }

        // Adicion de aulas
    public MAula adicionarAula(MAula mAula) throws Exception {
        try {
            return iAula.save(mAula);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta general de registros de aulas
    public List<MAula> consultaGeneralAula() throws Exception {
        try {
            return iAula.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta individual por llave primaria
    public MAula consultaIndividualId(Integer idaula) throws Exception {
        try {
            Optional<MAula> registroEncontrado = iAula.findById(idaula);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Aula no registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // consulta por numero de aula
    public List<MAula> consultaPorNumeroDeAula(String numerodeaula) throws Exception {
        try {
            return iAula.findByNumeroDeAula(numerodeaula);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // modificar un registro de aula
    public MAula modificarAula(Integer idaula, MAula mAula) throws Exception {
        try {
            Optional<MAula> registroEncontrado = iAula.findById(idaula);
            if (registroEncontrado.isPresent()) {
                MAula nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setId_Aula(mAula.getId_Aula());
                nuevoRegistro.setNumeroDeAula(mAula.getNumeroDeAula());
                nuevoRegistro.setCapacidad(mAula.getCapacidad());
                nuevoRegistro.setActivo(mAula.getActivo());
                return iAula.save(nuevoRegistro);
            } else
                throw new Exception("No se puede modificar por que  el Aula no esta registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar una aula
    public boolean eliminarAula(Integer idaula) throws Exception {
        try {
            Optional<MAula> registroEncontrado = iAula.findById(idaula);
            if (registroEncontrado.isPresent()) {
                iAula.deleteById(idaula);
                return true;
            } else
                throw new Exception("No se puede eliminar por que  el Aula no esta registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    // anular aula
    public MAula anularAula(Integer idaula, MAula mAula) throws Exception {
        try{
            Optional<MAula> registroEncontrado=iAula.findById(idaula);
            if(registroEncontrado.isPresent()) {
                MAula nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setActivo(mAula.getActivo());
                return iAula.save(nuevoRegistro);
            }else
                throw new Exception("No se puede anular por que el aula no esta registrada");
            
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}