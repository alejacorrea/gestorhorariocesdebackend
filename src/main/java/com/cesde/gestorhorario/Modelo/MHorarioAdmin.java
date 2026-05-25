package com.cesde.gestorhorario.Modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "horarioadmin")
public class MHorarioAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idhorario;

    @Column(nullable = false)
    String nombreProfesor;

    @Column(nullable = false)
    LocalDate fechainicio;

    @Column(nullable = false)
    LocalDate fechafin;

    @Column(nullable = false)
    LocalTime horainicio;

    @Column(nullable = false)
    LocalTime horafin;

    @Column(nullable = false)
    LocalDate inicioperiodo;

    @Column(nullable = false)
    LocalDate finperiodo;

    @Column(length = 15)
    String recurrenciadiaadmin;
    
    @Column(length = 5)
    Boolean activo;

    // relaciones
    @ManyToOne
    @JoinColumn(name = "identificacion_persona", referencedColumnName = "identificacion_persona")
    MPersona persona;

    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id_sede")
    MSede sede;

    @ManyToOne
    @JoinColumn(name = "id_aula", referencedColumnName = "id_aula")
    MAula aula;

    @ManyToOne
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    MMateria materia;

    //constructores

    public MHorarioAdmin(Integer idhorario, String nombreProfesor, LocalDate fechainicio, LocalDate fechafin, LocalTime horainicio, LocalTime horafin, LocalDate inicioperiodo, LocalDate finperiodo, String recurrenciadiaadmin, Boolean activo) {
        this.idhorario = idhorario;
        this.nombreProfesor = nombreProfesor;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.inicioperiodo = inicioperiodo;
        this.finperiodo = finperiodo;
        this.recurrenciadiaadmin = recurrenciadiaadmin;
        this.activo = activo;
    }

    public MHorarioAdmin() {
    }


    //Encapsulamiento

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }
    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public LocalDate getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public LocalDate getFechafin() {
        return fechafin;
    }

    public void setFechafin(LocalDate fechafin) {
        this.fechafin = fechafin;
    }

    public LocalTime getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(LocalTime horainicio) {
        this.horainicio = horainicio;
    }

    public LocalTime getHorafin() {
        return horafin;
    }

    public void setHorafin(LocalTime horafin) {
        this.horafin = horafin;
    }

    public LocalDate getInicioperiodo() {
        return inicioperiodo;
    }

    public void setInicioperiodo(LocalDate inicioperiodo) {
        this.inicioperiodo = inicioperiodo;
    }

    public LocalDate getFinperiodo() {
        return finperiodo;
    }

    public void setFinperiodo(LocalDate finperiodo) {
        this.finperiodo = finperiodo;
    }

    public String getRecurrenciadiaadmin() {
        return recurrenciadiaadmin;
    }

    public void setRecurrenciadiaadmin(String recurrenciadiaadmin) {
        this.recurrenciadiaadmin = recurrenciadiaadmin;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public MPersona getPersona() {
        return persona;
    }

    public void setPersona(MPersona persona) {
        this.persona = persona;
    }

    public MSede getSede() {
        return sede;
    }

    public void setSede(MSede sede) {
        this.sede = sede;
    }

    public MAula getAula() {
        return aula;
    }

    public void setAula(MAula aula) {
        this.aula = aula;
    }

    public MMateria getMateria() {
        return materia;
    }

    public void setMateria(MMateria materia) {
        this.materia = materia;
    }
}
