
package dao;

import base_datos.BaseDatos;
import clases_entidad.ItemVenta;
import clases_entidad.Producto;
import clases_entidad.Reserva;
import clases_entidad.Venta;
import clases_entidad.auxiliares.ItemLista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DAOVenta implements InterfazDAOVenta {

    @Override
    public boolean registrar(Venta v) {
        
        boolean exito = false;
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        int vID;
        
        try {
            con = BaseDatos.getInstance().establecerConexion();
            
            // Insertar en tabla Venta
            
            pst = con.prepareStatement("INSERT INTO Venta VALUES (DEFAULT,?,?,?,?,?,?)");
            pst.setString(1, v.getNombreCliente());
            pst.setBoolean(2, v.getEnvioGratis());
            pst.setFloat(3, v.getImporte());
            pst.setDate(4, new java.sql.Date(v.getFecha().getTime()));
            pst.setString(5, v.getMetodoPago().toString());
            pst.setString(6, v.getEstado().toString());
            pst.executeUpdate();
            
            // Obtener el ID de la venta recién insertada
            
            pst = con.prepareStatement("SELECT CURRVAL('Venta_vID_seq')");
            rs = pst.executeQuery();
            rs.next();
            vID = rs.getInt(1);
            
            // Insertar en tabla ItemVenta
                    
            for (ItemVenta i : v.getItems()) {
                
                pst = con.prepareStatement("INSERT INTO ItemVenta VALUES (DEFAULT,?,?,?,?)");
                // En cada item de v debe venir su producto con su ID
                pst.setInt(1, i.getProducto().getId());
                pst.setInt(2, i.getCantidad());
                pst.setFloat(3, i.getPrecioUnidad());
                pst.setInt(4, vID);
                pst.executeUpdate();
            }
            
            exito = true;
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
        }
        
        return exito;
    }

    @Override
    public boolean modificar(Venta v) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Venta obtener(int id) {
        
        Venta v = new Venta();
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        
        try {
            con = BaseDatos.getInstance().establecerConexion();
            
            // Obtener datos de tabla Venta
            
            pst = con.prepareStatement("SELECT * FROM Venta WHERE (vID = ?)");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                v.setId(rs.getInt("vID"));
                v.setNombreCliente(rs.getString("vNombreCliente"));
                v.setEnvioGratis(rs.getBoolean("vEnvioGratis"));
                v.setImporte(rs.getFloat("vImporte"));
                v.setFecha(new java.util.Date(rs.getDate("vFecha").getTime()));
                if (rs.getString("vMetodoPago").equals("Efectivo")) {
                    v.setMetodoPago(Venta.MetodoPago.EFECTIVO);
                } 
                else {
                    v.setMetodoPago(Venta.MetodoPago.MERCADOPAGO);
                }
                switch (rs.getString("vEstadoVenta")) {
                    case "Completada": v.setEstado(Venta.EstadoVenta.COMPLETADA);
                    case "En reserva": v.setEstado(Venta.EstadoVenta.EN_RESERVA);
                    default: v.setEstado(Venta.EstadoVenta.CANCELADA);
                }
            }
            
            // Obtener Reserva (si la hay)
            
            pst = con.prepareStatement("SELECT * FROM Reserva WHERE (vID = ?)");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                Reserva r = new Reserva();
                r.setTelefonoCliente(rs.getLong("rTelefonoCliente"));
                r.setSeña(rs.getFloat("rSeña"));
                r.setFecha(new java.util.Date(rs.getDate("rFecha").getTime()));
                v.setReserva(r);
            }
            
            // Obtener datos de tabla ItemVenta
            
            pst = con.prepareStatement("SELECT * FROM ItemVenta WHERE (vID = ?)");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            ArrayList<ItemVenta> ai = new ArrayList<>();
            while (rs.next()) {
                ItemVenta i = new ItemVenta();
                i.setId(rs.getInt("ivID"));
                i.setCantidad(rs.getInt("ivCantidad"));
                i.setPrecioUnidad(rs.getFloat("ivPrecioUnidad"));
                ai.add(i);
            }
            v.setItems(ai);
            
            // Obtener ID y nombre de producto de cada ItemVenta
            
            for (ItemVenta i : v.getItems()) {
                
                pst = con.prepareStatement("SELECT Producto.pID, pNombre FROM ItemVenta, Producto WHERE"+
                                            " (ivID = ? and ItemVenta.pID = Producto.pID)");
                pst.setInt(1, i.getId());
                rs = pst.executeQuery();
                
                Producto p = new Producto();
                p.setId(rs.getInt("pID"));
                p.setNombre(rs.getString("pNombre"));
                i.setProducto(p);
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
        }
        
        return v;
    }
    
    // FALTAN IMPLEMENTAR (Elegir cuál para el caso de uso Consultar Venta) : 
    
    public ArrayList<ItemLista> obtenerTodas() {
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public ArrayList<ItemLista> obtenerPorFecha(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
