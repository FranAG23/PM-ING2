package clases_control;
import clases_entidad.ItemVenta;
import clases_entidad.Producto;
import clases_entidad.Venta;
import com.raven.form.ConsultarItemVenta;
import com.raven.form.FormularioConsultarVenta;
import dao.DAOVenta;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogicaConsultarVenta {
    FormularioConsultarVenta formulario; 
    ArrayList<Venta> ventasEncontradas; 
 
    public LogicaConsultarVenta(FormularioConsultarVenta formulario){
        this.formulario = formulario; 
        ventasEncontradas = new ArrayList<>();
    }
    
    public void usuarioQuiereBuscarVenta(Date fecha){
        DAOVenta daoVenta = new DAOVenta();
        int cantidad = 0;
        // Limpiamos los resultados de la búsqueda anterior. 
        formulario.borrarTabla();
        // Esconder cartel de error.
        formulario.esconderAvisoNoHayResultados();
        // Limpiamos la tabla de productos.
        formulario.borrarTablaProductos();
        
        try 
        {
            ventasEncontradas = daoVenta.ObtenerFecha(fecha);
            cantidad = ventasEncontradas.size();
            if(cantidad == 0){
                formulario.avisarNoHayResultados();
            }
            else
            {
                for(int i = 0; i < cantidad; i++){
                    formulario.insertarTabla(ventasEncontradas.get(i));
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(FormularioConsultarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void usuarioQuiereVerMas(int filaSeleccionada){
       DAOVenta daoVenta = new DAOVenta(); 
       int cantidad;
       int idVenta = 0; 
       ArrayList<ItemVenta> Items;
       Producto producto; 
       ItemVenta item; 
       Venta venta; 
       
       // Limpiamos los resultados de la búsqueda anterior. 
       formulario.borrarTablaProductos();
       try 
       {
            // Obtenemos la venta que seleccionó el usuario.
            venta = ventasEncontradas.get(filaSeleccionada);
            // Obtenemos el ID de la venta.
            idVenta = venta.getId(); 
            // OBTENEMOS LOS CAMPOS DE LA FILA SELECCIONADA LA VENTA Y LOS ITEMS  
            Items = daoVenta.getItemsVenta(idVenta);
            cantidad = Items.size();
            for(int i = 0; i < cantidad;i++)
            {
                item = Items.get(i);
                producto = item.getProducto();
                formulario.insertarInfoProducto(item, producto); 
            }
        } catch (SQLException ex) {
            System.out.println("Error en   public void usuarioQuiereVerMas(int idVenta) en clase LogicaConsultarVenta");
            Logger.getLogger(FormularioConsultarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
