package dao;

 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class Database {
	
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gcar",
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