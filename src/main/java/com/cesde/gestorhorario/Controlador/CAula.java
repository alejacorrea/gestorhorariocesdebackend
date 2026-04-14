package com.cesde.gestorhorario.Controlador;

import com.cesde.gestorhorario.Modelo.MAula;
import com.cesde.gestorhorario.Services.SAula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula")
public class CAula {

    @Autowired
    SAula sAula;

    // Adición de registros de aula
    @PostMapping
    public ResponseEntity<?> adicionarAula(@RequestBody MAula mAula) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sAula.adicionarAula(mAula));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general de aulas
    @GetMapping
    public ResponseEntity<?> consultaGeneralAula() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAula.consultaGeneralAula());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por llave primaria (Integer)
    @GetMapping("/{idaula}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idaula) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAula.consultaIndividualId(idaula));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta por número de aula
    @GetMapping("/numero/{numerodeaula}")
    public ResponseEntity<?> consultaPorNumeroDeAula(@PathVariable String numerodeaula) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAula.consultaPorNumeroDeAula(numerodeaula));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar un registro de aula
    @PutMapping("/{idaula}")
    public ResponseEntity<?> modificarAula(@PathVariable Integer idaula, @RequestBody MAula mAula) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAula.modificarAula(idaula, mAula));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar un registro de aula
    @DeleteMapping("/{idaula}")
    public ResponseEntity<?> eliminarAula(@PathVariable Integer idaula) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAula.eliminarAula(idaula));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Anular registro de aula (Inactivación lógica)
    @PutMapping("/anular/{idaula}")
    public ResponseEntity<?> anularAula(@PathVariable Integer idaula, @RequestBody MAula mAula) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sAula.anularAula(idaula, mAula));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}