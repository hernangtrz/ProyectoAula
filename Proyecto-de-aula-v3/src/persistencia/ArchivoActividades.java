/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class ArchivoActividades {

    private File archivo;

    public ArchivoActividades() {
    }

    public void guardarActividad(Actividad actividad) throws IOException {
        for (String campo : Arrays.asList(
                actividad.getNombre(), actividad.getFechaEntrega(),
                actividad.getDescripcion())) {
            if (campo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. Por favor, completa todos los campos.");
                return;
            }
        }
        try {
            this.archivo = new File("Archivo//Actividades//" + actividad.getNombre() + ".txt");
            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(actividad);
            fileOut.close();
            System.out.println("Objeto guardado exitosamente en el archivo: " + archivo.getName());
        } catch (IOException e) {
            throw new IOException("Error al guardar el objeto en el archivo: " + archivo.getName());
        }
    }

    public Actividad obtenerActividad(String nombreActividad) throws IOException {
        try {
            this.archivo = new File("Archivo//Actividades//" + nombreActividad + ".txt");
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Actividad actividad = (Actividad) objectIn.readObject();
            fileIn.close();
            return actividad;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No hay actividad asignada con ese nombre");
            throw new IOException("Error al cargar la Asignatura desde el archivo: " + nombreActividad);
        }
    }

    public void eliminarActividad(String nombreActividad) {
        // Crear el objeto File con la ruta completa del archivo
        this.archivo = new File("Archivo//Actividades//" + nombreActividad + ".txt");

        // Verificar si el archivo existe antes de eliminarlo
        if (archivo.exists()) {
            // Eliminar el archivo
            if (archivo.delete()) {
                JOptionPane.showMessageDialog(null, "Actividad eliminada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la Actividad");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La Actividad que quieres borrar no exixte");
        }
    }
}
