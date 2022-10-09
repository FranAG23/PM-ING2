package dao;

import clases_entidad.Disponibilidad;
import clases_entidad.Producto;
import clases_entidad.Sucursal;
import java.util.ArrayList;

public interface InterfazDAODisponibilidad {
    boolean registrar(Disponibilidad p, int pid);
    
    boolean modificar(Disponibilidad p);
    
    boolean eliminar(int id);
    
    Disponibilidad obtener(int id);
    
   void obtenerDisponibilidadesDeSucursal(Sucursal sucursal, ArrayList<Disponibilidad> disponibilidades);
}
