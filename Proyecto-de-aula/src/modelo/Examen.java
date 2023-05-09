/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Examen extends Actividad{


    public Examen(LocalDate fechaExamen, String descripcion, Asignatura asignatura) {
        super(fechaExamen, descripcion, asignatura);
    }


}