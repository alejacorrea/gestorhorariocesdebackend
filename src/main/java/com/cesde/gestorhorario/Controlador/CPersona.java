package com.cesde.gestorhorario.Controlador;

import com.cesde.gestorhorario.Modelo.MPersona;
import com.cesde.gestorhorario.Services.SPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class CPersona {

    @Autowired
    SPersona sPersona;

    // Adición de registros de persona
    @PostMapping
    public ResponseEntity<?> adicionarPersona(@RequestBody MPersona mPersona) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sPersona.adicionarPersona(mPersona));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general de personas
    @GetMapping
    public ResponseEntity<?> consultaGeneralPersona() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPersona.consultaGeneralPersona());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por llave primaria (identificacionpersona)
    @GetMapping("/{identificacionpersona}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable String identificacionpersona) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPersona.consultaIndividualId(identificacionpersona));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta por nombre de persona
    @GetMapping("/nombre/{nombrepersona}")
    public ResponseEntity<?> consultaPorNombreDePersona(@PathVariable String nombrepersona) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPersona.consultaPorNombreDePersona(nombrepersona));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar un registro de persona
    @PutMapping("/{identificacionpersona}")
    public ResponseEntity<?> modificarPersona(@PathVariable String identificacionpersona, @RequestBody MPersona mPersona) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPersona.modificarPersona(identificacionpersona, mPersona));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar un registro de persona
    @DeleteMapping("/{identificacionpersona}")
    public ResponseEntity<?> eliminarPersona(@PathVariable String identificacionpersona) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPersona.eliminarPersona(identificacionpersona));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Anular registro de persona (Inactivación lógica)
    @PutMapping("/anular/{identificacionpersona}")
    public ResponseEntity<?> anularPersona(@PathVariable String identificacionpersona, @RequestBody MPersona mPersona) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPersona.anularPersona(identificacionpersona, mPersona));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
