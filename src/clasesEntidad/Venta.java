
package clasesEntidad;

import java.util.ArrayList;
import java.util.Date;

public class Venta {
   
    public enum MetodoPago {
        EFECTIVO, MERCADOPAGO;
        @Override
        public String toString() {
            if (this==EFECTIVO) return "Efectivo";
            else return "MercadoPago";
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
    private float importeTotal;
    private float importeActual; 
    private Date fechaUltimoPago;
    private MetodoPago metodoPago;
    private EstadoVenta estado;
    private Reserva reserva;
    private ArrayList<ItemVenta> items;
    private Sucursal sucursal;
    
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
        this.sucursal = sucursal;
        this.items = new ArrayList<>();
        for(ItemVenta item: items){
            this.items.add(item);
        }
    }
    
    public Venta() {
        this.id = -1;
        this.nombreCliente = "Indefinido";
        this.apellidoCliente = "Indefinido";
        this.envioGratis = false; 
        this.importeTotal = 0;
        this.importeActual = 0;
        this.fechaUltimoPago = new Date();
        this.metodoPago = MetodoPago.EFECTIVO; 
        this.estado = EstadoVenta.CANCELADA; 
        this.reserva = null; 
        this.sucursal = new Sucursal();
        this.items = new ArrayList<>();
    }
    
    public int getId(){
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

    public float getImporteTotal(){
        return importeTotal;
    }
    
    public void setImporteTotal(float importe){
        this.importeTotal = importe;
    }
    
    public float getImporteActual(){
        return importeActual;
    }
    
    public void setImporteActual(float importeActual){
        this.importeActual = importeActual;
    }

    public Date getFechaUltimoPago(){
        return fechaUltimoPago;
    }
    
    public void setFechaUltimoPago(Date fecha){
        this.fechaUltimoPago = fecha;
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

    public void setReserva(Reserva reserva){
        this.reserva = reserva; 
    }
    
    public Reserva getReserva(){
        return new Reserva(reserva);
    }
    
    public ArrayList<ItemVenta> getItems(){
        ArrayList<ItemVenta> retorno = new ArrayList();
        for(ItemVenta item: items){
            retorno.add(item);
        }
        return retorno; 
    }
    
    public void setItems(ArrayList<ItemVenta> items){
        this.items = new ArrayList<>();
        for(ItemVenta item: items){
            this.items.add(item);
        }
    }
    
    public Sucursal getSucursal(){
        return sucursal;
    }
    
    public void setSucursal(Sucursal sucursal){
        this.sucursal = sucursal;
    }
    
    public boolean tieneProducto(Producto prod){
        boolean encontrado = false;
        for(ItemVenta item: items){
            if(item.getProducto().getId() == prod.getId()){
                encontrado = true; 
                break;
            }        
        }
        return encontrado; 
    }
    
    public ItemVenta agregueItem(int unidades, float precioVenta, Producto producto){
        ItemVenta itemAgregado = new ItemVenta();
        itemAgregado.setCantidad(unidades);
        itemAgregado.setPrecioUnidad(precioVenta);
        itemAgregado.setPrecioProducto( precioVenta * unidades);
        itemAgregado.setProducto(producto); 
        importeTotal += precioVenta * unidades; 
        items.add(itemAgregado);
        return itemAgregado; 
    }
    
    public void elimineItem(int posicion){
        ItemVenta item = items.get(posicion);
        importeTotal -= item.getPrecioProducto(); 
        items.remove(posicion);
    }
    
    public boolean noTieneItems(){
        return items.isEmpty(); 
    }
    
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
