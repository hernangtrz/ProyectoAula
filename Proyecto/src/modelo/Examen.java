/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author HERNAN GUTIERREZ
 */
public class Examen {

    private LocalDate fechaExamen;
    private String tipoExamen;
    private Asignatura asignatura;

    public Examen(LocalDate fechaExamen, String tipoExamen, Asignatura asignatura) {
        this.fechaExamen = fechaExamen;
        this.tipoExamen = tipoExamen;
        this.asignatura = asignatura;
    }

    public LocalDate getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(LocalDate fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Examen{" + "fechaExamen=" + fechaExamen + ", tipoExamen=" + tipoExamen + ", asignatura=" + asignatura + '}';
    }

}
