/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Docente extends Usuario implements Serializable{

    private ArrayList<Actividad> actividades;
    private Universidad universidad;
    private ArrayList<Asignatura> asignaturas;

    public Docente() {
    }

    
    public Docente(String nombre, String apellido, String nombreUsuario, String contrasena, String correo, String departamento, String tipoUsuario) {
        super(nombre, apellido, nombreUsuario, contrasena, correo, departamento, tipoUsuario);
        this.asignaturas = new ArrayList();
        this.actividades = new ArrayList();
    }

    public void registrarAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);

    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public void seguimientoActividades() {
        for (Actividad a : actividades) {
            System.out.println(a);
        }
    }

    public void enviarCalificacion(Estudiante est, Calificacion calificacion) {
        est.añadirCalificaciones(calificacion);
    }

     public void asignarActividad(Asignatura asignatura, Actividad actividad) throws IOException {
        asignatura.agregarActividad(actividad);
    }
    
    public void eliminarActividad(Asignatura asignatura, Actividad actividad) throws IOException {
        asignatura.eliminarActividad(actividad);
    }
}
