package clasesControl;

import clasesEntidad.ItemVenta;
import clasesEntidad.Venta;
import interfaz.nuestrosFormularios.FormularioAltaVenta;
import dao.DAOVenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ControladorGenerarInforme {
   private DAOVenta daoVenta; 
   private Date Fecha;

    FormularioAltaVenta formulario;
    
    public ControladorGenerarInforme(FormularioAltaVenta formulario) {
        this.formulario = formulario;
          this.daoVenta = new DAOVenta();
    }
    public ControladorGenerarInforme(){
    this.daoVenta = new DAOVenta();
    }
    
    public ArrayList<Venta> BuscarFecha(Date D) throws SQLException{
        ArrayList<Venta> Ventas;
        Ventas = daoVenta.ObtenerFecha(D);
        return Ventas;
    }
    public ArrayList<ItemVenta> getItemsVenta(int ID) throws SQLException{
        ArrayList<ItemVenta> Items;
        Items = daoVenta.getItemsVenta(ID);
        return Items;
        
    }
  
}
