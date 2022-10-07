
package dao;

import clases_entidad.Producto;
import java.util.ArrayList;

public interface InterfazDAOProducto {
    
    boolean registrar(Producto p);
    
    boolean modificar(Producto p);
    
    boolean eliminar(int id);
    
    Producto obtener(int id);
    ArrayList<Producto> obtener(String Nombre);
}
