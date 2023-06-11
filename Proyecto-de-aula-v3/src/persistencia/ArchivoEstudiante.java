/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import modelo.Asignatura;
import modelo.Estudiante;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class ArchivoEstudiante {

    private File archivo;

    public ArchivoEstudiante() {
    }

    public void guardarEstudiante(Estudiante estudiante) throws IOException {
        try {
            this.archivo = new File("Archivos//Estudiantes//" + estudiante.getNombreUsuario() + ".txt");
            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(estudiante);
            fileOut.close();
            System.out.println("Objeto guardado exitosamente en el archivo: " + archivo.getName());
        } catch (IOException e) {
            throw new IOException("Error al guardar el objeto en el archivo: " + archivo.getName());
        }
    }

    public Estudiante obtenerEstudiante(String nombreEstudiante) throws IOException {
        try {
            this.archivo = new File("Archivos//Estudiantes//" + nombreEstudiante + ".txt");
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Estudiante estudiante = (Estudiante) objectIn.readObject();
            fileIn.close();
            return estudiante;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el estudiante");
            throw new IOException("Error al cargar el estudiante desde el archivo: " + nombreEstudiante);
        }
    }
    
    public File[] recorrerEstudiantes() {
        File carpeta = new File("Archivos//Estudiantes//");
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            return archivos;
        } else {
            System.out.println("No se encontro la carpeta");
        }
        return null;
    }

}
