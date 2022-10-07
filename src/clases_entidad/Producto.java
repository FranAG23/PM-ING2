package clases_entidad;

import java.util.ArrayList;

public class Producto {
    
    // Definición de CategoriaProducto (tipo enumerado)
    
    public enum CategoriaProducto {
        LENCERIA, ACCESORIO, PAPELERIA, MARROQUINERIA, VARIOS;
        @Override
        public String toString() {
            
            return switch (this) {
                case LENCERIA -> "Lencería";
                case ACCESORIO -> "Accesorio";
                case PAPELERIA -> "Papelería";
                case MARROQUINERIA -> "Marroquinería";
                default -> "Varios";
            };
        }
    }
    
    // Atributos
    
    private int id;
    private String nombre; 
    private String descripcion;
    private CategoriaProducto categoria;
    private ArrayList<Disponibilidad> disponibilidades;
    
    // Getters y Setters
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    
    public CategoriaProducto getCategoria() {return categoria;}
    public void setCategoria(CategoriaProducto categoria) {this.categoria = categoria;}

    public ArrayList<Disponibilidad> getDisponibilidades() {return disponibilidades;}
    public void setDisponibilidades(ArrayList<Disponibilidad> disponibilidades) {this.disponibilidades = disponibilidades;}

}
