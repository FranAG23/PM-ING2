
package dao;

import clases_entidad.Venta;

public interface InterfazDAOVenta {
    
    boolean registrar(Venta v);
    
    boolean modificar(Venta v);
    
    boolean eliminar(int id);
    
    Venta obtener(int id);
    
}
