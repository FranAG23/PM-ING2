
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

    public Sucursal() {
      
    }
    
    public Sucursal(Sucursal sucursal){
        this.id = sucursal.getID();
        this.ubicacion = sucursal.getUbicacion(); 
    }
    
    // Getters y Setters
    public int getID(){return id;}
    public void setID(int id){this.id = id;}
    public String getUbicacion() {return ubicacion;}
    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}

}
