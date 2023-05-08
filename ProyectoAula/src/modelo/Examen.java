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
public class Examen {

    private LocalDate fechaExamen;
    private String descripcion;
    private Asignatura asignatura;
    private ArrayList<Estudiante> estudiantes;

    public Examen(LocalDate fechaExamen, String descripcion, Asignatura asignatura) {
        this.fechaExamen = fechaExamen;
        this.descripcion = descripcion;
        this.asignatura = asignatura;
        this.estudiantes = new ArrayList();
    }

    public LocalDate getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(LocalDate fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String tipoExamen) {
        this.descripcion = tipoExamen;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Examen{" + "fechaExamen=" + fechaExamen + ", tipoExamen=" + descripcion + ", asignatura=" + asignatura + '}';
    }

}
