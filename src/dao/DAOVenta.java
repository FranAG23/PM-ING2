
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
    private final String nombreTablaVentas = "Venta"; 
    private final String nombreTablaItemsVenta = "ItemVenta"; 
    private final int colIDVentaEnVentas = 0;
    private final int colIDSucursal = 1;  
    private final int colNomCliente = 2;
    private final int colApeCliente = 3;
    private final int colEnvioGratis = 4;
    private final int colImporte = 5; 
    private final int colFechaPago = 6; 
    private final int colMetodoPago = 7; 
    private final int colEstadoVenta = 8; 
       
    private final int colIDItemVenta = 0; 
    private final int colIDProducto = 1; 
    private final int colCantidad = 2;
    private final int colPrecioUnidad = 3;
    private final int colIDVentaEnItemsVenta = 4;
    
    private final String queryParaInsertarEnTablaVentas = "INSERT INTO " + nombreTablaVentas + " VALUES (DEFAULT,?,?,?,?,?,?,?,?)"; 
    private final String queryParaGenerarIDVenta = "SELECT CURRVAL('Venta_vID_seq')"; 
    private final String queryParaInsertarEnTablaItemsVenta = "INSERT INTO " + nombreTablaItemsVenta + " VALUES (DEFAULT,?,?,?,?)";
    
    @Override
    public boolean registrar(Venta venta) {
        boolean exito = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        BaseDatos conexionBD = BaseDatos.getInstance(); 
        int IDVenta;
        try {       
            Connection con = BaseDatos.getInstance().establecerConexion();
            
            // En este bloque de código inserto los atributos de venta en la tabla de ventas:
            pst = con.prepareStatement(queryParaInsertarEnTablaVentas);
            if (venta.getSucursal().getUbicacion().equals("San Luis")) {
                pst.setInt(colIDSucursal, 1);
            } else { //Neuquén
                pst.setInt(colIDSucursal, 2);
            }
            pst.setString(colNomCliente, venta.getNombreCliente());
            pst.setString(colApeCliente, venta.getApellidoCliente());
            pst.setBoolean(colEnvioGratis, venta.getEnvioGratis());
            pst.setFloat(colImporte, venta.getImporte());
            pst.setDate(colFechaPago, new java.sql.Date(venta.getFecha().getTime()));
            pst.setString(colMetodoPago, venta.getMetodoPago().toString());
            pst.setString(colEstadoVenta, venta.getEstado().toString());
            pst.executeUpdate();
            
            
            // Aquí recupero el ID de venta generado anteriormente para luego insertarlo en la tabla de items de venta.            
            pst = con.prepareStatement(queryParaGenerarIDVenta);
            rs = pst.executeQuery();
            rs.next();
            IDVenta = rs.getInt(1);
            
            // En este bloque de código inserto cada uno de los items de venta en la tabla de items de venta. 
            for (ItemVenta itemVenta : venta.getItems()) {
                pst = con.prepareStatement(queryParaInsertarEnTablaItemsVenta);
                pst.setInt(colIDProducto, itemVenta.getProducto().getId());
                pst.setInt(colIDVentaEnItemsVenta, IDVenta);
                pst.setInt(colCantidad, itemVenta.getCantidad());
                pst.setFloat(colPrecioUnidad, itemVenta.getPrecioUnidad());
                pst.executeUpdate();
            }
            exito = true;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
            conexionBD.cerrarConexion();
        }
        conexionBD.cerrarConexion();
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
