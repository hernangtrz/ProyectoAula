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
public class Tarea extends Actividad{

    public Tarea(LocalDate fechaEntrega, String descripcion, Asignatura asignatura) {
        super(fechaEntrega, descripcion, asignatura);
    }
}