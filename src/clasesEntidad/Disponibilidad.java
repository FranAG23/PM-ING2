    
package clasesEntidad;

public class Disponibilidad {

    // Atributos

    int id; 
    private float precioVenta;
    private int stockActual;
    private boolean tieneStockMinimo;
    private int stockMinimo;
    private Sucursal sucursal;
    private Producto producto;

    // Constructor

    public Disponibilidad(  float precioVenta, 
                            int stockActual, 
                            boolean tieneStockMinimo, 
                            int stockMinimo, 
                            Sucursal sucursal, 
                            Producto producto   ) {

        this.precioVenta = precioVenta;
        this.stockActual = stockActual;
        this.tieneStockMinimo = tieneStockMinimo;
        this.stockMinimo = stockMinimo;
        this.sucursal = new Sucursal(sucursal);
        this.producto = new Producto(producto);
    }

    public Disponibilidad(){
    }
    
     public Disponibilidad(Disponibilidad disp){
         this.id = disp.getID(); 
         this.precioVenta = disp.precioVenta;
         this.stockActual = disp.stockActual;
         this.tieneStockMinimo = disp.tieneStockMinimo;
         this.stockMinimo = disp.stockMinimo;
         this.sucursal = disp.getSucursal(); 
         this.producto = disp.getProducto(); 
    }
    
    // Getters y Setters
	
    public float getPrecioVenta() {return precioVenta;}
    public void setPrecioVenta(float precioVenta) {this.precioVenta = precioVenta;}

    public int getStockActual() {return stockActual;}
    public void setStockActual(int stockActual) {this.stockActual = stockActual;}

    public int getStockMinimo() {return stockMinimo;}
    public void setStockMinimo(int stockMinimo) {this.stockMinimo = stockMinimo;}

    public boolean getTieneStockMinimo() {return tieneStockMinimo;}
    public void setTieneStockMinimo(boolean tieneStockMinimo) {this.tieneStockMinimo = tieneStockMinimo;}

    public Sucursal getSucursal() {return new Sucursal(sucursal);}
    public void setSucursal(Sucursal sucursal) {this.sucursal = new Sucursal(sucursal);}
    
    public Producto getProducto(){
        return new Producto(producto); 
    }
    public void setProducto(Producto producto){
        this.producto = new Producto(producto);
    }

    public void setID(int id) {
       this.id = id;
    }
    
    public int getID(){
        return id;
    }

}
