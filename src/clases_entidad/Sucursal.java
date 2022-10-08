
package clases_entidad;

public class Sucursal {
    private int id; 
    private String ubicacion;
    
    public Sucursal(){
        id = -1;
        ubicacion = "Indefinido";
    }
    
    public Sucursal(int id, String ubicacion){
        this.id = id;
        this.ubicacion = ubicacion;
    }
    
    public Sucursal(Sucursal sucursal){
        this.id = sucursal.getID();
        this.ubicacion = sucursal.getUbicacion();
    }
    
    public String getUbicacion() {return ubicacion;}
    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}

    public int getID() {return id;}
    public void setID(int id){this.id = id;}
}
