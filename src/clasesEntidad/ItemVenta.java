
package clasesEntidad;

public class ItemVenta {
   
    // Atributos
    
    private int id;
    private int cantidad;
    private float precioUnidad;
    private float precioProducto; 
    private Producto producto;
    
    public ItemVenta(int id, int cantidad, float precioUnidad, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.producto = new Producto(producto);
        this.precioProducto = cantidad * precioUnidad;
    }

    public ItemVenta() {
        id = -1;
        cantidad = -1;
        precioUnidad = -1;
        producto = new Producto();
        precioProducto = 0; 
    }

    ItemVenta(ItemVenta item) {
        this.id = item.getId();
        this.cantidad = item.getCantidad();
        this.precioUnidad = item.getPrecioUnidad();
        this.producto = item.getProducto(); 
    }
    

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public float getPrecioUnidad(){
        return precioUnidad;
    }
    
    public void setPrecioUnidad(float precioUnidad){
        this.precioUnidad = precioUnidad;
    }
    
    public void setPrecioProducto(float precioProd){
        this.precioProducto = precioProd;
    }
    
    public float getPrecioProducto(){
        return precioProducto; 
    }

    public Producto getProducto(){  
        return producto;
    }
    
    public void setProducto(Producto producto){
        this.producto = producto; 
    }
}
