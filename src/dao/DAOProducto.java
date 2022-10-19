
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
    
    public ArrayList<Producto> obtenerProductosConDisponibilidad(String nombreProducto, int idSucursal) {
        
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        BaseDatos instanciaBD = BaseDatos.getInstance();
        Producto prodTemp; 
        Disponibilidad dispTemp;
        ArrayList<Disponibilidad> arrDisp; 
        ArrayList<Producto> listaProductos = new ArrayList<>();

        try {
            // Establecer conexión con la base de datos. 
            con = instanciaBD.establecerConexion();
            
            // Obtener productos con nombre similar a buscado, y tambien sus disponibilidades
            // en sucursal. 
            pst = con.prepareStatement("SELECT * "
                                     + "FROM Producto, Disponibilidad "
                                     + "WHERE Producto.pNombre LIKE ? AND Disponibilidad.sID = ? AND Producto.pid = Disponibilidad.pid "
                                     + "ORDER BY Producto.pID");
            pst.setString(1, nombreProducto + "%");
            pst.setInt(2, idSucursal);
            rs = pst.executeQuery();
            
            // Si se obtuve un resultado, entonces construir objetos productos:
            while (rs.next()) {
                prodTemp = new Producto();
                dispTemp = new Disponibilidad();
                arrDisp = new ArrayList<>();
                
                // Construir objeto disponibilidad:
                dispTemp.setID(rs.getInt(5));
                dispTemp.setProducto(prodTemp);
                if (idSucursal==1) {
                    dispTemp.setSucursal(new Sucursal("San Luis")); 
                } else {
                    dispTemp.setSucursal(new Sucursal("Neuquén")); 
                }
                dispTemp.setPrecioVenta(rs.getFloat(8));
                dispTemp.setStockActual(rs.getInt(9));
                dispTemp.setStockMinimo(rs.getInt(10));
                dispTemp.setTieneStockMinimo(rs.getBoolean(11));
                
                // Construir arreglo de disponibilidades:
                arrDisp.add(dispTemp);
                        
                // Construir objeto produto:
                prodTemp.setId(rs.getInt(1));
                prodTemp.setNombre(rs.getString(2));
                prodTemp.setCategoria(Producto.strAEnumCategoria(rs.getString(3)));
                prodTemp.setDescripcion(rs.getString(4));
                prodTemp.setDisponibilidades(arrDisp);
                
                // Agregar producto a resultado:
                listaProductos.add(prodTemp);
            }
        } catch (SQLException e){
            System.out.println("Error en public public void obtenerProductosConDisponibilidad(Producto buscado, "
                    + " Sucursal sucursal, ArrayList<Producto> listaProductos) de clase DAOProducto");
            
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
        }
        return listaProductos;
    }
    
}
