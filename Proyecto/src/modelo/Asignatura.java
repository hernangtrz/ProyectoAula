/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Asignatura {

    private String nombre;
    private String nomProfesor;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;
    private ArrayList<Estudiante> estudiantes;

    public Asignatura(String nombre, String nomProfesor, String descripcion) {
        this.nombre = nombre;
        this.nomProfesor = nomProfesor;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.of(2023, Month.MARCH, 20);
        this.descripcion = descripcion;
        this.estudiantes = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomProfesor() {
        return nomProfesor;
    }

    public void setNomProfesor(String nomProfesor) {
        this.nomProfesor = nomProfesor;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombre=" + nombre + ", nomProfesor=" + nomProfesor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", descripcion=" + descripcion + ", estudiantes=" + estudiantes + '}';
    }

}
