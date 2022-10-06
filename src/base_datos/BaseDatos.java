
package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    
    // Atributos
    
    private static BaseDatos INSTANCIA = null;	// SINGLETON
    private static Connection con;
    private static String usuario;
    private static String password;
    private static String url;
    
    // Constructor privado
    
    private BaseDatos(String usuario, String password, String baseDatos, String ip, String puerto) {
        BaseDatos.usuario = usuario;
        BaseDatos.password = password;
        BaseDatos.url = "jdbc:postgresql://"+ip+":"+puerto+"/"+baseDatos;
    }
	
    public static BaseDatos getInstance() {		
        if (INSTANCIA == null) {
            // Cambiar parámetros según la base de datos
            INSTANCIA = new BaseDatos("postgres", "hgfsd1234", "PM-2", "localhost", "5432");
        }
        return INSTANCIA;
    }
    
    // Otros métodos
    
    public Connection establecerConexion() {  
        if (con==null) {
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(url, usuario, password);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error en la clase BaseDatos, en el método establecerConexion()"); 
                e.printStackTrace();
            }
        }
        return con;
    }
    
}
