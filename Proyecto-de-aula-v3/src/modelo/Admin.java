/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JComboBox;
import modelo.*;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import vista.Main;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Admin extends Usuario {

    private Usuario usuario;
//    private Universidad universidad;

    public Admin(String nombre, String apellido, String nombreUsuario, String contrasena, String correo, String departamento, String tipoUsuario) {
        super(nombre, apellido, nombreUsuario, contrasena, correo, departamento, tipoUsuario);

    }

    Universidad universidad = new Universidad();

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void matricularEstudiante() {
        String nombre = JOptionPane.showInputDialog("Nombre: \n");
        String apellido = JOptionPane.showInputDialog("Apellido: \n");
        String nombreUsuario = JOptionPane.showInputDialog("Nombre de usuario: \n");
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Ingrese la contraseña: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String contrasena = "";
        if (option == JOptionPane.OK_OPTION) {
            char[] password = passwordField.getPassword();
            contrasena = new String(password);
        }
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad: \n"));
        String direccion = JOptionPane.showInputDialog("Dirección: \n");
        String correo = JOptionPane.showInputDialog("Correo electrónico institucional: \n");
        String numTelefono = JOptionPane.showInputDialog("Número de teléfono: \n");
//        Estudiante estudiante = new Estudiante(nombre, apellido, nombreUsuario, contrasena, correo, departamento);
//        universidad.registrarEstudiante(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante matriculado exitosamente");
    }

    public void registrarDocente(JTextField txtNombre, JTextField txtApellido, JTextField txtNombreUsuario, JTextField txtCorreo, JPasswordField txtContraseña, JComboBox cbDepartamento, String tipoUsuario) {
        String nombre, apellido, nUsuario, correo, contraseña, departamento;
        nombre = txtNombre.getText();
        apellido = txtApellido.getText();
        nUsuario = txtNombreUsuario.getText();
        correo = txtCorreo.getText();
        contraseña = String.valueOf(txtContraseña.getPassword());
        departamento = (String) cbDepartamento.getSelectedItem();
        Docente d = new Docente(nombre, apellido, nUsuario, contraseña, correo, departamento, tipoUsuario);
        universidad.registrarDocente(d);
    }

    public String registrarAsignatura() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la asignatura:");
        String usuarioDocente;
        Docente docente;

        do {
            usuarioDocente = JOptionPane.showInputDialog("Ingrese el Usuario del docente:");
            docente = universidad.buscarDocente(usuarioDocente);
            if (docente == null) {
                JOptionPane.showMessageDialog(null, "Docente no existe!");
            }
        } while (docente == null);

        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la asignatura:");
        universidad.registrarAsignatura(nombre, usuarioDocente, descripcion);
        JOptionPane.showMessageDialog(null, "Asignatura registrada exitosamente");
        return "";
    }

}
