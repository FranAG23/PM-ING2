
package clasesEntidad;

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
    private String apellidoCliente;
    private boolean envioGratis;
    private float importe;
    private Date fecha;
    private MetodoPago metodoPago;
    private EstadoVenta estado;
    private Reserva reserva;
    private ArrayList<ItemVenta> items;
    private Sucursal sucursal;
    
    // Constructor

    public Venta(   int id, 
                    String nombreCliente,
                    String apellidoCliente, 
                    boolean envioGratis, 
                    float importe, 
                    Date fecha, 
                    MetodoPago metodoPago, 
                    EstadoVenta estado, 
                    Reserva reserva, 
                    ArrayList<ItemVenta> items, 
                    Sucursal sucursal   ) {
        
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.envioGratis = envioGratis;
        this.importe = importe;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.reserva = reserva;
        this.sucursal = new Sucursal(sucursal);
        this.items = new ArrayList<>();
        for(ItemVenta item: items){
            this.items.add(new ItemVenta(item));
        }
    }
    
    public Venta() {
        
    }
    
    // Getters y Setters
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNombreCliente() {return nombreCliente;}
    public void setNombreCliente(String nombreCliente) {this.nombreCliente = nombreCliente;}
    
    public String getApellidoCliente() {return apellidoCliente;}
    public void setApellidoCliente(String apellidoCliente) {this.apellidoCliente = apellidoCliente;}

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

    public Reserva getReserva() {return new Reserva(reserva);}
    public void setReserva(Reserva reserva) {this.reserva = new Reserva(reserva);}
    
    public ArrayList<ItemVenta> getItems(){ 
        ArrayList<ItemVenta> copia = new ArrayList<>();
        for(ItemVenta item: items){
            copia.add(new ItemVenta(item));
        }
        return copia; 
    }
   
    public void setItems(ArrayList<ItemVenta> items){
        this.items = new ArrayList<>();
        for(ItemVenta item: items){
            this.items.add(new ItemVenta(item));
        }
    }
    
    public Sucursal getSucursal() {return new Sucursal(sucursal);}
    public void setSucursal(Sucursal sucursal) {this.sucursal = new Sucursal(sucursal);}
    
    // Otros métodos
    public static MetodoPago stringAMetodoPago(String str){
        MetodoPago retorno = null; 
        if("Efectivo".equals(str)){
           retorno = MetodoPago.EFECTIVO;
        }
        else if("MercadoPago".equals(str)){
           retorno = MetodoPago.MERCADOPAGO; 
        }
        return retorno; 
    }
}
