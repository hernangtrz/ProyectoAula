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
import javax.swing.JOptionPane;

public class Universidad {

    private String nombre;
    private List<Estudiante> estudiantes = new ArrayList();
    private List<Docente> docentes = new ArrayList();
    private List<Admin> administradores = new ArrayList();
    private List<Asignatura> asignaturas = new ArrayList();

    public Universidad() {

    }

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.administradores = new ArrayList();
        this.docentes = new ArrayList();
        this.estudiantes = new ArrayList();
        this.asignaturas = new ArrayList();
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    public void añadirAsignaturas(Asignatura a){
        this.asignaturas.add(a);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public List<Admin> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Admin> administradores) {
        this.administradores = administradores;
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        estudiante.setUniversidad(this);
    }

    public void registrarDocente(Docente docente) {
        docentes.add(docente);
        docente.setUniversidad(this);
    }

    public void registrarAdministrador(Admin admin) {
        administradores.add(admin);
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

        for (Admin administrador : administradores) {
            if (administrador.getNombreUsuario().equals(nombreUsuario) && administrador.getContrasena().equals(contrasena)) {
                return administrador;
            }
        }

        return null;
    }

    public Docente buscarDocente(String nombreDocente) {

        for (Docente docente : docentes) {
            if (docente.getNombreUsuario().equals(nombreDocente)) {
                return docente;
            }
        }
        return null;
    }

    public void registrarAsignatura(String nombre, String nombreDocente, String descripcion) {

        Docente docente = buscarDocente(nombreDocente);
        if (docente == null) {
            System.out.println("No se puede registrar la asignatura porque el docente no existe.");
            return;
        }

        Asignatura asignatura = new Asignatura(nombre, nombreDocente, descripcion, "");
        asignaturas.add(asignatura);
        docente.registrarAsignatura(asignatura);

        System.out.println("Asignatura registrada exitosamente.");
    }

    
}