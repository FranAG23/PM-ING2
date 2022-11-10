
package clasesEntidad;

import clasesControl.ControladorGenerarNotificacionesFinReserva;
import interfaz.main.Main;
import java.util.Timer;
import java.util.TimerTask;

public class TimerNotificaciones extends Timer {
    
    public TimerNotificaciones(Main main) {
        
        schedule(new TimerTask() {
            @Override
            public void run() {
                new ControladorGenerarNotificacionesFinReserva(main);
            }
        }, 0, 1000 * 60 * 2);  // Se ejecuta cada 2 minutos
    }
    
}
