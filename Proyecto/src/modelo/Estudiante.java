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
public class Estudiante extends Usuario{

    
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Tarea> tareas;
    private ArrayList<Examen> examenes;
    private Reporte reporte;

  
    
    public Estudiante(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        super(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        this.asignaturas = new ArrayList();
        this.tareas = new ArrayList();
        this.examenes = new ArrayList();
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    @Override
    public String getTipoUsuario() {
        return "ESTUDIANTE";
    }

}
