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
import modelo.Docente;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class ArchivoDocente {

    private File archivo;

    public ArchivoDocente() {
    }

    public void guardarDocente(Docente docente) throws IOException {
        try {
            this.archivo = new File("Archivos//Docentes//" + docente.getNombreUsuario() + ".txt");
            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(docente);
            fileOut.close();
            System.out.println("Objeto guardado exitosamente en el archivo: " + archivo.getName());
        } catch (IOException e) {
            throw new IOException("Error al guardar el objeto en el archivo: " + archivo.getName());
        }
    }

    public Docente obtenerDocente(String nombreDocente) throws IOException {
        try {
            this.archivo = new File("Archivos//Docentes//" + nombreDocente + ".txt");
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Docente docente = (Docente) objectIn.readObject();
            fileIn.close();
            return docente;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el docente");
            throw new IOException("Error al cargar el estudiante desde el archivo: " + nombreDocente);
        }
    }
}
