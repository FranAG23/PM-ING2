
package dao;

import base_datos.BaseDatos;
import clases_entidad.Disponibilidad;
import clases_entidad.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOProducto implements InterfazDAOProducto {

    @Override
    public boolean registrar(Producto p) {
        
        boolean exito = false;
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        int pID;
        
        try {
            
            con = BaseDatos.getInstance().establecerConexion();
            
            // Insertar en tabla Producto
            
            pst = con.prepareStatement("INSERT INTO Producto VALUES (DEFAULT,?,?,?)");
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getCategoria().toString());
            pst.setString(3, p.getDescripcion());
            pst.executeUpdate();
            
            // Obtener ID del producto recién insertado
            
            pst = con.prepareStatement("SELECT CURRVAL('Producto_pID_seq')");
            rs = pst.executeQuery();
            rs.next();
            pID = rs.getInt(1);
            
            // Insertar en tabla Disponibilidad 
            
            exito = true;
            
            for (Disponibilidad d : p.getDisponibilidades()) {

                if (! new DAODisponibilidad().registrar(d, pID)) {
                    exito = false;
                }
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
        }
        
        return exito;
    }

    @Override
    public boolean modificar(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Producto obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
