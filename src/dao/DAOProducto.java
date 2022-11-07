
package dao;

import baseDatos.BaseDatos;
import clasesEntidad.Disponibilidad;
import clasesEntidad.Producto;
import clasesEntidad.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public ArrayList<Producto> obtengaProductosConDisponibilidad(String nombreProducto, Sucursal sucursal) {
        Producto prod; 
        Disponibilidad disp;
        ArrayList<Disponibilidad> arrDisp; 
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        BaseDatos instanciaBD = BaseDatos.getInstance();
        try {
            con = instanciaBD.establecerConexion();
            
            pst = con.prepareStatement("SELECT * "
                                     + "FROM Producto, Disponibilidad "
                                     + "WHERE Producto.pNombre LIKE ? AND Disponibilidad.sID = ? AND Producto.pid = Disponibilidad.pid "
                                     + "ORDER BY Producto.pID");
            
            pst.setString(1, "%" + nombreProducto + "%");
            pst.setInt(2, sucursal.getID());
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                disp = new Disponibilidad();
                arrDisp = new ArrayList<>();
                prod = new Producto();
                        
                disp.setID(rs.getInt(5));
                disp.setProducto(prod);
                disp.setSucursal(sucursal);  
                disp.setPrecioVenta(rs.getFloat(8));
                disp.setStockActual(rs.getInt(9));
                disp.setStockMinimo(rs.getInt(10));
                disp.setTieneStockMinimo(rs.getBoolean(11));
                
                arrDisp.add(disp);
                        
                prod.setId(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setCategoria(Producto.strAEnumCategoria(rs.getString(3)));
                prod.setDescripcion(rs.getString(4));
                prod.setDisponibilidades(arrDisp);
                
                listaProductos.add(prod);
            }
        } 
        catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } 
        finally 
        {
            try { 
                if (rs != null) 
                    rs.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            try 
            { 
                if (pst != null) 
                    pst.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return listaProductos;
    }
    
}
