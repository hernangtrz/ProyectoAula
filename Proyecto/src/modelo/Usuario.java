/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public abstract class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String correo;
    private String numTelefono;
    
    public Usuario(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.correo = correo;
        this.numTelefono = numTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
    
    
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public abstract String getTipoUsuario();
}

