package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class MHorarioProfesor {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idHorarioProfesor;

    @Column(length = 15, nullable = false)
    String materiaProfesor;

    @Column(nullable = false)
    LocalDate fechaInicioProfesor;

    @Column(nullable = false)
    LocalTime horaInicioProfesor;

    @Column(nullable = false)
    LocalTime horaFinProfesor;

    @Column(length = 15, nullable = false)
    String instituto;

    @Column(length = 15, nullable = false)
    String recurrenciaDiaProfesor;

    @Column(nullable = false)
    LocalDate fechaFinalizacionProfesor;

    @Column(length = 15, nullable = false)
    String identificacionPersona;

    @Column(nullable = false)
    Boolean activo;

    public MHorarioProfesor() {
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setFechaFinalizacionProfesor(LocalDate fechaFinalizacionProfesor) {
        this.fechaFinalizacionProfesor = fechaFinalizacionProfesor;
    }

    public void setFechaInicioProfesor(LocalDate fechaInicioProfesor) {
        this.fechaInicioProfesor = fechaInicioProfesor;
    }

    public void setHoraFinProfesor(LocalTime horaFinProfesor) {
        this.horaFinProfesor = horaFinProfesor;
    }

    public void setHoraInicioProfesor(LocalTime horaInicioProfesor) {
        this.horaInicioProfesor = horaInicioProfesor;
    }

    public void setIdHorarioProfesor(Integer idHorarioProfesor) {
        this.idHorarioProfesor = idHorarioProfesor;
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

    public LocalDate getFechaFinalizacionProfesor() {
        return fechaFinalizacionProfesor;
    }

    public LocalDate getFechaInicioProfesor() {
        return fechaInicioProfesor;
    }

    public LocalTime getHoraFinProfesor() {
        return horaFinProfesor;
    }

    public LocalTime getHoraInicioProfesor() {
        return horaInicioProfesor;
    }

    public Integer getIdHorarioProfesor() {
        return idHorarioProfesor;
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
