/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import java.time.LocalDate;
import java.util.Scanner;
import modelo.*;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaGestionAcademica sistema = new SistemaGestionAcademica();
        
        sistema.registrarEstudiante("Hernan", "Gutierrez", "hernanagutierrez", "hernan123", "hernanagutierrez@unicesar.edu.co");
        sistema.registrarDocente("Maria", "Torres", "maria", "abcd", "mariatorres@unicesar.edu.co");
        sistema.registrarAdministrador("Jose", "Diaz", "admin", "admin123", "administrador@unicesar.edu.co");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        
        Usuario usuario = sistema.autenticarUsuario(nombreUsuario, contrasena);
        
        if (usuario == null) {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        } else {
            System.out.println("Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido() + " (" + usuario.getTipoUsuario() + ")");
        }
    
    }
    
}
