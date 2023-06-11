/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelo.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Admin;
import modelo.Docente;
import modelo.Estudiante;



/**
 *
 * @author HERNAN GUTIERREZ
 */
public class ArchivoUsuarios {

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoUsuarios() {
        this("Archivos//Usuarios.txt");
    }

    public ArchivoUsuarios(String name) {
        this.archivo = new File(name);
    }

    public void guardarUsuario(Usuario usuario) throws IOException {
        // Valida campos obligatorios
        for (String campo : Arrays.asList(
                usuario.getNombre(), usuario.getApellido(), usuario.getNombreUsuario(),
                usuario.getContrasena(), usuario.getCorreo(), usuario.getDepartamento(),
                usuario.getTipoUsuario())) {
            if (campo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. Por favor, completa todos los campos.");
                return;
            }
        }
        // Escibe usuarios en el archivo
        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            PrintWriter printWriter = new PrintWriter(aEscritura);
            printWriter.println(usuario.getNombre() + ","
                    + usuario.getApellido() + ","
                    + usuario.getNombreUsuario() + ","
                    + usuario.getContrasena() + ","
                    + usuario.getCorreo() + ","
                    + usuario.getDepartamento() + ","
                    + usuario.getTipoUsuario());
            JOptionPane.showMessageDialog(null, "Registro exitoso.");

        } catch (IOException e) {
            throw new IOException("Error al guardar el usuario");
        } finally {
            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }

    public Usuario obtenerUsuario(String nombreUsuario, String contraseña, String tipoUsuario) throws IOException {
        // lee los usuarios del archivo
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 7) {
                    String nombre = campos[0];
                    String apellido = campos[1];
                    String usuario = campos[2];
                    String password = campos[3];
                    String correo = campos[4];
                    String departamento = campos[5];
                    String tUsuario = campos[6];
                    if (usuario.equals(nombreUsuario) && password.equals(contraseña) && tUsuario.equals(tipoUsuario)) {
                        return new Usuario(nombre, apellido, usuario, password, correo, departamento, tUsuario);
                    }    
                }
            }
          return null;  
        } catch (IOException e) {
            throw new IOException("Error al obtener el usuario");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
        
    }
      

    public List<String> informeDocentes() throws IOException {
        List<String> docentes = new ArrayList();
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 7) {
                    if (campos[6].equals("DOCENTE")) {
                        String usuario = campos[2];
                        docentes.add(usuario);
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al obtener los Docentes");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
        return docentes;
    }
   
    public List<Usuario> informeEstudiantes() throws IOException {
        List<Usuario> estudiantes = new ArrayList();
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 7) {
                    if (campos[6].equals("ESTUDIANTE")) {
                        String nombre = campos[0];
                        String apellido = campos[1];
                        String usuarioE = campos[2];
                        String password = campos[3];
                        String correo = campos[4];
                        String departamento = campos[5];
                        String tUsuario = campos[6];
                        Usuario usuario = new Usuario(nombre, apellido, usuarioE,password,correo, departamento,tUsuario);
                        estudiantes.add(usuario);

                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al obtener los Estudiantes");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
        return estudiantes;
    }

    public List<Usuario> informeProfesores() throws IOException {
        List<Usuario> profesores = new ArrayList();
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 7) {
                    if (campos[6].equals("DOCENTE")) {
                        String nombre = campos[0];
                        String apellido = campos[1];
                        String usuarioE = campos[2];
                        String password = campos[3];
                        String correo = campos[4];
                        String departamento = campos[5];
                        String tUsuario = campos[6];
                        Usuario usuario = new Usuario(nombre, apellido, usuarioE,password,correo, departamento,tUsuario);
                        profesores.add(usuario);

                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al obtener los Estudiantes");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
        return profesores;
    }
    
    
    public void registrarUusario(Usuario usuario) throws IOException {
        ArchivoUsuarios a = new ArchivoUsuarios();
        try {
            a.guardarUsuario(usuario);
        } catch (IOException e) {
            throw new IOException("Error al registrar el usuario");
        }

    }

    public boolean validarSesion(Usuario usuario) throws IOException {

        if (usuario != null) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
            return true;
        } 
        return false;
    }
    
    public void eliminarUsuario(String nombreUsuario, String contraseña, String tipoUsuario) throws IOException {
        // Verificar si el usuario existe
        Usuario usuario = obtenerUsuario(nombreUsuario, contraseña, tipoUsuario);
        if (usuario != null) {
            // Leer todas las líneas del archivo
            List<String> lineas = new ArrayList<>();
            try (Scanner scanner = new Scanner(this.archivo)) {
                while (scanner.hasNextLine()) {
                    lineas.add(scanner.nextLine());
                }
            }

            // Buscar la línea correspondiente al usuario y eliminarla
            for (int i = 0; i < lineas.size(); i++) {
                String[] campos = lineas.get(i).split(",");
                if (campos.length == 7) {
                    String usuarioArchivo = campos[2];
                    String password = campos[3];
                    String tUsuario = campos[6];
                    if (usuarioArchivo.equals(nombreUsuario) && password.equals(contraseña) && tUsuario.equals(tipoUsuario)) {
                        lineas.remove(i);
                        break;
                    }
                }
            }

            // Escribir las líneas actualizadas en el archivo
            try (PrintWriter writer = new PrintWriter(this.archivo)) {
                for (String linea : lineas) {
                    writer.println(linea);

                }
                JOptionPane.showMessageDialog(null, "Docente Eliminado Satisfactoriamente!");
            }
        }   else {
                JOptionPane.showMessageDialog(null, "Datos Incorrecto o Error al obtener el usuario");
            }
    }

    
}
