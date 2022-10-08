
package clases_entidad;

import java.util.ArrayList;
import java.util.Date;

public class Venta {  
    public enum MetodoPago {
        EFECTIVO, MERCADOPAGO;
        @Override
        public String toString() {
            if (this==EFECTIVO) return "EFECTIVO";
            else return "MERCADOPAGO";
        }
    }
    
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
    
    private int id;
    private String nombreCliente;
    private String apellidoCliente; 
    private boolean envioGratis;
    private float importe;
    private Date fechaPago;
    private MetodoPago metodoPago;
    private EstadoVenta estado;
    private Sucursal sucursal; 
    private Reserva reserva;
    private ArrayList<ItemVenta> itemsVenta;
    
    public Venta(){
        nombreCliente = "Indefinido";
        apellidoCliente = "Indefinido";
        envioGratis = false;
        importe = -1; 
        fechaPago = new Date();
        metodoPago = MetodoPago.EFECTIVO;
        estado = EstadoVenta.CANCELADA;
        sucursal = null; 
        reserva = null; 
        itemsVenta = new ArrayList<>();
    }

    public Venta(String nombreCliente, String apellidoCliente, boolean envioGratis, float importe, Date fechaPago,
                MetodoPago metodoPago, EstadoVenta estado, Sucursal sucursal, ArrayList<ItemVenta> itemsVenta)
    {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.envioGratis = envioGratis;
        this.importe = importe;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.sucursal = new Sucursal(sucursal); 
        this.itemsVenta = new ArrayList<>(itemsVenta);
    }
    
    public int getId(){
        return id;
    }
    
    public int setId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public String getNombreCliente(){
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
    
    public String getApellidoCliente(){
        return apellidoCliente;
    }
    
    public void setApellidoCliente(String apellidoCliente){
        this.apellidoCliente = apellidoCliente;
    }

    public boolean getEnvioGratis(){
        return envioGratis;
    }
    
    public void setEnvioGratis(boolean envioGratis){
        this.envioGratis = envioGratis;
    }
    
    public float getImporte(){
        return importe;
    }
    
    public void setImporte(float importe){
        this.importe = importe;
    }

    public Date getFechaPago(){
        return fechaPago;
    }
    public void setFechaPago(Date fecha){
        this.fechaPago = fecha;
    }

    public MetodoPago getMetodoPago(){
        return metodoPago;
    }
    
    public void setMetodoPago(MetodoPago metodoPago){
        this.metodoPago = metodoPago;
    }

    public EstadoVenta getEstado(){
        return estado;
    }
    
    public void setEstado(EstadoVenta estado){
        this.estado = estado;
    }

    public Reserva getReserva(){
        return reserva;
    }
    
    public void setReserva(Reserva reserva){
        this.reserva = reserva;
    }

    public ArrayList<ItemVenta> getItemsVenta(){
        return new ArrayList<>(itemsVenta);
    }
    
    public void setItems(ArrayList<ItemVenta> nuevo){
        itemsVenta = new ArrayList<>(nuevo); 
    }
    
    public Sucursal getSucursal(){return sucursal;}
    public void setSucursal(Sucursal sucursal){this.sucursal = sucursal;}
}
