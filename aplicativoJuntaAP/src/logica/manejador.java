package logica;

public class manejador {

    public reunion crearReunion(String fecha, String nombre, String descripcion) {
        reunion r = new reunion(fecha, nombre, descripcion);
        return r;
    }

    public asistenciaReunion crearRegistrarAsistencias(int idSocio, String fecha, int tipoAsistencia, int pago) {
        asistenciaReunion a = new asistenciaReunion(idSocio, fecha, tipoAsistencia, pago);
        return a;
    }
    
    public trabajo crearTrabajo (String fecha, String nombre, String descripcion){
        trabajo t = new trabajo(fecha, nombre, descripcion);
        return t;
    }
    
    public convocatoriaTrabajos crearConvocatoriaTrabajos(String trabajo_fecha, int socio_idsocio, int asistencia){
        convocatoriaTrabajos ct = new convocatoriaTrabajos(trabajo_fecha, socio_idsocio, asistencia);
        return ct;
    }

    public socio crearSocio(int codigo, int numMedidor, String nombre, String cedula, String telefono, String correo, double consumo){
        socio s = new socio(codigo, numMedidor, nombre, cedula, telefono, correo, consumo);
        return s;
    }
    
}
