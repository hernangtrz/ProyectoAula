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
import modelo.Docente;
import modelo.Usuario;

/**
 *
 * @author rebf8
 */
public class ArchivoDocAsignaturas {
    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoDocAsignaturas() {
        this("DocentesAsignaturas.txt");
    }

    public ArchivoDocAsignaturas(String name) {
        this.archivo = new File(name);
    }
       
    
    public void guardarDocAsignaturas(String codigo, String nombre, String docente) throws IOException {
        //verificar si existe
        
        Boolean ass = obtenerRelacion(codigo);
        if (ass != true) {
            // Leer todas las líneas del archivo
            List<String> lineas = new ArrayList<>();
            try (Scanner scanner = new Scanner(this.archivo)) {
                while (scanner.hasNextLine()) {
                    lineas.add(scanner.nextLine());
                }
            }
            
            
            // Escibe en el archivo
            try {
                this.aEscritura = new FileWriter(this.archivo, true);
                PrintWriter printWriter = new PrintWriter(aEscritura);
                printWriter.println(codigo + "," +
                        nombre + "," +
                        docente);
                JOptionPane.showMessageDialog(null, "Registro exitoso.");

            } catch (IOException e) {
                throw new IOException("Error al guardar la Asignación !");
            } finally {
                if (this.aEscritura != null) {
                    this.aEscritura.close();
                }
            }
        }else {   
        JOptionPane.showMessageDialog(null, "Error ! la asignatura ya tiene asignado un Docente");
        }
    }       
        
    public Boolean obtenerRelacion(String codigo) throws IOException {
        // lee los usuarios del archivo
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 3) {
                    String cod = campos[0];

                    if (cod.equals(codigo)) {
                        return true;
                    }    
                }
            }
          return false;  
        } catch (IOException e) {
            throw new IOException("Error al obtener el fichero!");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }        
    }
    
    public List<String> consultaRelacion(String codigo) throws IOException {
        List<String> lista = new ArrayList();
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 3) {
                    if (campos[0].equals(codigo)) {
                      String cod = campos[0];
                      String nom= campos[1];
                      String doc = campos[2];
                      lista.add(cod);
                      lista.add(nom);
                      lista.add(doc);
                      return lista;
                    }
                }
            }
            
        } catch (IOException e) {
            throw new IOException("Error al obtener los correos");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
        JOptionPane.showMessageDialog(null, "El codigo ingresado no se encuentra Asignado");
        return null;
    }    
    
    public List<String> consultaRelacion() throws IOException {
        List<String> lista = new ArrayList();
        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String[] campos = this.aLectura.nextLine().split(",");
                if (campos.length == 3) {

                      String cod = campos[0];
                      String nom= campos[1];
                      String doc = campos[2];
                      lista.add(cod);
                      lista.add(nom);
                      lista.add(doc);
                      

                }
            }
            
        } catch (IOException e) {
            throw new IOException("Error al obtener las Asignaciones");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }

        return lista;
    }    
    
    
    public List<String> eliminarRelacion(String codigo) throws IOException {
        // Verificar si el usuario existe
        List<String> relacion = consultaRelacion(codigo);
        if (relacion != null) {
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
                    String cod = campos[0];
                    if (cod.equals(codigo)) {
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
                JOptionPane.showMessageDialog(null, "Asignacion Eliminada Satisfactoriamente!");
            }
        }   else {
                JOptionPane.showMessageDialog(null, "Datos Incorrecto o Error al obtener el usuario");
            }
    return null;
    }   
   
    
    
}