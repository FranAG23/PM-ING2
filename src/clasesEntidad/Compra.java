package clasesEntidad;

import java.util.ArrayList;
import java.util.Date;

public class Compra extends Egreso {
    
    // Atributos
    
    private String nombreProveedor;
    private ArrayList<ItemCompra> items;
    
    // Constructor

    public Compra(  String nombreProveedor, 
                    ArrayList<ItemCompra> items, 
                    int id, 
                    float montoTotal, 
                    Date fecha, 
                    Sucursal sucursal   ) {
        
        super(id, montoTotal, fecha, sucursal);
        this.nombreProveedor = nombreProveedor;
        this.items = items;
    }
    
    // Getters y Setters
    
    public String getNombreProveedor() {return nombreProveedor;}
    public void setNombreProveedor(String nombreProveedor) {this.nombreProveedor = nombreProveedor;}

    public ArrayList<ItemCompra> getItems() {return items;}
    public void setItems(ArrayList<ItemCompra> items) {this.items = items;}
    
}