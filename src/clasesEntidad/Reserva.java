
package clasesEntidad;

import java.util.Date;

public class Reserva {
    
    // Atributos
    
    private long telefonoCliente;
    private float seña;
    private Date fecha;
    
    // Constructor

    public Reserva(long telefonoCliente, float seña, Date fecha) {
       
        this.telefonoCliente = telefonoCliente;
        this.seña = seña;
        this.fecha = fecha;
    }

    public Reserva() {
        
    }

    public Reserva(Reserva reserva){
        this.telefonoCliente = reserva.getTelefonoCliente();
        this.seña = reserva.getSeña();
        this.fecha = reserva.getFecha(); 
    }
    
    // Getters y Setters

    public long getTelefonoCliente() {return telefonoCliente;}
    public void setTelefonoCliente(long telefonoCliente) {this.telefonoCliente = telefonoCliente;}

    public float getSeña() {return seña;}
    public void setSeña(float seña) {this.seña = seña;}

    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}
    
}