
package dataTransferObject;

import java.util.Date;

public class VentaNotificacionDTO {

    // DTO que contiene los datos a mostrar en una notificación de reserva vencida
    
    private int id;
    private String nombreCliente;
    private long telefonoCliente;
    private float importeActual;
    private Date fechaReserva;

    public VentaNotificacionDTO(int id, String nombreCliente, String apellidoCliente, long telefonoCliente, float importeActual, Date fechaReserva) {
        
        this.id = id;
        this.nombreCliente = nombreCliente + apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.importeActual = importeActual;
        this.fechaReserva = fechaReserva;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
}
