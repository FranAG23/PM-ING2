
package clases_entidad;

import java.util.ArrayList;

public class Compra extends Egreso {
    
    // Atributos
    
    private String nombreProveedor;
    private ArrayList<ItemCompra> items;
    
    // Getters y Setters
    
    public String getNombreProveedor() {return nombreProveedor;}
    public void setNombreProveedor(String nombreProveedor) {this.nombreProveedor = nombreProveedor;}

    public ArrayList<ItemCompra> getItems() {return items;}
    public void setItems(ArrayList<ItemCompra> items) {this.items = items;}
    
}
