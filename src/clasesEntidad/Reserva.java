
package clasesEntidad;

import java.util.Date;

public class Reserva {
    
    // Atributos
    
    private String telefonoCliente;
    private float seña;
    private Date fechaRegistro;
    
    // Constructor

    public Reserva(String telefonoCliente, float seña, Date fecha) {    
        this.telefonoCliente = telefonoCliente;
        this.seña = seña;
        this.fechaRegistro = fecha;
    }

    public Reserva() {
        telefonoCliente = "INVALIDO";
        seña = -1;
        fechaRegistro = new Date(); 
    }

    public Reserva(Reserva reserva){
        this.telefonoCliente = reserva.getTelefonoCliente();
        this.seña = reserva.getSeña();
        this.fechaRegistro = reserva.getFechaRegistro(); 
    }
    
    // Getters y Setters

    public String getTelefonoCliente() {return telefonoCliente;}
    public void setTelefonoCliente(String telefonoCliente) {this.telefonoCliente = telefonoCliente;}

    public float getSeña() {return seña;}
    public void setSeña(float seña) {this.seña = seña;}

    public Date getFechaRegistro() {return fechaRegistro;}
    public void setFechaRegistro(Date fecha) {this.fechaRegistro = fecha;}
    
}
