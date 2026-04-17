package com.cesde.gestorhorario.Controlador;

import com.cesde.gestorhorario.Modelo.MTipoPersona;
import com.cesde.gestorhorario.Services.STipoPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipopersona")
public class CTipoPersona {

    @Autowired
    STipoPersona sTipoPersona;

    // Adición de registros de tipo persona
    @PostMapping
    public ResponseEntity<?> adicionarTipoPersona(@RequestBody MTipoPersona mTipoPersona) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sTipoPersona.adicionarTipoPersona(mTipoPersona));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general de tipos de persona
    @GetMapping
    public ResponseEntity<?> consultaGeneralTipoPersona() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sTipoPersona.consultaGeneralTipoPersona());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por llave primaria (idrol)
    @GetMapping("/{idrol}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idrol) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sTipoPersona.consultaIndividualId(idrol));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta por rol de persona
    @GetMapping("/rol/{rolpersona}")
    public ResponseEntity<?> consultaPorRol(@PathVariable String rolpersona) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sTipoPersona.consultaPorRol(rolpersona));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar un registro de tipo persona
    @PutMapping("/{idrol}")
    public ResponseEntity<?> modificarTipoPersona(@PathVariable Integer idrol, @RequestBody MTipoPersona mTipoPersona) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sTipoPersona.modificarTipoPersona(idrol, mTipoPersona));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar un registro de tipo persona
    @DeleteMapping("/{idrol}")
    public ResponseEntity<?> eliminarTipoPersona(@PathVariable Integer idrol) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sTipoPersona.eliminarTipoPersona(idrol));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
