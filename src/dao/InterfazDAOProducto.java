package dao;

import clasesEntidad.Producto;

public interface InterfazDAOProducto {
    
    boolean registrar(Producto p);
    
    boolean modificar(Producto p);
    
    boolean eliminar(int id);
    
    Producto obtener(int id);
 
}
