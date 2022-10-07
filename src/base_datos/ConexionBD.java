
package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class ConexionBD{	
    private static ConexionBD instancia = null;  

    private final String usuario;
    private final String password;
    private final String url;
    private Connection conexion = null;
   
    private ConexionBD(String usuario, String password, String baseDatos, String ip, String puerto){
        this.usuario = usuario;
        this.password = password;
        this.url = "jdbc:postgresql://" + ip + ":" + puerto + "/" + baseDatos;
    }

    public static ConexionBD obtenerInstancia(){
        if(instancia == null)
                instancia = new ConexionBD("postgres", "postgres", "branchAltaVenta", "localhost", "5432");
        return instancia; 
    }
    
    public void establecerConexion(){  
        if (conexion == null){
            try {

                Class.forName("org.postgresql.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("ERROR en public Connection establecerConexion() de clase ConexionBD");
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
    public void cerrarConexion() 
    {
        if (conexion != null)
         try {
             conexion.close();
        } catch (SQLException ex) {
            System.out.println("ERROR en public void cerrarConexion() de clase ConexionBD");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PreparedStatement prepararSentencia(String query){
        PreparedStatement pst = null;
        try { 
           pst = conexion.prepareStatement(query);
        } catch (SQLException ex) {
            System.out.println("ERROR en public PreparedStatement prepararSentencia() de clase ConexionBD");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pst; 
    }
}

