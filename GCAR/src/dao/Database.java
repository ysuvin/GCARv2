package dao;

 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class Database {
	
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            // OJO que `postgresql` es el nombre de host en la red de docker-compose
            // Si se usará sin docker-compose es necesario cambiar al hostname adecuado.            
            // TO DO: el host específico debería ir en un archivo de configuración, y no directo en el código.
            Connection con = DriverManager.getConnection("jdbc:postgresql://postgres:5432/gcar",
                    "gcar", "admin");
            return con;
        } catch (Exception ex) {
            System.out.print("Database.getConnection() Error --> ");
            ex.printStackTrace();
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}