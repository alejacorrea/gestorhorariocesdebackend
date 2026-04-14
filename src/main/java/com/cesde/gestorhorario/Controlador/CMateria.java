package com.cesde.gestorhorario.Controlador;

import com.cesde.gestorhorario.Modelo.MMateria;
import com.cesde.gestorhorario.Services.SMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materia")
public class CMateria {

    @Autowired
    SMateria sMateria;

    // Adición de registros de materia
    @PostMapping
    public ResponseEntity<?> adicionarMateria(@RequestBody MMateria mMateria) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sMateria.adicionarMateria(mMateria));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general de materias
    @GetMapping
    public ResponseEntity<?> consultaGeneralMateria() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMateria.consultaGeneralMateria());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por llave primaria (idmateria)
    @GetMapping("/{idmateria}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idmateria) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMateria.consultaIndividualId(idmateria));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta por nombre de materia
    @GetMapping("/nombre/{nombremateria}")
    public ResponseEntity<?> consultaPorNombreDeMateria(@PathVariable String nombremateria) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMateria.consultaPorNombreDeMateria(nombremateria));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar un registro de materia
    @PutMapping("/{idmateria}")
    public ResponseEntity<?> modificarMateria(@PathVariable Integer idmateria, @RequestBody MMateria mMateria) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMateria.modificarMateria(idmateria, mMateria));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar una materia
    @DeleteMapping("/{idmateria}")
    public ResponseEntity<?> eliminarMateria(@PathVariable Integer idmateria) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMateria.eliminarMateria(idmateria));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Anular materia (Inactivación)
    @PutMapping("/anular/{idmateria}")
    public ResponseEntity<?> anularMateria(@PathVariable Integer idmateria, @RequestBody MMateria mMateria) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sMateria.anularMateria(idmateria, mMateria));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}