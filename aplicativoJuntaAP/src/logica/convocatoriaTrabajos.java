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
public class convocatoriaTrabajos {
    private String trabajo_fecha;
    private int socio_idsocio;
    private int asistencia;

    public convocatoriaTrabajos(String trabajo_fecha, int socio_idsocio, int asistencia) {
        this.trabajo_fecha = trabajo_fecha;
        this.socio_idsocio = socio_idsocio;
        this.asistencia = asistencia;
    }

    public String getTrabajo_fecha() {
        return trabajo_fecha;
    }

    public void setTrabajo_fecha(String trabajo_fecha) {
        this.trabajo_fecha = trabajo_fecha;
    }

    public int getSocio_idsocio() {
        return socio_idsocio;
    }

    public void setSocio_idsocio(int socio_idsocio) {
        this.socio_idsocio = socio_idsocio;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }
    
    
}
