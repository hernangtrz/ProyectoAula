/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class ActividadesEntregadas implements Serializable{
    private Estudiante estudiante;
    private Asignatura asignatura;
    private Actividad actividad;
    private String fechaEntrega;

    public ActividadesEntregadas(Estudiante estudiante, Asignatura asignatura, Actividad actividad, String fechaEntrega) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.actividad = actividad;
        this.fechaEntrega = fechaEntrega;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    private LocalDateTime LocalDateTime() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
