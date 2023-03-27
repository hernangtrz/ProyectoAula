/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import java.time.LocalDate;
import modelo.Asignatura;
import modelo.Estudiante;
/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estudiante estudiante1 = new Estudiante("Hernan", "Gutierrez", 19, "Cra 7#13a-26", "hernanagutierrez@unicesar.edu.co", "3186567541");
        Asignatura programacion2 = new Asignatura("Programacion de compytadores II", "Jairo Seoanes", "Sin descripcion");
        
        System.out.println(estudiante1);
        System.out.println(programacion2);
    
    }
    
}
