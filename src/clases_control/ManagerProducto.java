
package clases_control;

import clases_entidad.Disponibilidad;
import clases_entidad.Producto;
import clases_entidad.Sucursal;
import com.raven.form.FormularioAltaVenta;
import dao.DAOProducto;
import java.util.ArrayList;

public class ManagerProducto {
    
    public ArrayList<Producto> buscarProductosConStock(FormularioAltaVenta formulario, Producto producto, Sucursal sucursal){
        boolean validacionExitosa = true;
        ArrayList<Producto> listaProductos = new ArrayList<>(); 
        Disponibilidad disp; 
        formulario.borrarFilasDeProductos();
        formulario.esconderErrorBuscadorNombre(); 
        formulario.esconderErrorBuscadorVacio();
      
        
        if(producto.getNombre().isBlank() || producto.getNombre().length() > 30){
            validacionExitosa = false;
            formulario.mostrarErrorBuscadorNombre();
        }  
        
        if(validacionExitosa){
            
            listaProductos = new DAOProducto().obtenerProductosConDisponibilidad(producto, sucursal);
            if(listaProductos.isEmpty())
                formulario.advertirNoHayResultados();
            else{
                for(Producto prod: listaProductos){
                    disp = prod.getDisponibilidades().get(0);
                   // formulario.agregarFilaDeProducto(prod, disp);
                }
            }
                
        }
        return listaProductos;
    }
}
