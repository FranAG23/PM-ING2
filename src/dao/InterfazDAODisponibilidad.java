
package dao;

import clases_entidad.Disponibilidad;

public interface InterfazDAODisponibilidad {
    
    boolean registrar(Disponibilidad d, int pid);    // ID del producto 
    
    boolean modificar(Disponibilidad d);
    
    boolean eliminar(int id);
    
    Disponibilidad obtener(int id);
    
}
