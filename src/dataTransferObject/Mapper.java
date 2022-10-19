
package dataTransferObject;

import clasesEntidad.Producto;
import clasesEntidad.Venta;

public class Mapper {
    
    public static ProductoDTO toProductoDTO(Producto p, int cantVendidos) {
        
        return new ProductoDTO(p.getNombre(),p.getCategoria(),cantVendidos);
    }
    
    public static VentaNotificacionDTO toVentaNotificacionDTO(Venta v) {
        
        return new VentaNotificacionDTO(
            v.getNombreCliente(),
            v.getApellidoCliente(),
            v.getReserva().getTelefonoCliente(),
            v.getImporteActual(),v.getReserva().getFecha()
        );
    }
    
    public static VentaDTO toVentaDTO(Venta v) {
        
        return new VentaDTO(
            v.getNombreCliente(),
            v.getApellidoCliente(),
            v.getImporteTotal(),
            v.getFechaUltimoPago()
        );
    }
}
