
package clasesControl;

import clasesEntidad.Venta;
import dao.DAOVenta;
import interfaz.main.Main;
import java.util.ArrayList;
import java.util.Date;

public class ControladorGenerarNotificacionesFinReserva {
    
    public static final int DIAS_LIMITE_RESERVA = 15;
    public static final int MILISEGUNDOS_EN_UN_DIA = 86400000;
    
    public ControladorGenerarNotificacionesFinReserva(Main m) {
        
        // Obtener Ventas con Reserva (En estado EN_RESERVA)
        ArrayList<Venta> ventas = new DAOVenta().ObtenerVentasConReserva();
        
        // Obtener fecha actual
        Date fechaActual = new Date(System.currentTimeMillis());
        
        // Comprobar si alguna reserva está vencida y generar notificaciones
        for (Venta v : ventas) {
            if (v.getReserva().getFecha().getTime() + DIAS_LIMITE_RESERVA*MILISEGUNDOS_EN_UN_DIA >= 
                fechaActual.getTime()) {
                
                // Actualizar estado en base de datos (Cancelada) y poner la fecha actual en vFecha
                new DAOVenta().cancelarVenta(v.getId(), fechaActual);
                
                // Generar notificación en el panel Main
                m.generarNotificacionFinReserva(v);
            }
        }
    }
}
