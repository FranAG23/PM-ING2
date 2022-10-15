package dao;

import clasesEntidad.Disponibilidad;

public interface InterfazDAODisponibilidad {
    boolean registrar(Disponibilidad p, int pid);
    
    boolean modificar(Disponibilidad p);
    
    boolean eliminar(int id);
    
    Disponibilidad obtener(int id);
}
