
package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    
    // Atributos
    
    private static BaseDatos INSTANCIA = null;	// SINGLETON
    
    private Connection con = null;
    private final String usuario;
    private final String password;
    private final String url;
    
    // Constructor privado
    
    private BaseDatos(String usuario, String password, String baseDatos, String ip, String puerto) {
        
        this.usuario = usuario;
        this.password = password;
        this.url = "jdbc:postgresql://"+ip+":"+puerto+"/"+baseDatos;
    }
	
    public static BaseDatos getInstance() {		
        
        if (INSTANCIA == null) {
            // Cambiar parámetros según la base de datos
            INSTANCIA = new BaseDatos("postgres", "tomitomi123", "postgres", "localhost", "5432");
        }
        return INSTANCIA;
    }
    
    // Otros métodos
    
    public Connection establecerConexion() {  
        
        try {
            if (con==null || con.isClosed()) {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(url, usuario, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la clase BaseDatos, en el método establecerConexion()"); 
            e.printStackTrace();
        }
        
        return con;
    }
    
    public void cerrarConexion() {
        
        if (con != null)
         try {
             con.close();
        } catch (SQLException e) {
            System.out.println("Error en la clase BaseDatos, en el método cerrarConexion()");
            e.printStackTrace();
        }
    }
    
}
