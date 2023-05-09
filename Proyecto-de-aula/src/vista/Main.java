/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
        Universidad universidad = new Universidad();                
        universidad.registrarAdministrador("JAIRO", "SEOANES", "jseoanes", "j123", 45, "upc sabanas", "jseoanes@unicesar.edu.co", "3000001001");
        
        //Scanner scanner = new Scanner(System.in);
        
        
        String nombreUsuario = JOptionPane.showInputDialog("Nombre de usuario: \n");
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Ingrese su contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String contrasenap = "";
        if (option == JOptionPane.OK_OPTION) {
            char[] password = passwordField.getPassword();
            contrasenap = new String(password);
        }
        
        String contrasena = contrasenap;                
        Usuario usuario = universidad.autenticarUsuario(nombreUsuario, contrasena);
        
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
        } else {
            JOptionPane.showMessageDialog(null, "Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido() + " ( " + usuario.getTipoUsuario() + " )");
            usuario.menuUsuario();
        }                             
    }                
}
