/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Docente extends Usuario {
    private ArrayList<Actividad> actividades;
    private Universidad universidad;
    private ArrayList<Asignatura> asignaturas;
    
    public Docente(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        super(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        this.asignaturas = new ArrayList();
        this.actividades = new ArrayList();
    }
    
    public void registrarAsignatura(Asignatura asignatura) {
     asignaturas.add(asignatura);
     
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    

    
        public void seguimientoActividades(){
        for(Actividad a: actividades ){
            System.out.println(a);
        }
    }
        
    public void enviarCalificacion(Estudiante est,double calificacion){
        est.añadirNotas(calificacion);
    }
                
    
    @Override
    public String getTipoUsuario() {
        return "DOCENTE";
    }

    @Override
    public void menuUsuario() {
        boolean salir = false;
        int opcion;
        String datosMenu;
        
        while(!salir){
            datosMenu = "           SISTEMA DE GESTION (DOCENTE)            \n\n"+
                    "1. ASIGNACION DE ACTIVIDADES\n"+
                    "2. SEGUIMIENTO ACTIVIDADES ACADEMICAS\n"+
                    "3. CONSULTAR \n"+
                    "4. SALIR"+
                    "\n\n Ingrese opcion: ";
            try {
                opcion = Integer.valueOf(JOptionPane.showInputDialog(datosMenu));
                switch(opcion){
                    case 1:
//                        String tipoActividad = JOptionPane.showInputDialog("Ingrese el tipo de actividad (tarea/examen):");
//                        LocalDate fecha = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de la actividad (YYYY-MM-DD):"));
//                        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la actividad:");
//
//                        
//                        asignarActividad(tipoActividad, fecha, descripcion, asignatura, est);
//
//                        
//                        JOptionPane.showMessageDialog(null, "La actividad ha sido asignada correctamente.");
//                        break;           
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4: 
                        salir= true;
                        break;
                }
            }   catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico para la opción del menú.");
                }
        }
       
    }
    
    
    public void asignarActividad(String tipoActividad, LocalDate fecha, String descripcion, Asignatura asignatura, Estudiante est ){
        if("tarea".equalsIgnoreCase(tipoActividad)){
            Actividad t = new Tarea(fecha, descripcion, asignatura);
            est.añadirTareas(t);
            actividades.add(t);
        }else if("examen".equalsIgnoreCase(tipoActividad)){
            Actividad e = new Examen(fecha, descripcion, asignatura);
            est.añadirExamenes(e);
            actividades.add(e);
           
        }
    }
}
