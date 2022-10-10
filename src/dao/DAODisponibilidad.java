
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
    public boolean modificar(Disponibilidad disp) {
        boolean exito = false;
        PreparedStatement pst = null;
        Connection con = null;
        BaseDatos instancia = BaseDatos.getInstance(); 
        try {    
            con = instancia.establecerConexion();
            pst = con.prepareStatement("UPDATE Disponibilidad "
                    + "SET dPrecioVenta = ?, dstockActual = ?, dStockMinimo =  ?, dTieneStockMinimo = ?"
                    + "WHERE dId = ?");
            pst.setFloat(1, disp.getPrecioVenta());
            System.out.println("Actualizacion en BD: " +  disp.getStockActual());
            pst.setInt(2, disp.getStockActual()); 
            pst.setInt(3, disp.getStockMinimo());
            pst.setBoolean(4, disp.getTieneStockMinimo());
            pst.setInt(5, disp.getID());
            pst.executeUpdate(); 
            
        } catch (SQLException e){
            System.out.println("Error en public boolean modificar(Disponibilidad disp) de clase DAODisponibilidad");
            e.printStackTrace();
        } finally {
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
        }
        return exito;         
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Disponibilidad obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    } 
}
