
package dao;

import baseDatos.BaseDatos;
import clasesEntidad.ItemVenta;
import clasesEntidad.Producto;
import static clasesEntidad.Producto.CategoriaProducto.ACCESORIO;
import static clasesEntidad.Producto.CategoriaProducto.LENCERIA;
import static clasesEntidad.Producto.CategoriaProducto.MARROQUINERIA;
import static clasesEntidad.Producto.CategoriaProducto.PAPELERIA;
import static clasesEntidad.Producto.CategoriaProducto.VARIOS;
import clasesEntidad.Venta;
import dataTransferObject.VentaNotificacionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DAOVenta implements InterfazDAOVenta 
{    
    private final String nombreTablaVentas = "Venta"; 
    private final String nombreTablaItemsVenta = "ItemVenta"; 
    private final int colIDVentaEnVentas = 0;
    private final int colIDSucursal = 1;  
    private final int colNomCliente = 2;
    private final int colApeCliente = 3;
    private final int colEnvioGratis = 4;
    private final int colImporteTotal = 5; 
    private final int colImporteActual = 6;
    private final int colFechaUltimoPago = 7; 
    private final int colMetodoPago = 8; 
    private final int colEstadoVenta = 9; 
       
    private final int colIDItemVenta = 0; 
    private final int colIDProducto = 1; 
    private final int colCantidad = 2;
    private final int colPrecioUnidad = 3;
    private final int colIDVentaEnItemsVenta = 4;
     
    private final String queryParaObtenerVentaxFecha = "SELECT * FROM venta WHERE (vfechaUltimoPago = ?)";
    private final String queryParaObtenerItemsVenta = "SELECT * FROM itemventa WHERE (vid = ?)";
    private final String queryParaObtenerProductosItemVenta = "SELECT producto.pid, pnombre, pcategoria, pdescripcion FROM itemventa, producto WHERE(ivid = ?) AND (itemventa.pid = producto.pid)";
    
    @Override
    public boolean registrar(Venta venta){      
        boolean exito = false;
        int IDVenta;
        PreparedStatement pst = null;
        ResultSet rs = null;
        BaseDatos conexionBD = BaseDatos.getInstance();
        
        try{       
            Connection con = conexionBD.establecerConexion();
            
            pst = con.prepareStatement("INSERT INTO Venta VALUES (DEFAULT,?,?,?,?,?,?,?,?,?)");
           
            pst.setInt(1, venta.getSucursal().getID());
            pst.setString(2, venta.getNombreCliente());
            pst.setString(3, venta.getApellidoCliente());
            pst.setBoolean(4, venta.getEnvioGratis());
            pst.setFloat(5, venta.getImporteTotal());
            pst.setFloat(6, venta.getImporteActual()); 
            pst.setDate(7, new java.sql.Date(venta.getFechaUltimoPago().getTime()));
            pst.setString(8, venta.getMetodoPago().toString());
            pst.setString(9, venta.getEstado().toString());
           
            pst.executeUpdate();
                       
            // En este bloque de código recuperamos el ID generado para la venta 
            // que se acaba de dar de alta. Necesitamos este ID para dar de alta
            // cada uno de los items de venta dentro de la tabla ItemVenta. 
            pst = con.prepareStatement("SELECT CURRVAL('Venta_vID_seq')");
            rs = pst.executeQuery();
            rs.next();
            IDVenta = rs.getInt(1);
            
            for (ItemVenta itemVenta : venta.getHandlerItems()){
                pst = con.prepareStatement("INSERT INTO ItemVenta VALUES (DEFAULT,?,?,?,?)");
              
                pst.setInt(1, itemVenta.getHandlerProducto().getId());
                pst.setInt(2, itemVenta.getCantidad());
                pst.setFloat(3, itemVenta.getPrecioUnidad());
                pst.setInt(4, IDVenta);
               
                pst.executeUpdate();
            }
            
            // Actualizamos el objeto venta con el nuevo ID generado por 
            // la base de datos. 
            venta.setId(IDVenta);  
            
            exito = true;
        } 
        catch (SQLException e){
            System.out.println(e.getMessage()); 
            e.printStackTrace();
        } 
        finally
        {
            conexionBD.cerrarConexion();
            try
            {
                if (rs != null) 
                    rs.close();
            }
            catch (SQLException e) {
                System.out.println(e.getMessage()); 
                e.printStackTrace();
            }
            try 
            { 
                if (pst != null) 
                    pst.close();
            } 
            catch (SQLException e) 
            {
                System.out.println(e.getMessage()); 
                e.printStackTrace();
            }
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Venta> ObtenerPorFecha(Date D) throws SQLException {
        
        ArrayList<Venta> Ventas = new ArrayList<Venta>();
        PreparedStatement pst = null;
        ResultSet rsVenta = null;
        ResultSet rsItemVenta = null;
        BaseDatos conexionBD = BaseDatos.getInstance(); 
        conexionBD.establecerConexion();
        Connection con;
        con = conexionBD.establecerConexion();
        pst = con.prepareStatement(queryParaObtenerVentaxFecha);
        // BASE DE DATOS NUEVA pst.setDate(colFechaPago, new java.sql.Date(D.getTime()));
        pst.setDate(1, new java.sql.Date(D.getTime()));
        rsVenta = pst.executeQuery();
        
        while(rsVenta.next()) {
            Venta V = new Venta();
            V.setId(rsVenta.getInt("vid"));
            V.setNombreCliente(rsVenta.getString("vnombrecliente"));
            V.setApellidoCliente(rsVenta.getString("vapellidocliente"));
            V.setEnvioGratis(rsVenta.getBoolean("venviogratis"));
            V.setImporteTotal(rsVenta.getFloat("vimporteTotal"));
            V.setFechaUltimoPago(new java.util.Date(rsVenta.getDate("vfechaUltimoPago").getTime()));
            if (rsVenta.getString("vmetodopago").equals("Efectivo")) {
                V.setMetodoPago(Venta.MetodoPago.EFECTIVO);
            } 
            else {
                V.setMetodoPago(Venta.MetodoPago.MERCADOPAGO);
            }
            if(rsVenta.getString("vestadoventa").equals("Completada")) {
                V.setEstado(Venta.EstadoVenta.COMPLETADA);
                }
                    else{
                       if(rsVenta.getString("vestadoventa").equals("Cancelada")){
                        V.setEstado(Venta.EstadoVenta.CANCELADA);
                        }
                        else
                           V.setEstado(Venta.EstadoVenta.EN_RESERVA);
                        }


            // OBTENGO Y GUARDO LOS ITEM VENTA
            ArrayList<ItemVenta> ai = new ArrayList<>();
            pst = con.prepareStatement(queryParaObtenerItemsVenta);
            pst.setInt(1, V.getId());
            rsItemVenta = pst.executeQuery();

            while (rsItemVenta.next()) {
                ItemVenta i = new ItemVenta();
                i.setId(rsItemVenta.getInt("ivid"));
                i.setCantidad(rsItemVenta.getInt("ivcantidad"));
                i.setPrecioUnidad(rsItemVenta.getFloat("ivpreciounidad"));

                    ai.add(i);
            }
            
            V.setItems(ai);
            Ventas.add(V);
        }
        return Ventas;
 }
 
    public ArrayList<ItemVenta> getItemsVenta(int IDV) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rsItemVenta = null;
        ResultSet rsProductos = null;
        BaseDatos conexionBD = BaseDatos.getInstance(); 
        Connection con = conexionBD.establecerConexion();
        
        
        //BUSCO LOS ITEMS DE LA VENTA
        ArrayList<ItemVenta> ai = new ArrayList<>();
        pst = con.prepareStatement(queryParaObtenerItemsVenta);
        pst.setInt(1, IDV);
        //pst.setInt(2, IDP);
        rsItemVenta = pst.executeQuery();
  
        
        while (rsItemVenta.next()) {
        ItemVenta i = new ItemVenta();
        i.setId(rsItemVenta.getInt("ivid"));
        i.setCantidad(rsItemVenta.getInt("ivcantidad"));
        i.setPrecioUnidad(rsItemVenta.getFloat("ivpreciounidad"));
        
        // BUSCO EL PRODUCTO DEL ITEM
        
        pst = con.prepareStatement(queryParaObtenerProductosItemVenta);
        pst.setInt(1, i.getId());
        rsProductos =pst.executeQuery();
        Producto P= new Producto();
        if(rsProductos.next()){
        P.setId(rsProductos.getInt("pid"));
        P.setNombre(rsProductos.getString("pnombre"));
        switch(rsProductos.getString("pcategoria")){
                case "Lencería" -> P.setCategoria(LENCERIA);
                case "Accesorio" -> P.setCategoria(ACCESORIO);
                case "Papelería" -> P.setCategoria(PAPELERIA);
                case "Marroquinería" -> P.setCategoria(MARROQUINERIA);
                default -> P.setCategoria(VARIOS);
        }
        P.setDescripcion(rsProductos.getString("pdescripcion"));
        // guardamos el producto
        i.setProducto(P);
        }
        //guardamos el item venta en el array
        ai.add(i);
        }       
     return ai;
 }
 
    public ArrayList<VentaNotificacionDTO> ObtenerVentasConReserva(){
        
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        ArrayList<VentaNotificacionDTO> resultado = new ArrayList<>();
        
        try {
            
            // Establecer conexión
            con = BaseDatos.getInstance().establecerConexion();
            
            // Ejecutar query
            pst = con.prepareStatement("SELECT * FROM venta,reserva WHERE"+
                                       " (venta.vID = reserva.vID) AND"+
                                       " vEstadoVenta = 'En reserva'");
            rs = pst.executeQuery();
            
            // Obtener resultados
            while (rs.next()) {
                
                VentaNotificacionDTO v = new VentaNotificacionDTO(
                    rs.getInt("vID"),
                    rs.getString("vNombreCliente"),
                    rs.getString("vApellidoCliente"),
                    rs.getString("rTelefonoCliente"),
                    rs.getFloat("vImporteActual"),
                    new java.util.Date(rs.getDate("rFecha").getTime())
                );
                
                resultado.add(v);
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
        }
        
        return resultado;
    }
    
    public boolean cancelarVenta(int id, Date f) {
        
        boolean exito = false;
        PreparedStatement pst = null;
        Connection con = null;
        
        try {
            
            con = BaseDatos.getInstance().establecerConexion();
            
            // Modificar en tabla Venta
            pst = con.prepareStatement("UPDATE venta SET vEstadoVenta = 'Cancelada', vFechaUltimoPago = ? "+
                                       "WHERE vID = ?");
            pst.setDate(1, new java.sql.Date(f.getTime()));
            pst.setInt(2, id);
            pst.executeUpdate();
            
            exito = true;
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try { if (pst != null) pst.close();} catch (Exception e) {e.printStackTrace();}
        }
        
        return exito;
    }

}
