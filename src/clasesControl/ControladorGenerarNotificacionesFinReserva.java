package clasesControl;

import dao.DAOVenta;
import dataTransferObject.VentaNotificacionDTO;
import interfaz.main.Main;
import java.util.ArrayList;
import java.util.Date;

public class ControladorGenerarNotificacionesFinReserva {
    
    public static final int DIAS_LIMITE_RESERVA = 15;
    public static final int MILISEGUNDOS_EN_UN_DIA = 86400000;
    
    public ControladorGenerarNotificacionesFinReserva(Main m) {
        
        // Obtener Ventas con Reserva (En estado EN_RESERVA)
        ArrayList<VentaNotificacionDTO> ventas = new DAOVenta().ObtenerVentasConReserva();
        
        // Obtener fecha actual
        Date fechaActual = new Date(System.currentTimeMillis());
        
        for (VentaNotificacionDTO v : ventas) {
            
            // Comprobar si alguna reserva se venció
            if (v.getFechaReserva().getTime() + DIAS_LIMITE_RESERVA*MILISEGUNDOS_EN_UN_DIA < 
                fechaActual.getTime()) {
                
                // Actualizar estado en base de datos (Cancelada) y poner la fecha actual en vFecha
                new DAOVenta().cancelarVenta(v.getId(), fechaActual);
                
                // Generar notificación en el panel Main
                m.generarNotificacionFinReserva(v);
                
            } else {
                
                // Comprobar si alguna reserva está a menos de un día de vencerse
                if (v.getFechaReserva().getTime() + (DIAS_LIMITE_RESERVA-1)*MILISEGUNDOS_EN_UN_DIA < 
                fechaActual.getTime()) {
                    
                    m.generarAdvertenciaFinReserva(v);
                }
            }
        }
    }
}
