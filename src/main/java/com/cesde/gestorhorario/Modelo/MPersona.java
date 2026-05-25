package com.cesde.gestorhorario.Modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class MPersona {

    @Id
    @Column(name = "identificacion_persona", length = 15)
    String identificacionPersona;

    @Column(length = 40, nullable = false)
    String nombrePersona;

    @Column(length = 40, nullable = false, unique = true)
    String correoPersona;

    @Column(length = 20, nullable = false)
    String contrasenaPersona;

    @Column(length = 5)
    Boolean activo;

    //relaciones
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    MTipoPersona tipoPersona;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    List<MHorarioProfesor> horariosProfesor;

    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    List<MHorarioAdmin> horariosAdmin;

    



    public MPersona(String identificacionPersona, String nombrePersona, String correoPersona, String contrasenaPersona, Boolean activo) {
        this.identificacionPersona = identificacionPersona;
        this.nombrePersona = nombrePersona;
        this.correoPersona = correoPersona;
        this.contrasenaPersona = contrasenaPersona;
        this.activo = activo;
    }

    public MPersona() {
    }

    public String getIdentificacionPersona() {
        return identificacionPersona;
    }

    public void setIdentificacionPersona(String identificacionPersona) {
        this.identificacionPersona = identificacionPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public String getContrasenaPersona() {
        return contrasenaPersona;
    }

    public void setContrasenaPersona(String contrasenaPersona) {
        this.contrasenaPersona = contrasenaPersona;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public MTipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(MTipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public List<MHorarioProfesor> getHorariosProfesor() {
        return horariosProfesor;
    }

    public void setHorariosProfesor(List<MHorarioProfesor> horariosProfesor) {
        this.horariosProfesor = horariosProfesor;
    }

    public List<MHorarioAdmin> getHorariosAdmin() {
        return horariosAdmin;
    }

    public void setHorariosAdmin(List<MHorarioAdmin> horariosAdmin) {
        this.horariosAdmin = horariosAdmin;
    }
}
