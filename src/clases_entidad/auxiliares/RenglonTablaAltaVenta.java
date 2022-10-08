package clases_entidad.auxiliares;

public class RenglonTablaAltaVenta {
    private int IDProducto; 
    private String nombreProducto;
    private int cantidad;
    private float precioPorUnidad; 
    
    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(float precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }
}
