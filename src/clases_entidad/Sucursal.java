
package clases_entidad;

public class Sucursal {
    
    // Definición de Ciudad (tipo enumerado)
    
    public enum Ciudad {
        SAN_LUIS, NEUQUEN;
        @Override
        public String toString() {
            if (this==SAN_LUIS) return "San Luis";
            else return "Neuquén";
        }
    }
    
    // Atributos
    
    private Ciudad ubicacion;
    
    // Getters y Setters
    
    public Ciudad getUbicacion() {return ubicacion;}
    public void setUbicacion(Ciudad ubicacion) {this.ubicacion = ubicacion;}

}
