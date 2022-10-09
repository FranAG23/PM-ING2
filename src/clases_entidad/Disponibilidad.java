
package clases_entidad;

public class Disponibilidad {

    // Atributos

    private float precioVenta;
    private int stockActual;
    private boolean tieneStockMinimo;
    private int stockMinimo;
    private Sucursal sucursal;

    // Getters y Setters
	
    public float getPrecioVenta() {return precioVenta;}
    public void setPrecioVenta(float precioVenta) {this.precioVenta = precioVenta;}

    public int getStockActual() {return stockActual;}
    public void setStockActual(int stockActual) {this.stockActual = stockActual;}

    public int getStockMinimo() {return stockMinimo;}
    public void setStockMinimo(int stockMinimo) {this.stockMinimo = stockMinimo;}

    public boolean getTieneStockMinimo() {return tieneStockMinimo;}
    public void setTieneStockMinimo(boolean tieneStockMinimo) {this.tieneStockMinimo = tieneStockMinimo;}

    public Sucursal getSucursal() {return sucursal;}
    public void setSucursal(Sucursal sucursal) {this.sucursal = sucursal;}

}
