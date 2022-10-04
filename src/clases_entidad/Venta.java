
package clases_entidad;

import java.util.ArrayList;
import java.util.Date;

public class Venta {
    
    // Definición de MetodoPago (tipo enumerado)
    
    public enum MetodoPago {
        EFECTIVO, MERCADOPAGO;
        @Override
        public String toString() {
            if (this==EFECTIVO) return "Efectivo";
            else return "MercadoPago";
        }
    }
    
    // Definición de EstadoVenta (tipo enumerado)
    
    public enum EstadoVenta {
        COMPLETADA, CANCELADA, EN_RESERVA;
        @Override
        public String toString() {
            return switch (this) {
                case COMPLETADA -> "Completada";
                case EN_RESERVA -> "En reserva";
                default -> "Cancelada";
            };
        }
    }
    
    // Atributos
    
    private int id;
    private String nombreCliente;
    private boolean envioGratis;
    private float importe;
    private Date fecha;
    private MetodoPago metodoPago;
    private EstadoVenta estado;
    private Reserva reserva;
    private ArrayList<ItemVenta> items;
    
    // Getters y Setters
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNombreCliente() {return nombreCliente;}
    public void setNombreCliente(String nombreCliente) {this.nombreCliente = nombreCliente;}

    public boolean getEnvioGratis() {return envioGratis;}
    public void setEnvioGratis(boolean envioGratis) {this.envioGratis = envioGratis;}

    public float getImporte() {return importe;}
    public void setImporte(float importe) {this.importe = importe;}

    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}

    public MetodoPago getMetodoPago() {return metodoPago;}
    public void setMetodoPago(MetodoPago metodoPago) {this.metodoPago = metodoPago;}

    public EstadoVenta getEstado() {return estado;}
    public void setEstado(EstadoVenta estado) {this.estado = estado;}

    public Reserva getReserva() {return reserva;}
    public void setReserva(Reserva reserva) {this.reserva = reserva;}
    
    public ArrayList<ItemVenta> getItems(){ return items; }
    public void setItems(ArrayList<ItemVenta> items) {this.items = items;}
}
