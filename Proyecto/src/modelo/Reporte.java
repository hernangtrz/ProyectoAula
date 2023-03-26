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
public class Reporte {

    private double promCalificaciones;
    private ArrayList<Tarea> listaTareasPendientes;
    private ArrayList<Examen> listaExamenesProx;
    private Estudiante estudiante;
    
    public Reporte(double promCalificaciones, Estudiante estudiante) {
        this.promCalificaciones = promCalificaciones;
        this.listaTareasPendientes = new ArrayList();
        this.listaExamenesProx = new ArrayList();
        this.estudiante = estudiante;
    }

    public double getPromCalificaciones() {
        return promCalificaciones;
    }

    public void setPromCalificaciones(double promCalificaciones) {
        this.promCalificaciones = promCalificaciones;
    }

    public ArrayList<Tarea> getListaTareasPendientes() {
        return listaTareasPendientes;
    }

    public void setListaTareasPendientes(ArrayList<Tarea> listaTareasPendientes) {
        this.listaTareasPendientes = listaTareasPendientes;
    }

    public ArrayList<Examen> getListaExamenesProx() {
        return listaExamenesProx;
    }

    public void setListaExamenesProx(ArrayList<Examen> listaExamenesProx) {
        this.listaExamenesProx = listaExamenesProx;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Reporte{" + "promCalificaciones=" + promCalificaciones + ", listaTareasPendientes=" + listaTareasPendientes + ", listaExamenesProx=" + listaExamenesProx + ", estudiante=" + estudiante + '}';
    }

}
