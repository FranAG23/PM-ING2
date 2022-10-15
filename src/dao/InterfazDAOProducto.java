
package dao;

import clasesEntidad.Producto;
import clasesEntidad.Sucursal;
import java.util.ArrayList;

public interface InterfazDAOProducto {
    
    boolean registrar(Producto p);
    
    boolean modificar(Producto p);
    
    boolean eliminar(int id);
    
    Producto obtener(int id);
 
}
