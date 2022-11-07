package dao;

import clasesEntidad.Reserva;

public interface InterfazDAOReserva {
    boolean registrar(Reserva reserva, int idVenta);
    
    boolean modificar(Reserva reserva);
    
    boolean eliminar(int id);
    
    Reserva obtener(int id);
}
