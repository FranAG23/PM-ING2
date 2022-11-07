package dao;

import clasesEntidad.Disponibilidad;
import java.util.ArrayList;

public interface InterfazDAODisponibilidad {
    boolean registrar(Disponibilidad p, int pid);
    
    boolean modificar(Disponibilidad p);
    
    boolean modificaDisponibilidades(ArrayList<Disponibilidad> disponibilidades);
    
    boolean eliminar(int id);
    
    Disponibilidad obtener(int id);
}
