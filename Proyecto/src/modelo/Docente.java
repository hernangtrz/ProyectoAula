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
    
    public Docente(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        super(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        this.asignaturas = new ArrayList();
    }
    
    
    @Override
    public String getTipoUsuario() {
        return "DOCENTE";
    }
}
