/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Kami Osita Bebe
 */
public class reunion {
    
    public String fecha;
    public String nombre;
    public String descripcion;

    public reunion(String fecha, String nombre, String descripcion) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}