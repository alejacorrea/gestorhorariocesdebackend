package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class MHorarioProfesor {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_HorarioProfesor;

    @Column(length = 15, nullable = false)
    String materiaProfesor;

    @Column(nullable = false)
    String fechaInicioProfesor;

    @Column(nullable = false)
    String horaInicioProfesor;

    @Column(nullable = false)
    String horaFinProfesor;

    @Column(length = 15, nullable = false)
    String instituto;

    @Column(length = 15, nullable = false)
    String recurrenciaDiaProfesor;

    @Column(nullable = false)
    String fechaFinalizacionProfesor;

    @Column(length = 15, nullable = false)
    String identificacionPersona;

    @Column(nullable = false)
    Boolean activo;

    public MHorarioProfesor() {
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setFechaFinalizacionProfesor(String fechaFinalizacionProfesor) {
        this.fechaFinalizacionProfesor = fechaFinalizacionProfesor;
    }

    public void setFechaInicioProfesor(String fechaInicioProfesor) {
        this.fechaInicioProfesor = fechaInicioProfesor;
    }

    public void setHoraFinProfesor(String horaFinProfesor) {
        this.horaFinProfesor = horaFinProfesor;
    }

    public void setHoraInicioProfesor(String horaInicioProfesor) {
        this.horaInicioProfesor = horaInicioProfesor;
    }

    public void setId_HorarioProfesor(Integer id_HorarioProfesor) {
        this.id_HorarioProfesor = id_HorarioProfesor;
    }

    public void setIdentificacionPersona(String identificacionPersona) {
        this.identificacionPersona = identificacionPersona;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public void setMateriaProfesor(String materiaProfesor) {
        this.materiaProfesor = materiaProfesor;
    }

    public void setRecurrenciaDiaProfesor(String recurrenciaDiaProfesor) {
        this.recurrenciaDiaProfesor = recurrenciaDiaProfesor;
    }

    public Boolean getActivo() {
        return activo;
    }

    public String getFechaFinalizacionProfesor() {
        return fechaFinalizacionProfesor;
    }

    public String getFechaInicioProfesor() {
        return fechaInicioProfesor;
    }

    public String getHoraFinProfesor() {
        return horaFinProfesor;
    }

    public String getHoraInicioProfesor() {
        return horaInicioProfesor;
    }

    public Integer getId_HorarioProfesor() {
        return id_HorarioProfesor;
    }

    public String getIdentificacionPersona() {
        return identificacionPersona;
    }

    public String getInstituto() {
        return instituto;
    }

    public String getMateriaProfesor() {
        return materiaProfesor;
    }

    public String getRecurrenciaDiaProfesor() {
        return recurrenciaDiaProfesor;
    }
}
