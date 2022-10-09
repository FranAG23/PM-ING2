
package clases_control;

import clases_entidad.Disponibilidad;
import clases_entidad.Producto;
import clases_entidad.Sucursal;
import com.raven.form.FormularioAltaProducto;
import com.raven.form.FormularioAltaVenta;
import dao.DAOProducto;
import java.util.ArrayList;

public class ManagerProducto {
    DAOProducto daoProducto = null; 
    
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
                f.mostrarCartelAltaFallida();
            }
        }
        
        return false;
    }
    

    public void buscarProductosConStock(FormularioAltaVenta formulario, Producto producto, Sucursal sucursal){
        boolean validacionExitosa = true;
        ArrayList<Producto> listaProductos = new ArrayList<>(); 
        Disponibilidad disp; 
        formulario.limpiarTablaBuscador();
        formulario.esconderErrorBuscadorNombre(); 
        formulario.esconderErrorBuscadorVacio();
      
        
        if(producto.getNombre().isBlank() || producto.getNombre().length() > 30){
            validacionExitosa = false;
            formulario.mostrarErrorBuscadorNombre();
        }  
        
        if(validacionExitosa){
            if(daoProducto == null)
                daoProducto = new DAOProducto(); 
            listaProductos = daoProducto.obtenerProductosConDisponibilidad(producto, sucursal);
            if(listaProductos.isEmpty())
                formulario.mostrarErrorBuscadorVacio();
            else{
                for(Producto prod: listaProductos){
                    disp = prod.getDisponibilidades().get(0);
                    formulario.agregarRenglonTabla(prod, disp);
                }
            }
                
        }
    }
}
