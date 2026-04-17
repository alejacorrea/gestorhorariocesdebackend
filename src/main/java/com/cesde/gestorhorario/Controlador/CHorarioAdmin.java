package com.cesde.gestorhorario.Controlador;

import com.cesde.gestorhorario.Modelo.MHorarioAdmin;
import com.cesde.gestorhorario.Services.SHorarioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horarioadmin")
public class CHorarioAdmin {

    @Autowired
    SHorarioAdmin sHorarioAdmin;

    // Adición de registros de horario admin
    @PostMapping
    public ResponseEntity<?> adicionarHorarioAdmin(@RequestBody MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sHorarioAdmin.adicionarHorarioAdmin(mHorarioAdmin));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general de horarios admin
    @GetMapping
    public ResponseEntity<?> consultaGeneralHorarioAdmin() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioAdmin.consultaGeneralHorarioAdmin());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por llave primaria (idhorario)
    @GetMapping("/{idhorario}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idhorario) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioAdmin.consultaIndividualId(idhorario));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta por nombre de profesor
    @GetMapping("/nombre/{nombreProfesor}")
    public ResponseEntity<?> consultaPorNombreProfesoHorarioAdmins(@PathVariable String nombreProfesor) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioAdmin.consultaPorNombreProfesoHorarioAdmins(nombreProfesor));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar un registro de horario admin
    @PutMapping("/{idhorario}")
    public ResponseEntity<?> modificarHorarioAdmin(@PathVariable Integer idhorario, @RequestBody MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioAdmin.modificarHorarioAdmin(idhorario, mHorarioAdmin));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar un registro de horario admin
    @DeleteMapping("/{idhorario}")
    public ResponseEntity<?> eliminarHorarioAdmin(@PathVariable Integer idhorario) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioAdmin.eliminarHorarioAdmin(idhorario));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Anular registro de horario admin (Inactivación lógica)
    @PutMapping("/anular/{idhorario}")
    public ResponseEntity<?> anularHorarioAdmin(@PathVariable Integer idhorario, @RequestBody MHorarioAdmin mHorarioAdmin) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sHorarioAdmin.anularHorarioAdmin(idhorario, mHorarioAdmin));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
