/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Administrador extends Usuario {
    
    public Administrador(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        super(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        
    }
    
    
    @Override
    public String getTipoUsuario() {
        return "ADMINISTRADOR";
    }
}