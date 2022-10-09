
package clases_entidad;

public class Sucursal {
    
    // Atributos
    int id;
    private String ubicacion;
    
    // Constructor

    public Sucursal(String ubicacion) {
        
        this.ubicacion = ubicacion;
    }
    
    public Sucursal(int id, String ubicacion) {
        this.id = id; 
        this.ubicacion = ubicacion;
    }
    
    // Getters y Setters
    public int getID(){return id;}
    public int setID(){return id;}
    public String getUbicacion() {return ubicacion;}
    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}

}
