
package clasesEntidad;

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

    // Constructor
    
    public Producto(    int id, 
                        String nombre, 
                        String descripcion, 
                        CategoriaProducto categoria, 
                        ArrayList<Disponibilidad> disponibilidades  ) {
        
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.disponibilidades = new ArrayList<>();
        for(Disponibilidad disp: disponibilidades){
            this.disponibilidades.add(new Disponibilidad(disp)); 
        }
    }
    
    public Producto(Producto producto){
        this.id = producto.getId(); 
        this.nombre = producto.getNombre();
        this.descripcion =  producto.getDescripcion();
        this.categoria = producto.getCategoria();
        disponibilidades = producto.getDisponibilidades(); 
    }
    
    public Producto(){
        this.id = -1;
        this.nombre = "";
        this.descripcion = "";
        this.categoria = CategoriaProducto.ACCESORIO;
        this.disponibilidades = new ArrayList();
    }
    
    // Getters y Setters
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    
    public CategoriaProducto getCategoria() {return categoria;}
    public void setCategoria(CategoriaProducto categoria) {this.categoria = categoria;}

    public ArrayList<Disponibilidad> getDisponibilidades(){
        ArrayList<Disponibilidad> copia = new ArrayList();
        for(Disponibilidad disp: disponibilidades){
            copia.add(new Disponibilidad(disp)); 
        }
        return copia;
    }
    
    public void setDisponibilidades(ArrayList<Disponibilidad> disponibilidades){
        this.disponibilidades = new ArrayList<>();
        for(Disponibilidad disp: disponibilidades){
            this.disponibilidades.add(new Disponibilidad(disp)); 
        }
    }

    // Otros metodos
    
    public static CategoriaProducto strAEnumCategoria(String str){
        CategoriaProducto retorno; 
        retorno = switch (str) {
            case "Lencería" -> CategoriaProducto.LENCERIA;
            case "Accesorio" -> CategoriaProducto.ACCESORIO;
            case "Papelería" -> CategoriaProducto.PAPELERIA;
            case "Marroquinería" -> CategoriaProducto.MARROQUINERIA;
            default -> CategoriaProducto.VARIOS;
        };
        return retorno; 
    }
}
