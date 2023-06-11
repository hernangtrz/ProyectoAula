/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Actividad implements Serializable{
    private String nombre;
    private String fechaEntrega;
    private String descripcion;
    private Asignatura asignatura;
    private ArrayList<Estudiante> estudiantes;
    private String tipoActividad;
    public Actividad(String nombre, String fechaEntrega, String descripcion, Asignatura asignatura, String tipoActividad) {
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
        this.asignatura = asignatura;
        this.estudiantes = new ArrayList();
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
    }

    public Actividad(String nombre) {
        this.nombre = nombre;
    }
    
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
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

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }
    
    
}