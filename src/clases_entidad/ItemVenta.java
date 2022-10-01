
package clases_entidad;

public class ItemVenta {
   
    // Atributos
    
    private int id;
    private int cantidad;
    private float precioUnidad;
    private Producto producto;
    
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
