package dao;

import baseDatos.BaseDatos;
import clasesEntidad.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOReserva implements InterfazDAOReserva {

    @Override
    public boolean registrar(Reserva reserva, int idVenta) {
        boolean exito = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        BaseDatos conexionBD = BaseDatos.getInstance();
        
        try {       
            Connection con = BaseDatos.getInstance().establecerConexion();
           
            pst = con.prepareStatement("INSERT INTO Reserva VALUES (?,?,?,?)");
           
            pst.setInt(1, idVenta);
            pst.setString(2, reserva.getTelefonoCliente());
            pst.setFloat(3, reserva.getSeña());
            pst.setDate(4, new java.sql.Date(reserva.getFechaRegistro().getTime()));
           
            pst.executeUpdate();
            exito = true;
        } 
        catch (SQLException e)
        {
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
            catch(SQLException e)
            {
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
        conexionBD.cerrarConexion();
        return exito;
    }

    @Override
    public boolean modificar(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reserva obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
