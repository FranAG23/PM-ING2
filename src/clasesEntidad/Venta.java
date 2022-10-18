
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
    private float importeTotal;
    private float importeActual; 
    private Date fechaUltimoPago;
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
                    float importeTotal, 
                    float importeActual,
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
        this.importeTotal = importeTotal;
        this.importeActual = importeActual; 
        this.fechaUltimoPago = fecha;
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
        this.id = -1;
        this.nombreCliente = "Indefinido";
        this.apellidoCliente = "Indefinido";
        this.envioGratis = false; 
        this.importeTotal = -1;
        this.importeActual = -1;
        this.fechaUltimoPago = new Date();
        this.metodoPago = MetodoPago.EFECTIVO; 
        this.estado = EstadoVenta.CANCELADA; 
        this.reserva = null; 
        this.sucursal = new Sucursal();
        this.items = new ArrayList<>();
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

    public float getImporteTotal() {return importeTotal;}
    public void setImporteTotal(float importe) {this.importeTotal = importe;}
    
    public float getImporteActual() { return importeActual;}
    public void setImporteActual(float importeActual) { this.importeActual = importeActual;}

    public Date getFechaUltimoPago() {return fechaUltimoPago;}
    public void setFechaUltimoPago(Date fecha) {this.fechaUltimoPago = fecha;}

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
