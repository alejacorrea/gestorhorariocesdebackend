package com.cesde.gestorhorario.Controlador;

import com.cesde.gestorhorario.Modelo.MSede;
import com.cesde.gestorhorario.Services.SSede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sede")
public class CSede {

    @Autowired
    SSede sSede;

    // Adición de registros de sede
    @PostMapping
    public ResponseEntity<?> adicionarSede(@RequestBody MSede mSede) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sSede.adicionarSede(mSede));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general de sedes
    @GetMapping
    public ResponseEntity<?> consultaGeneralSede() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sSede.consultaGeneralSede());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por ID (idsede)
    @GetMapping("/{idsede}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idsede) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sSede.consultaIndividualId(idsede));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta por nombre de sede
    @GetMapping("/nombre/{nombresede}")
    public ResponseEntity<?> consultaPorNombreDeSede(@PathVariable String nombresede) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sSede.consultaPorNombreDeSede(nombresede));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar un registro de sede
    @PutMapping("/{idsede}")
    public ResponseEntity<?> modificarSede(@PathVariable Integer idsede, @RequestBody MSede mSede) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sSede.modificarSede(idsede, mSede));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar una sede
    @DeleteMapping("/{idsede}")
    public ResponseEntity<?> eliminarSede(@PathVariable Integer idsede) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sSede.eliminarSede(idsede));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Anular sede (Cambio de estado activo/inactivo)
    @PutMapping("/anular/{idsede}")
    public ResponseEntity<?> anularSede(@PathVariable Integer idsede, @RequestBody MSede mSede) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sSede.anularSede(idsede, mSede));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}