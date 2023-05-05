/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HERNAN GUTIERREZ
 */
import java.util.ArrayList;
import java.util.List;

public class SistemaGestionAcademica {

    private List<Estudiante> estudiantes = new ArrayList<>();
    private List<Docente> docentes = new ArrayList<>();
    private List<Administrador> administradores = new ArrayList<>();

    public void registrarEstudiante(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        Estudiante estudiante = new Estudiante(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        estudiantes.add(estudiante);
    }

    public void registrarDocente(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        Docente docente = new Docente(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        docentes.add(docente);
    }

    public void registrarAdministrador(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        Administrador administrador = new Administrador(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        administradores.add(administrador);
    }

    public Usuario autenticarUsuario(String nombreUsuario, String contrasena) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombreUsuario().equals(nombreUsuario) && estudiante.getContrasena().equals(contrasena)) {
                return estudiante;
            }
        }

        for (Docente docente : docentes) {
            if (docente.getNombreUsuario().equals(nombreUsuario) && docente.getContrasena().equals(contrasena)) {
                return docente;
            }
        }

        for (Administrador administrador : administradores) {
            if (administrador.getNombreUsuario().equals(nombreUsuario) && administrador.getContrasena().equals(contrasena)) {
                return administrador;
            }
        }

        return null;
    }
}
