/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Departamento {
    private String nombre;
    private ArrayList<Docente> docentes;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asignatura> asignaturas;

    public Departamento(String nombre, ArrayList<Docente> docentes, ArrayList<Estudiante> estudiantes, ArrayList<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.docentes = docentes;
        this.estudiantes = estudiantes;
        this.asignaturas = asignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    
    
    
}
