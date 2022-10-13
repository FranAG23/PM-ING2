
package clasesEntidad;

import java.util.Date;

public class Gasto extends Egreso {
    
    // Atributos
    
    private String nombre;
    private String descripcion;

    public Gasto(   String nombre, 
                    String descripcion, 
                    int id, 
                    float montoTotal, 
                    Date fecha, 
                    Sucursal sucursal   ) {
        
        super(id, montoTotal, fecha, sucursal);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    // Getters y Setters

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    
}
