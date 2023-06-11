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
import java.util.Arrays;
import javax.swing.JOptionPane;
import modelo.Actividad;
import modelo.ActividadesEntregadas;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class ArchivoActividadesEntregadas {
    private File archivo;

    public ArchivoActividadesEntregadas() {
    }

    public void guardarActividadEntregada(ActividadesEntregadas actividad) throws IOException {
        try {
            this.archivo = new File("Archivos//ActividadesEntregadas//" + actividad.getActividad().getNombre()+ ".txt");
            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(actividad);
            fileOut.close();
            System.out.println("Objeto guardado exitosamente en el archivo: " + archivo.getName());
        } catch (IOException e) {
            throw new IOException("Error al guardar el objeto en el archivo: " + archivo.getName());
        }
    }

    public ActividadesEntregadas obtenerActividad(String nombreActividad) throws IOException {
        try {
            this.archivo = new File("Archivos//ActividadesEntregadas//" + nombreActividad + ".txt");
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ActividadesEntregadas actividad = (ActividadesEntregadas) objectIn.readObject();
            fileIn.close();
            return actividad;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No hay actividad asignada con ese nombre");
            throw new IOException("Error al cargar la Asignatura desde el archivo: " + nombreActividad);
        }
    }
    
    public File[] recorrerActividadesEntregadas() {
        File carpeta = new File("Archivos//ActividadesEntregadas//");
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            return archivos;
        } else {
            System.out.println("No se encontro la carpeta");
        }
        return null;
    }
}
