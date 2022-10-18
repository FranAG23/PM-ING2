
package clasesEntidad;

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
        this.producto = new Producto(producto);
    }

    public ItemVenta() {
        this.id = -1;
        this.cantidad = -1;
        this.precioUnidad = -1;
        this.producto = new Producto();
    }

    ItemVenta(ItemVenta item) {
        this.id = item.getId();
        this.cantidad = item.getCantidad();
        this.precioUnidad = item.getPrecioUnidad();
        this.producto = item.getProducto(); 
    }
    
    // Getters y Setters
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public float getPrecioUnidad() {return precioUnidad;}
    public void setPrecioUnidad(float precioUnidad) {this.precioUnidad = precioUnidad;}

    public Producto getProducto() {return new Producto(producto);}
    public void setProducto(Producto producto) {this.producto = new Producto(producto);}
}