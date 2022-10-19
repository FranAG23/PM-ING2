
package dataTransferObject;

import clasesEntidad.Producto;

public class ProductoDTO {

    private String nombre; 
    private Producto.CategoriaProducto categoria;
    private int cantidad;

    public ProductoDTO(String nombre, Producto.CategoriaProducto categoria, int cantidad) {
        
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto.CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(Producto.CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
