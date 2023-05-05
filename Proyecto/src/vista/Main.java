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
        
        sistema.registrarEstudiante("Hernan", "Gutierrez", "hernanagutierrez", "hernan123", 19, "cra 7#13a-26", "hernanagutierrez@unicesar.edu.co", "3186567541");
//        sistema.registrarDocente("maria", "abcd", "María García");
//        sistema.registrarAdministrador("admin", "admin123", "Administrador");
        
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
