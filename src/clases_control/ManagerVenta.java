package clases_control;

import clases_entidad.ItemVenta;
import clases_entidad.Producto;
import clases_entidad.Sucursal;
import clases_entidad.Venta;
import clases_entidad.Venta.EstadoVenta;
import clases_entidad.Venta.MetodoPago;
import clases_entidad.auxiliares.RenglonTablaAltaVenta;
import com.raven.form.FormularioAltaVenta;
import dao.DAOVenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ManagerVenta {
   private DAOVenta daoVenta; 
   private Date Fecha;
    /*
    private javax.swing.JButton botonCompletarVenta;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JCheckBox campoEnvioGratis;
    private javax.swing.JComboBox<String> campoMetodoPago;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> campoSucursal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    */
    
    FormularioAltaVenta formulario;
    
    public ManagerVenta(FormularioAltaVenta formulario) {
        this.formulario = formulario;
          this.daoVenta = new DAOVenta();
    }
    public ManagerVenta(){
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
