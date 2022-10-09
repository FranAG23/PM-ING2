
package clases_control;

import clases_entidad.Disponibilidad;
import clases_entidad.Producto;
import com.raven.form.FormularioAltaProducto;
import dao.DAOProducto;

public class ManagerProducto {
    
    public boolean alta(FormularioAltaProducto f, Producto p) {
        
        // Hacer alta excepto si p no tiene disponibilidades, el nombre es "", o algún núm. es <0
        
        boolean valido = true;
        
        if (p.getNombre().isBlank()) {
            f.avisarNombreInvalido();
            valido = false;
        }
        
        if (p.getDisponibilidades().isEmpty()) {
            f.avisarNingunaDisponibilidad();
            valido = false;
        }
        
        for (Disponibilidad d : p.getDisponibilidades()) {
            
            if (d.getSucursal().getUbicacion().equals("San Luis")) {
                if (d.getPrecioVenta()<0) {
                    f.avisarPrecioInvalidoSanLuis();
                    valido = false;
                }
                if (d.getStockActual()<0) {
                    f.avisarStockInvalidoSanLuis();
                    valido = false;
                }
                if (d.getTieneStockMinimo() && d.getStockMinimo()<0) {
                    f.avisarStockMinimoInvalidoSanLuis();
                    valido = false;
                }
            }
            else { // Neuquén
                if (d.getPrecioVenta()<0) {
                    f.avisarPrecioInvalidoNeuquen();
                    valido = false;
                }
                if (d.getStockActual()<0) {
                    f.avisarStockInvalidoNeuquen();
                    valido = false;
                }
                if (d.getTieneStockMinimo() && d.getStockMinimo()<0) {
                    f.avisarStockMinimoInvalidoNeuquen();
                    valido = false;
                }
            }
        }
        
        if (valido) {
            
            f.resetCampos();
            f.resetCarteles();
            
            if (new DAOProducto().registrar(p)) {
                f.mostrarCartelAltaExitosa();
                return true;
            }
            else {
                f.mostrarCartelAltaNoExitosa();
            }
        }
        
        return false;
    }
    
}
