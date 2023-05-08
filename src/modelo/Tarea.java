/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Tarea {

    private LocalDate fechaEntrega;
    private String descripcion;
    private Asignatura asignatura;
    private ArrayList<Estudiante> estudiantes;

    public Tarea(LocalDate fechaEntrega, String descripcion, Asignatura asignatura) {
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
        this.asignatura = asignatura;
        this.estudiantes = new ArrayList();
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Tarea{" + "fechaEntrega=" + fechaEntrega + ", descripcion=" + descripcion + ", asignatura=" + asignatura + '}';
    }

}
