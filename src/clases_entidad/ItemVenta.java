
package clases_entidad;

public class ItemVenta {
   
    // Atributos
    
    private int id;
    private int cantidad;
    private float precioUnidad;
    private Producto producto;
    
    // Constructor

    public ItemVenta(int id, int cantidad, float precioUnidad, Producto producto) {
        
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.producto = producto;
    }

    public ItemVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Getters y Setters
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public float getPrecioUnidad() {return precioUnidad;}
    public void setPrecioUnidad(float precioUnidad) {this.precioUnidad = precioUnidad;}

    public Producto getProducto() {return producto;}
    public void setProducto(Producto producto) {this.producto = producto;}
}
