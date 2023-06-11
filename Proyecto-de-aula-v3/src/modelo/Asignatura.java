/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import persistencia.ArchivoActividades;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Asignatura implements Serializable{

    private String codAsig;
    private String nombre;
    private String nomProfesor;
    private String Departamento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;
    private ArrayList<Estudiante> estudiantes;
    private List<Actividad> actividades;

    public Asignatura(String nombre, String nomProfesor, String Departamento, String descripcion) {
        this.nombre = nombre;
        this.nomProfesor = nomProfesor;
        this.Departamento = Departamento;
        this.descripcion = descripcion;
        this.estudiantes = new ArrayList();
        this.actividades = new ArrayList<>();    
    }

    
    public Asignatura(String codAsig,String nombre, String descripcion) {
        this.codAsig = codAsig;
        this.nombre = nombre;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.of(2023, Month.MARCH, 20);
        this.descripcion = descripcion;
        this.estudiantes = new ArrayList();
    }

    public Asignatura(String codAsig) {
        this.codAsig = codAsig;
    }

    public Asignatura(String codAsig, String nombre){
        this.codAsig = codAsig;
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    
    public String getCodAsig() {
        return codAsig;
    }

    public void setCodAsig(String codAsig) {
        this.codAsig = codAsig;
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

    public void agregarActividad(Actividad actividad) throws IOException {
        ArchivoActividades archivo = new ArchivoActividades();
        archivo.guardarActividad(actividad);
        actividades.add(actividad);
    }

    public void eliminarActividad(Actividad actividad) throws IOException {
        ArchivoActividades archivo = new ArchivoActividades();
        archivo.eliminarActividad(actividad.getNombre());
        actividades.remove(actividad);
    }
    
    public void añadirEstudiantes(Estudiante e){
        estudiantes.add(e);
    }    

    @Override
    public String toString() {
        return "Asignatura{" + "Codigo"+ codAsig + "nombre=" + nombre + ", nomProfesor=" + nomProfesor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", descripcion=" + descripcion + ", estudiantes=" + estudiantes + '}';
    }

}
