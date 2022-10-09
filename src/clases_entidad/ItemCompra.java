
package clases_entidad;

public class ItemCompra {
    
    // Atributos
    
    private int id;
    private int cantidad;
    private float costoUnidad;
    private Producto producto;
    
    // Constructor

    public ItemCompra(int id, int cantidad, float costoUnidad, Producto producto) {
        
        this.id = id;
        this.cantidad = cantidad;
        this.costoUnidad = costoUnidad;
        this.producto = producto;
    }
    
    // Getters y Setters
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public float getCostoUnidad() {return costoUnidad;}
    public void setCostoUnidad(float costoUnidad) {this.costoUnidad = costoUnidad;}

    public Producto getProducto() {return producto;}
    public void setProducto(Producto producto) {this.producto = producto;}
    
}
