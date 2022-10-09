
package dao;

import base_datos.BaseDatos;
import clases_entidad.Disponibilidad;
import clases_entidad.Producto;
import clases_entidad.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAODisponibilidad implements InterfazDAODisponibilidad{
    
    @Override
    public boolean registrar(Disponibilidad d, int pid) {
        
        boolean exito = false;
        PreparedStatement pst = null;
        Connection con = null;
        
        try {
            
            con = BaseDatos.getInstance().establecerConexion();
        
            pst = con.prepareStatement("INSERT INTO Disponibilidad VALUES (DEFAULT,?,?,?,?,?,?)");
            pst.setInt(1, pid);
            if (d.getSucursal().getUbicacion().equals("San Luis")) {
                // Si está disponible en San Luis (sID = 1)
                pst.setInt(2,1);
            } else {
                // Si está disponible en Neuquén (sID = 2)
                pst.setInt(2,2);
            }
            pst.setFloat(3, d.getPrecioVenta());
            pst.setInt(4,d.getStockActual());
            pst.setInt(5, d.getStockMinimo());
            pst.setBoolean(6, d.getTieneStockMinimo());
            pst.executeUpdate();
            
            exito = true;
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
        }
        
        return exito;
    }

    @Override
    public boolean modificar(Disponibilidad d) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Disponibilidad obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void obtenerDisponibilidadesProductos(Sucursal sucursal, ArrayList<Disponibilidad> disponibilidades){
        disponibilidades = new ArrayList<>();
        Disponibilidad disponibilidad; 
        PreparedStatement pst = null;
        ResultSet rs = null;
        BaseDatos instanciaBD = BaseDatos.getInstance();
        Connection con = null;
        try {
            // Establecer conexión con base de datos.
            con = instanciaBD.establecerConexion();
           
            // Obtener todas las disponibilidades correspondientes a sucursal, 
            // ordenadas por id del producto.
            pst = con.prepareStatement("SELECT * " + 
                                       "FROM Disponibilidad " +
                                       "WHERE sID = ? "
                                     + "ORDER BY pID"); 
            pst.setInt(1, sucursal.getID());
            pst.executeUpdate();
            rs = pst.executeQuery();
            
            // Construir disponibilidades. 
            while(rs.next()){
                disponibilidad = new Disponibilidad(); 
                disponibilidad.setID(rs.getInt(0));
                
                disponibilidades.add(disponibilidad);
            }
            instanciaBD.cerrarConexion();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
             instanciaBD.cerrarConexion();
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
        }
    }

    @Override
    public void obtenerDisponibilidadesDeSucursal(Sucursal sucursal, ArrayList<Disponibilidad> disponibilidades) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
