
package dao;

import clasesEntidad.Producto;
import clasesEntidad.Sucursal;
import java.util.ArrayList;

public interface InterfazDAOProducto {
    
    boolean registrar(Producto p);
    
    boolean modificar(Producto p);
    
    boolean eliminar(int id);
    
    Producto obtener(int id);
    
    void obtenerProductoPorNombre(Producto buscado, Producto resultado);
    ArrayList<Producto> obtenerProductosConDisponibilidad(Producto buscado, Sucursal sucursal);
    ArrayList<Producto> obtenerProdsConDisp(Producto buscado, Sucursal sucursal);
}
