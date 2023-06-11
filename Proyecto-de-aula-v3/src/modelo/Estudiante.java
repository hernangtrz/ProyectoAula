/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.ArchivoActividades;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Estudiante extends Usuario implements Serializable {

    private Universidad universidad;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Tarea> tareas;
    private ArrayList<Examen> examenes;
    private ArrayList<Calificacion> calificaciones;
    private Reporte reporte;
    private ArrayList<Actividad> actividades;

    public Estudiante(String nombre, String apellido, String nombreUsuario, String contrasena, String correo, String departamento, String tipoUsuario) {
        super(nombre, apellido, nombreUsuario, contrasena, correo, departamento, tipoUsuario);
        this.asignaturas = new ArrayList();
        this.tareas = new ArrayList();
        this.examenes = new ArrayList();
        this.calificaciones = new ArrayList();
        this.actividades = new ArrayList();
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public void añadirTareas(Actividad tarea) {
        tareas.add((Tarea) tarea);
    }

    public void añadirExamenes(Actividad examen) {
        examenes.add((Examen) examen);
    }

    public void añadirActividad(Actividad a){
        actividades.add(a);
    }

    public void añadirCalificaciones(Calificacion c) {
        calificaciones.add(c);
    }
    
    public void añadirAsignaturas(Asignatura a) {
        asignaturas.add(a);
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

public ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    
    
    @Override
    public String toString() {
        return "Estudiante: " + "nombre: " + super.getNombre() + ", usuario: " + super.getNombreUsuario()
                + "Apellido: " + super.getApellido()
                + ", correo: " + super.getCorreo();
    }

}
