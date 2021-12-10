package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import util.User;
import util.UserBean;
  
public class UserDAO {
	static Connection con = null;
    static PreparedStatement ps = null;
    static Statement cs = null;
	
	public static UserBean login(String rut, String pass) {
        try {
//        	ELContext elContext = FacesContext.getCurrentInstance().getELContext();            	
//    		UserBean userBean = (UserBean) FacesContext.getCurrentInstance().getApplication()
//    		    .getELResolver().getValue(elContext, null, "userBean");
        	
        	UserBean userBean = new UserBean();
    		
        	String query = "SELECT * FROM usuarios WHERE rut=? AND pass=?";
    		
        	System.out.println("Query: " + query);
        	
        	con = Database.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,rut);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();       
            
            if (rs.next()) // encontro usuario
            {
                System.out.println("Usuario " + userBean.getRut() + " encontrado en la tabla Usuarios");
            	
        		userBean.setRut(rs.getString(1));
        		userBean.setPass(rs.getString(2));
        		userBean.setNombre1(rs.getString(3));
        		userBean.setNombre2(rs.getString(4));
        		userBean.setPaterno(rs.getString(5));
        		userBean.setMaterno(rs.getString(6));
        		userBean.setMail(rs.getString(7));
        		userBean.setTipo(rs.getInt(8));
        		
        		System.out.println("Usuario cargado");
        		
        		if(userBean.getTipo() == 1){

        			query = "SELECT * FROM profesores WHERE rut = ?";
        			ps = con.prepareStatement(query);
                    ps.setString(1,userBean.getRut()); 
                    ResultSet rs1 = ps.executeQuery();
                    
                    if(rs1.next()){
                    	System.out.println("holi");
                    	userBean.setAnyo(rs1.getString(2));
                    	System.out.println("Usuario " + userBean.getRut() + " encontrado en la tabla Profesores");
                    	return userBean;
                    }else{
                    	return null;
                    }
                    
        		}else if(userBean.getTipo() == 2){
        			
        			query = "SELECT * FROM alumnos WHERE rut = ?";
        			ps = con.prepareStatement(query);
                    ps.setString(1,userBean.getRut()); 
                    ResultSet rs1 = ps.executeQuery();
                    
                    if(rs1.next()){
                    	userBean.setAnyo(rs1.getString(2));
                    	userBean.setVezCursando(rs1.getString(3));
                    	userBean.setEdad(rs1.getString(4));
                    	System.out.println("Usuario " + userBean.getRut() + " encontrado en la tabla Profesores");
                    	return userBean;
                    }else{
                    	return null;
                    }
        			
        		}else{
        			return null;
        		}
        		
            }
            else {
            	System.out.println("No encontro usuario");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Error en login() -->" + ex.getMessage());
            return null;
        } finally {
            Database.close(con);
        }
    }
	
public static UserBean registrarAlumno(UserBean user){
        try { 
        	
//        	ELContext elContext = FacesContext.getCurrentInstance().getELContext();            	
//    		UserBean userBean = (UserBean) FacesContext.getCurrentInstance().getApplication()
//    		    .getELResolver().getValue(elContext, null, "userBean");
        	
        	String query = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,2)";
        	System.out.println("Query: " + query);
        	
        	con = Database.getConnection();
        	ps = con.prepareStatement(query);
        	ps.setString(1,user.getRut());
        	ps.setString(2,user.getPass());
        	ps.setString(3,user.getNombre1());
        	ps.setString(4,user.getNombre2());
        	ps.setString(5,user.getPaterno());
        	ps.setString(6,user.getMaterno());
        	ps.setString(7,user.getMail());
        	ps.execute();
        	
            System.out.println("Alumno agregado en tabla Usuario");
            
            query = "INSERT INTO alumnos VALUES (?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1,user.getRut());
            ps.setString(2,user.getAnyo());
            ps.setString(3,user.getVezCursando());
            ps.setString(4,user.getEdad());
            ps.execute();
           
            System.out.println("Alumno agregado en tabla Alumnos");
            	
            user.setTipo(2);
            
        	return user;
        } catch (Exception ex) {
            System.out.println("Error en crearUsuario() -->" + ex.getMessage());
            if(ex.getMessage().contains("llave duplicada viola restricci�n de unicidad")){
            	UserBean userBean = new UserBean();
            	userBean.setNombre1("duplicado");
            	return userBean;
            }
            return null;
        } finally {
            Database.close(con);
        }
	}
	
	public static User crearUsuario(User user){
		
		
        try { 
        	
        	String query = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,2)";
        	System.out.println("Query: " + query);
        	
        	con = Database.getConnection();
        	ps = con.prepareStatement(query);
        	ps.setString(1,user.getRut());
        	ps.setString(2,user.getPass());
        	ps.setString(3,user.getNombre1());
        	ps.setString(4,user.getNombre2());
        	ps.setString(5,user.getPaterno());
        	ps.setString(6,user.getMaterno());
        	ps.setString(7,user.getMail());
        	ps.execute();
        	
            System.out.println("Alumno agregado en tabla Usuario");
            
            query = "INSERT INTO alumnos VALUES (?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1,user.getRut());
            ps.setString(2,user.getAnyo());
            ps.setString(3,user.getVezCursando());
            ps.setString(4,user.getEdad());
            ps.execute();
           
            System.out.println("Alumno agregado en tabla Alumnos");
            
            user.setTipo(2);
            
            return user;
            
        } catch (Exception ex) {
        	System.out.println("Error en crearUsuario() -->" + ex.getMessage());
            if(ex.getMessage().contains("llave duplicada viola restricci�n de unicidad")){
            	User userBean = new User();
            	userBean.setNombre1("duplicado");
            	return userBean;
            }
            return null;
        } finally {
            Database.close(con);
        }
	}
	
	public static List<User> selectUsuarios(){
		try{
			
			String query = "Select u.rut, u.pass, u.nombre1, u.nombre2, u.paterno, u.materno, "
					+ "u.mail, u.tipo, a.ano_ingreso, a.vez_cursado, a.edad from usuarios u, alumnos a where u.rut = a.rut";
			System.out.println("Query: " + query);

        	con = Database.getConnection();
            cs = con.createStatement();
            ResultSet rs = cs.executeQuery(query);
            
            ArrayList<User> users = new ArrayList<User>();
            while(rs.next()){
            	User user = new User();
            	user.setRut(rs.getString(1));
            	user.setPass(rs.getString(2));
            	user.setNombre1(rs.getString(3));
            	user.setNombre2(rs.getString(4));
            	user.setPaterno(rs.getString(5));
            	user.setMaterno(rs.getString(6));
            	user.setMail(rs.getString(7));
            	user.setTipo(rs.getInt(8));
            	user.setAnyo(rs.getString(9));
            	user.setVezCursando(rs.getString(10));
            	user.setEdad(rs.getString(11));
            	users.add(user);
            }
            
            System.out.println("Carga de Usuarios exitosa");
            return users;
            
			
		} catch (Exception ex) {
			System.out.println("Error en selectUsuarios() -->" + ex.getMessage());
			return null;
		} finally {
			Database.close(con);
		}
	
	}
	
	public static boolean eliminarUsuario(User user){
		try{
			
			String query = "DELETE FROM usuarios WHERE rut = ?";
			System.out.println("Query: " + query);
			
			con = Database.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,user.getRut());
            ps.execute();
           
            System.out.println("Alumno eliminado en tabla Alumnos");
            
            return true;
            	
		} catch (Exception ex) {
			System.out.println("Error en eliminarUsuario() -->" + ex.getMessage());
			return false;
		} finally {
			Database.close(con);
		}
	}
	
	public static boolean modificarUsuario(User user){
		try{
			
			String query = "UPDATE usuarios SET rut=?, pass=?, nombre1=?, nombre2=?, paterno=?, materno=?, mail=? WHERE rut =?";
			System.out.println("Query: " + query);
			
			con = Database.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,user.getRut());
            ps.setString(2,user.getPass());
            ps.setString(3,user.getNombre1());
            ps.setString(4,user.getNombre2());
            ps.setString(5,user.getPaterno());
            ps.setString(6,user.getMaterno());
            ps.setString(7,user.getMail());
            ps.setString(8,user.getRut());
            ps.execute();
           
            System.out.println("Usuario editado en tabla Usuarios");
            
            if(user.getTipo() == 1){
            	
            	query = "UPDATE profesores SET ano_curso=? WHERE rut=?";
            	System.out.println("Query: " + query);
            	
            	ps = con.prepareStatement(query);
 	            ps.setString(1,user.getAnyo());
 	            ps.setString(2,user.getRut());
 	            ps.execute();
            	
            	System.out.println("Usuario editado en tabla Profesores");
            	
            	return true;
            	
            }else if(user.getTipo() == 2){
	            
	            query = "UPDATE alumnos SET ano_ingreso=?, vez_cursado=?, edad=? WHERE rut=?";
				System.out.println("Query: " + query);
				
				con = Database.getConnection();
	            ps = con.prepareStatement(query);
	            ps.setString(1,user.getAnyo());
	            ps.setString(2,user.getVezCursando());
	            ps.setString(3,user.getEdad());
	            ps.setString(4,user.getRut());
	            ps.execute();
	                       
	            System.out.println("Usuario editado en tabla Alumnos");
	            
	            return true;
	            
            }else{
            	return false;
            }
            	
		} catch (Exception ex) {
			System.out.println("Error en modificarUsuario() -->" + ex.getMessage());
			return false;
		} finally {
			Database.close(con);
		}
	}
 
}