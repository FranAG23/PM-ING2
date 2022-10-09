
package clases_control;

import clases_entidad.Producto;
import clases_entidad.Sucursal;
import com.raven.form.FormularioAltaVenta;

public class ManagerDisponibilidad {
    public void buscarDisponibilidad(FormularioAltaVenta formulario, Producto producto, Sucursal sucursal){
        boolean validacionExitosa = true;
        formulario.esconderErrorBuscadorNombre(); 
        
        if(producto.getNombre().isBlank() || producto.getNombre().length() > 30){
            validacionExitosa = false;
            formulario.mostrarErrorBuscadorNombre();
        }  
        
    }
}
