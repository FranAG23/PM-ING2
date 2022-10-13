package dao;

import clasesEntidad.Disponibilidad;
import clasesEntidad.Producto;
import clasesEntidad.Sucursal;
import java.util.ArrayList;

public interface InterfazDAODisponibilidad {
    boolean registrar(Disponibilidad p, int pid);
    
    boolean modificar(Disponibilidad p);
    
    boolean eliminar(int id);
    
    Disponibilidad obtener(int id);
}
