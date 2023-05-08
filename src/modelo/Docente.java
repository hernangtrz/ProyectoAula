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
public class Docente extends Usuario {
    private ArrayList<Asignatura> asignaturas;
    
    public Docente(String nombre, String apellido, String nombreUsuario, String contrasena, String correo) {
        super(nombre, apellido, nombreUsuario, contrasena, correo);
        this.asignaturas = new ArrayList();
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    
    
    @Override
    public String getTipoUsuario() {
        return "DOCENTE";
    }
}
