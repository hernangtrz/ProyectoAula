/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Asignatura;
import modelo.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author rebf8
 */
public class ArchivoAsignaturas {
    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    
    
    public ArchivoAsignaturas() {
        this("Asignaturas.txt");
    }

    public ArchivoAsignaturas(String name) {
        this.archivo = new File(name);
    }

    public void guardarAsignatura(Asignatura asignatura) throws IOException {
        // Valida campos obligatorios
        for (String campo : Arrays.asList(
                asignatura.getCodAsig(),asignatura.getNombre(), asignatura.getDescripcion())) {
            if (campo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. Por favor, completa todos los campos.");
                return;
            }
        }
        // Escibe asignaturas en el archivo
        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            PrintWriter printWriter = new PrintWriter(aEscritura);
            printWriter.println(asignatura.getCodAsig()+ "," +
                    asignatura.getNombre() + ","
                    + asignatura.getDescripcion());
            JOptionPane.showMessageDialog(null, "Registro exitoso.");

        } catch (IOException e) {
            throw new IOException("Error al guardar la Asignatura");
        } finally {
            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }

    public Asignatura obtenerAsignatura(String codAsignatura, String nombreAsignatura,  String descripcionAsig) throws IOException {
        // lee los usuarios del archivo
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 3) {
                    String codigo = campos[0];
                    String nombre = campos[1];
                    String descripcion = campos[2];

                    if (codigo.equals(codAsignatura)&& nombre.equals(nombreAsignatura) && descripcion.equals(descripcionAsig)) {
                        return new Asignatura(codigo,nombre, descripcion);
                    }    
                }
            }
          return null;  
        } catch (IOException e) {
            throw new IOException("Error al obtener la Asignatura");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
        
    }

    public Asignatura obtenerAsignatura(String codAsignatura, String nombreAsignatura) throws IOException {
        // lee los usuarios del archivo
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 3) {
                    String codigo = campos[0];
                    String nombre = campos[1];

                    if (codigo.equals(codAsignatura)&& nombre.equals(nombreAsignatura)) {
                        return new Asignatura(codigo,nombre);
                    }    
                }
            }
          return null;  
        } catch (IOException e) {
            throw new IOException("Error al obtener la Asignatura");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
        
    }    
    
    public Asignatura obtenerAsignatura(String nombreAsignatura) throws IOException {
        try {
            this.archivo = new File("Archivos//Asignaturas//" + nombreAsignatura + ".txt");
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Asignatura asignatura = (Asignatura) objectIn.readObject();
            fileIn.close();
            return asignatura;
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Error al cargar la Asignatura desde el archivo: " + nombreAsignatura);
        }
    }    
    
    public Asignatura obtenerAsignaturaR(String codAsignatura) throws IOException {
        // lee los usuarios del archivo
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 3) {
                    String codigo = campos[0];
                    String nombre = campos[1];

                    if (codigo.equals(codAsignatura)) {
                        return new Asignatura(codigo,nombre);
                    }    
                }
            }
          return null;  
        } catch (IOException e) {
            throw new IOException("Error al obtener la Asignatura");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
        
    }    
    
    public void registrarAsignatura(Asignatura asignatura) throws IOException {
        ArchivoAsignaturas a = new ArchivoAsignaturas();
        try {
            a.guardarAsignatura(asignatura);
        } catch (IOException e) {
            throw new IOException("Error al registrar la Asignatura");
        }

    }
    
    public List<String> codAsignaturas() throws IOException {
        List<String> codAsig = new ArrayList();
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 3) {
                    
                        String codigo = campos[0];
                        codAsig.add(codigo);                    
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al obtener los Codigos de Asignaturas");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
        return codAsig;
    }    
    
    
public void eliminarAsignaturaR(String codAsignatura, String nombreAsignatura) throws IOException {
        // Verificar si el usuario existe
        Asignatura asignatura = obtenerAsignatura(codAsignatura, nombreAsignatura);
        if (asignatura != null) {
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
                if (campos.length == 3) {
                    String codAsig = campos[0];
                    String nomAsig = campos[1];
                    //String tUsuario = campos[6];
                    if (codAsig.equals(codAsignatura) && nomAsig.equals(nombreAsignatura)) {
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
                JOptionPane.showMessageDialog(null, "Asignatura Eliminada Satisfactoriamente!");
            }
        }   else {
                JOptionPane.showMessageDialog(null, "Datos Incorrectos o Error al obtener la Asignatura");
            }
    }
    
    public void eliminarAsignatura(String nommbreAsignatura) {
        // Crear el objeto File con la ruta completa del archivo
        this.archivo = new File("Archivos//Asignaturas//" + nommbreAsignatura + ".txt");

        // Verificar si el archivo existe antes de eliminarlo
        if (archivo.exists()) {
            // Eliminar el archivo
            if (archivo.delete()) {
                JOptionPane.showMessageDialog(null, "Asignatura eliminada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la asignatura");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La asigantura que quieres borrar no exixte");
        }
    }

    
    public File[] recorrerAsignaturas() {
        File carpeta = new File("Archivos//Asignaturas//");
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            return archivos;
        } else {
            System.out.println("No se encontro la carpeta");
        }
        return null;
    }

    
    public List<Asignatura> listadoAsignaturas() throws IOException {
        List<Asignatura> asignaturas = new ArrayList<>();

        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String[] campos = scanner.nextLine().split(",");
                if (campos.length == 3) {
                    String cod = campos[0];
                    String nombre = campos[1];
                    String descripcion = campos[2];

                    Asignatura a = new Asignatura(cod, nombre,descripcion);
                    asignaturas.add(a);
                }
            }
        }

        return asignaturas;
    }
    
    public void guardarAsignaturas(Asignatura asignatura) throws IOException {
        try {
            this.archivo = new File("Archivos//Asignaturas//" + asignatura.getNombre() + ".txt");
            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(asignatura);
            fileOut.close();
            System.out.println("Objeto guardado exitosamente en el archivo: " + archivo.getName());
        } catch (IOException e) {
            throw new IOException("Error al guardar el objeto en el archivo: " + archivo.getName());
        }
    }    
    
}
