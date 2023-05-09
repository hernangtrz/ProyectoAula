/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.*;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import vista.Main;

/**
 *
 * @author HERNAN GUTIERREZ
 */


public class Administrador extends Usuario {
    private Usuario usuario;
//    private Universidad universidad;
    
    public Administrador(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        super(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        
    }

    Universidad universidad = new Universidad();
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String getTipoUsuario() {
        return "ADMINISTRADOR";
    }

    @Override
    public void menuUsuario() {
                
        boolean salir = false;
        int opcion;
        String datosMenu;
        
        while(!salir){
            datosMenu = "       SISTEMA DE GESTION (ADMINISTRADOR)         \n\n"+
                    "1. MATRICULAR ESTUDIANTE\n"+
                    "2. REGISTRAR DOCENTES\n"+
                    "3. CREACION DE ASIGNATURAS \n"+
                    "4. LISTADO GENERAL DE ESTUDIANTES\n"+
                    "5. LISTADO GENERAL DE DOCENTES\n"+
                    "6. LISTADO GENERAL DE ASIGNATURAS\n"+
                    "7. CAMBIAR DE USUARIO\n"+
                    "8. SALIR"+
                    "\n\n Ingrese opcion: ";
            try {
                opcion = Integer.valueOf(JOptionPane.showInputDialog(datosMenu));
                switch(opcion){
                    case 1:
                        matricularEstudiante();
                        break;           
                    case 2:
                        registrarDocente();
                        break;
                    case 3:                        

                        registrarAsignatura();
                        break;
                    case 4:
                        String listaEstudiantes = universidad.listadoEstudiantes();
                        JOptionPane.showMessageDialog(null, listaEstudiantes);
                        break;

                    case 5: 
                        String listaDocentes = universidad.listadoDocentes();
                        JOptionPane.showMessageDialog(null, listaDocentes);
                        break;
                    case 6:
                        String listaAsignaturas = universidad.listadoAsignaturas();
                        JOptionPane.showMessageDialog(null, listaAsignaturas);
                        break;
                    case 7: 
                        String nombreUsuario = JOptionPane.showInputDialog("Ingrese el usuario al que desea cambiar:");
                        JPasswordField passwordField = new JPasswordField();
                        int option = JOptionPane.showConfirmDialog(null, passwordField, "Ingrese la contraseña: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        String contrasena = "";
                        if (option == JOptionPane.OK_OPTION) {
                        char[] password = passwordField.getPassword();
                        contrasena = new String(password);
                        }
                        Usuario usuarioCambio = universidad.autenticarUsuario(nombreUsuario, contrasena);
                        if (usuarioCambio == null) {
                        JOptionPane.showMessageDialog(null, "El usuario y/o la contraseña son incorrectos.");
                        } else {
                        usuarioCambio.menuUsuario();
                        
                        }
                        
                        break;
                    case 8: 
                        salir= true;
                        break;
                }
            }   catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico para la opción del menú.");
                }
        }

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
        Estudiante estudiante = new Estudiante(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        universidad.registrarEstudiante(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante matriculado exitosamente");
    }


    public void registrarDocente() {
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
        Docente docente = new Docente(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        universidad.registrarDocente(docente);
        JOptionPane.showMessageDialog(null, "Docente registrado exitosamente");
    }    
    
    public String registrarAsignatura(){
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