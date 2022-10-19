
package dataTransferObject;

import java.util.Date;

public class VentaNotificacionDTO {

    // DTO que contiene los datos a mostrar en una notificación de reserva vencida
    
    private String nombreCliente;
    private String apellidoCliente;
    private long telefonoCliente;
    private float importeActual;
    private Date fecha;

    public VentaNotificacionDTO(String nombreCliente, String apellidoCliente, long telefonoCliente, float importeActual, Date fecha) {
        
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.importeActual = importeActual;
        this.fecha = fecha;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public long getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(long telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public float getImporteActual() {
        return importeActual;
    }

    public void setImporteActual(float importeActual) {
        this.importeActual = importeActual;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
