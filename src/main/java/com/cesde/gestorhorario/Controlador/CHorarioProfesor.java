package com.cesde.gestorhorario.Controlador;

import com.cesde.gestorhorario.Modelo.MHorarioProfesor;
import com.cesde.gestorhorario.Services.SHorarioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horarioprofesor")
public class CHorarioProfesor {

    @Autowired
    SHorarioProfesor sHorarioProfesor;

    // Adición de registros de horario
    @PostMapping
    public ResponseEntity<?> adicionarHorario(@RequestBody MHorarioProfesor mHorarioProfesor) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sHorarioProfesor.adicionarHorario(mHorarioProfesor));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general de horarios
    @GetMapping
    public ResponseEntity<?> consultaGeneralHorario() throws Exception {
        try {
            // Nota: Se usa el nombre del método exacto que tienes en tu Service
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioProfesor.consultaGeneralCliente());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por llave primaria (Integer)
    @GetMapping("/{id_HorarioProfesor}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer id_HorarioProfesor) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioProfesor.consultaIndividualId(id_HorarioProfesor));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta por materia
    @GetMapping("/materia/{materia}")
    public ResponseEntity<?> consultaPorMateria(@PathVariable String materia) throws Exception {
        try {
            // Nota: Se usa el nombre del método exacto que tienes en tu Service
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioProfesor.consultaPorMateriHorarioProfesors(materia));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar un registro de horario
    @PutMapping("/{id_HorarioProfesor}")
    public ResponseEntity<?> modificarHorario(@PathVariable Integer id_HorarioProfesor, @RequestBody MHorarioProfesor mHorarioProfesor) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioProfesor.modificarHorario(id_HorarioProfesor, mHorarioProfesor));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar un registro de horario
    @DeleteMapping("/{id_HorarioProfesor}")
    public ResponseEntity<?> eliminarHorario(@PathVariable Integer id_HorarioProfesor) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioProfesor.eliminarHorario(id_HorarioProfesor));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Anular registro
    @PutMapping("/anular/{id_HorarioProfesor}")
    public ResponseEntity<?> anularHorario(@PathVariable Integer id_HorarioProfesor, @RequestBody MHorarioProfesor mHorarioProfesor) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioProfesor.anularHorario(id_HorarioProfesor, mHorarioProfesor));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}