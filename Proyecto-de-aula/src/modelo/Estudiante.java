/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Estudiante extends Usuario{

    private Universidad universidad;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Tarea> tareas;
    private ArrayList<Examen> examenes;
    private ArrayList<Double> notas;
    private Reporte reporte;

  
    
    public Estudiante(String nombre, String apellido, String nombreUsuario, String contrasena, int edad, String direccion, String correo, String numTelefono) {
        super(nombre, apellido, nombreUsuario, contrasena, edad, direccion, correo, numTelefono);
        this.asignaturas = new ArrayList();
        this.tareas = new ArrayList();
        this.examenes = new ArrayList();
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    public void añadirTareas(Actividad tarea) {
        tareas.add((Tarea) tarea);
    }

    public void añadirExamenes(Actividad examen) {
        examenes.add((Examen) examen);
    }

    public void añadirNotas(double nota) {
        notas.add(nota);
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    @Override
    public String getTipoUsuario() {
        return "ESTUDIANTE";
    }

    @Override
    public void menuUsuario() {
        boolean salir = false;
        int opcion;
        String datosMenu;
        
        while(!salir){
            datosMenu = "           SISTEMA DE GESTION (ESTUDIANTE)           \n\n"+
                    "1. INSCRIPCION EN ASIGNATURAS\n"+
                    "2. CONSULTAR\n"+
                    "3. SALIR"+
                    "\n\n Ingrese opcion: ";
            try {
                opcion = Integer.valueOf(JOptionPane.showInputDialog(datosMenu));
                switch(opcion){
                    case 1:
                        break;           
                    case 2:
                        break;
                    case 3: 
                        salir= true;
                        break;
                }
            }   catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico para la opción del menú.");
                }
        }

    }

    @Override
        public String toString() {
        return "Estudiante: " + "nombre: " + super.getNombre() + ", usuario: " + super.getNombreUsuario() +
                "Apellido: " + super.getApellido()+
                ", correo: " + super.getCorreo();
    }
    
    
        







    

    

        
        

}
