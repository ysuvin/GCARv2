package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

import java.util.ArrayList;
import java.util.List;

import util.AtributoBean;
import util.EsquemaBean;
import util.RelacionBean;
import util.TuplaBean;

public class ConsultaDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement cs = null;

	public static RelacionBean verRelacion(String rel1, String rut){
		try{
			
			String query = "select * from load" + rut + "." + rel1;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean verRelacion(String res, String rel1, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
			
			String query = "create  table load" + rut + "." + res + " as " + 
						   "select * from load" + rut + "." + rel1;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}

	
	public static RelacionBean union(String rel1, String rel2, String rut){
		try{
					
			String query = "select * from load" + rut + "." + rel1 +
						   " union " +
						   "select * from load" + rut + "." + rel2;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean union(String res, String rel1, String rel2, String rut){
		try{
					
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
			
			String query = "create  table load" + rut + "." + res + " as " + 
						   "select * from load" + rut + "." + rel1 +
						   " union " +
						   "select * from load" + rut + "." + rel2;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}

	
	public static RelacionBean inter(String rel1, String rel2, String rut){
		try{
					
			String query = "select * from load" + rut + "." + rel1 +
						   " intersect " +
						   "select * from load" + rut + "." + rel2;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean inter(String res, String rel1, String rel2, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query = "create  table load" + rut + "." + res + " as " +
						   "select * from load" + rut + "." + rel1 +
						   " intersect " +
						   "select * from load" + rut + "." + rel2;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean diferencia(String rel1, String rel2, String rut){
		try{
					
			String query = "select * from load" + rut + "." + rel1 +
						   " except " +
						   "select * from load" + rut + "." + rel2;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean diferencia(String res, String rel1, String rel2, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query = "create  table load" + rut + "." + res + " as " +
						   "select * from load" + rut + "." + rel1 +
						   " except " +
						   "select * from load" + rut + "." + rel2;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean cruz(String rel1, String rel2, String rut){
		try{
					
			String query = "select * from load" + rut + "." + rel1 +
						   " , load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean cruz(String res, String rel1, String rel2, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query = "create  table load" + rut + "." + res + " as " +
						   "select * from load" + rut + "." + rel1 +
						   " , load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}

	
	public static RelacionBean reunionNatural(String rel1, String rel2, String rut){
		try{
					
			String query = "select * from load" + rut+ "." + rel1 +
						   " natural join load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean reunionNatural(String res, String rel1, String rel2, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query = "create  table  load" + rut + "." + res + " as " + 
						   "select * from load" + rut + "." + rel1 +
						   " natural join load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);
				
			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean reunionExtFull(String rel1, String rel2, String rut){
		try{
					
			String query = "select * from load" + rut + "." + rel1 +
					       " natural full outer join load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean reunionExtFull(String res, String rel1, String rel2, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query = "create  table load" + rut + "." + res + " as " +
						   "select * from load" + rut + "." + rel1 +
					       " natural full outer join load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean reunionExtIzq(String rel1, String rel2, String rut){
		try{
					
			String query = "select * from load" + rut + "." + rel1 +
					       " natural left outer join load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean reunionExtIzq(String res, String rel1, String rel2, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query = "create  table load" + rut + "." + res + " as " +
						   "select * from load" + rut + "." + rel1 +
					       " natural left outer join load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean reunionExtDer(String rel1, String rel2, String rut){
		try{
					
			String query = "select * from load" + rut + "." + rel1 +
					       " natural right outer join load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean reunionExtDer(String res, String rel1, String rel2, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query = "create  table load" + rut + "." + res + " as " +
						   "select * from load" + rut + "." + rel1 +
					       " natural right outer join load" +
						   rut + "." + rel2;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean proyectar(String atributosProy, String rel, String rut){
		try{
					
			String query = "select " + atributosProy + " from load" + rut + "." + rel;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean proyectar(String res, String atributosProy, String rel, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query =	"create  table load" + rut + "." + res + " as " +
							"select " + atributosProy + " from load" + rut + "." + rel;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean seleccionar(String condiciones, String rel, String rut){
		try{
					
			String query = "select * from load" + rut + "." + rel + " where " + condiciones;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean seleccionar(String res, String condiciones, String rel, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query =	"create  table load" + rut + "." + res + " as " +
							"select * from load" + rut + "." + rel + " where " + condiciones;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean reunion(String rel1, String rel2, String condiciones, String rut){
		try{
					
			String query = 	"select * from load" + rut + "." + rel1 + " inner join load" +
							rut + "." + rel2 + " on " + condiciones;

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean reunion(String res, String rel1, String rel2, String condiciones, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
					
			String query = 	"create  table load" + rut + "." + res + " as " +
							"select * from load" + rut + "." + rel1 + " inner join load" +
							rut + "." + rel2 + " on " + condiciones;

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean renombrar(String rel, String atributos, String rut){
		try{
			
			String query = "select " + atributos + " from load" + rut + "." + rel;

			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean renombrar(String res, String rel, String atributos, String rut){
		try{
			
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
			
			String query =  "create table load" + rut + "." + res + " as " +
							"select " + atributos + " from load" + rut + "." + rel;

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();

			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean division(String rel1, String rel2, String rut){
		try{
		String query = "select * from load" + rut+ "." + rel1 +
				   " division" +
				   rut + "." + rel2;
		System.out.println("Query: " + query);
		
		
		
		con = Database.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		RelacionBean relacionBean = new RelacionBean();
		List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
					
		while(rs.next()){
			TuplaBean tuplaBean = new TuplaBean();
			Object atributo[] = new Object[rsmd.getColumnCount()];
			for(int i = 0 ; i < atributo.length ; i++){
				atributo[i] = rs.getObject(i+1);
			}
			tuplaBean.setAtributos(atributo);
			tuplasBean.add(tuplaBean);
		}
		
		List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
		for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
			AtributoBean atributoBean = new AtributoBean();
			atributoBean.setNombre(rsmd.getColumnName(i+1));
			if(rsmd.getColumnTypeName(i+1).equals("text"))
				atributoBean.setTipo("Cadena");
			else if(rsmd.getColumnTypeName(i+1).equals("float8"))
				atributoBean.setTipo("Real");
			else
				atributoBean.setTipo("Entero");
			System.out.println(atributoBean.getTipo());
			atributosBean.add(atributoBean);
		}
		
		relacionBean.setTuplas(tuplasBean);
		relacionBean.setAtributos(atributosBean);
	
		return relacionBean;
		
		} catch (Exception ex) {
		RelacionBean err = new RelacionBean();
		err.setNombre(ex.getMessage().toString());
        return err;
		} finally {
        Database.close(con);
    	}
		
	}
	
	public static RelacionBean division(String res, String rel1, String rel2, String rut){
		try{
					
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
			
			String query = "create  table load" + rut + "." + res + " as " + 
						   "select * from load" + rut + "." + rel1 +
						   " union " +
						   "select * from load" + rut + "." + rel2;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean agrupar(String atributosAg, String fagrega,String rel1, String rut){
		try{
		String query = "select " + atributosAg + fagrega+ " from load" + rut + "." + rel1+
				       "group by" + atributosAg;
		System.out.println("Query: " + query);
		
		
		
		con = Database.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		RelacionBean relacionBean = new RelacionBean();
		List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
					
		while(rs.next()){
			TuplaBean tuplaBean = new TuplaBean();
			Object atributo[] = new Object[rsmd.getColumnCount()];
			for(int i = 0 ; i < atributo.length ; i++){
				atributo[i] = rs.getObject(i+1);
			}
			tuplaBean.setAtributos(atributo);
			tuplasBean.add(tuplaBean);
		}
		
		List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
		for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
			AtributoBean atributoBean = new AtributoBean();
			atributoBean.setNombre(rsmd.getColumnName(i+1));
			if(rsmd.getColumnTypeName(i+1).equals("text"))
				atributoBean.setTipo("Cadena");
			else if(rsmd.getColumnTypeName(i+1).equals("float8"))
				atributoBean.setTipo("Real");
			else
				atributoBean.setTipo("Entero");
			System.out.println(atributoBean.getTipo());
			atributosBean.add(atributoBean);
		}
		
		relacionBean.setTuplas(tuplasBean);
		relacionBean.setAtributos(atributosBean);
	
		return relacionBean;
		
		} catch (Exception ex) {
		RelacionBean err = new RelacionBean();
		err.setNombre(ex.getMessage().toString());
        return err;
		} finally {
        Database.close(con);
    	}
		
	}
	
	public static RelacionBean agrupar(String res, String atributosAg, String fagrega,String rel1, String rut){
		try{
					
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
			
			String query = "create  table load" + rut + "." + res + " as " + 
					       "select " + atributosAg + fagrega+ " from load" + rut + "." + rel1+
					       "group by" + atributosAg;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean ordenar(String atributosOr, String tipoOr, String rel1, String rut){
		try{
		String query = "select " + atributosOr + " from load" + rut + "." + rel1+
				   "order by" + atributosOr + tipoOr;
		System.out.println("Query: " + query);
		
		
		
		con = Database.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		RelacionBean relacionBean = new RelacionBean();
		List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
					
		while(rs.next()){
			TuplaBean tuplaBean = new TuplaBean();
			Object atributo[] = new Object[rsmd.getColumnCount()];
			for(int i = 0 ; i < atributo.length ; i++){
				atributo[i] = rs.getObject(i+1);
			}
			tuplaBean.setAtributos(atributo);
			tuplasBean.add(tuplaBean);
		}
		
		List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
		for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
			AtributoBean atributoBean = new AtributoBean();
			atributoBean.setNombre(rsmd.getColumnName(i+1));
			if(rsmd.getColumnTypeName(i+1).equals("text"))
				atributoBean.setTipo("Cadena");
			else if(rsmd.getColumnTypeName(i+1).equals("float8"))
				atributoBean.setTipo("Real");
			else
				atributoBean.setTipo("Entero");
			System.out.println(atributoBean.getTipo());
			atributosBean.add(atributoBean);
		}
		
		relacionBean.setTuplas(tuplasBean);
		relacionBean.setAtributos(atributosBean);
	
		return relacionBean;
		
		} catch (Exception ex) {
		RelacionBean err = new RelacionBean();
		err.setNombre(ex.getMessage().toString());
        return err;
		} finally {
        Database.close(con);
    	}
		
	}
	
	public static RelacionBean ordenar(String res, String atributosOr, String tipoOr, String rel1, String rut){
		try{
					
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
			
			String query = "create  table load" + rut + "." + res + " as " + 
						   "select " + atributosOr + " from load" + rut + "." + rel1+
						   "order by" + atributosOr + tipoOr;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean funcionAgregacion(String agregacion, String atributoFa,String rel1, String rut){
		try{
		String query = "select * from load" + rut+ "." + rel1 +
				   " division" + atributoFa+
				   rut + "." + agregacion;
		System.out.println("Query: " + query);
		
		
		
		con = Database.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		RelacionBean relacionBean = new RelacionBean();
		List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
					
		while(rs.next()){
			TuplaBean tuplaBean = new TuplaBean();
			Object atributo[] = new Object[rsmd.getColumnCount()];
			for(int i = 0 ; i < atributo.length ; i++){
				atributo[i] = rs.getObject(i+1);
			}
			tuplaBean.setAtributos(atributo);
			tuplasBean.add(tuplaBean);
		}
		
		List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
		for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
			AtributoBean atributoBean = new AtributoBean();
			atributoBean.setNombre(rsmd.getColumnName(i+1));
			if(rsmd.getColumnTypeName(i+1).equals("text"))
				atributoBean.setTipo("Cadena");
			else if(rsmd.getColumnTypeName(i+1).equals("float8"))
				atributoBean.setTipo("Real");
			else
				atributoBean.setTipo("Entero");
			System.out.println(atributoBean.getTipo());
			atributosBean.add(atributoBean);
		}
		
		relacionBean.setTuplas(tuplasBean);
		relacionBean.setAtributos(atributosBean);
	
		return relacionBean;
		
		} catch (Exception ex) {
		RelacionBean err = new RelacionBean();
		err.setNombre(ex.getMessage().toString());
        return err;
		} finally {
        Database.close(con);
    	}
		
	}
	
	public static RelacionBean funcionAgregacion(String res, String agregacion, String atributoFa,String rel1, String rut){
		try{
					
			String query2 = "drop table if exists load" + rut + "." + res;
			System.out.println(query2);
			
			con = Database.getConnection();
			ps = con.prepareStatement(query2);
			ps.execute();
			
			String query = "create  table load" + rut + "." + res + " as " + 
					"select * from load" + rut+ "." + rel1 +
					   " division" + atributoFa+
					   rut + "." + agregacion;
			System.out.println("Query: " + query);

			ps = con.prepareStatement(query);
			ps.execute();
			
			String query1 = "select * from load" + rut + "." + res;
			System.out.println("Query: " + query1);
			ps = con.prepareStatement(query1);
			ResultSet rs1 = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs1.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs1.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs1.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(res);
		
			return relacionBean;
			
		} catch (Exception ex) {
			RelacionBean err = new RelacionBean();
			err.setNombre(ex.getMessage().toString());
            return err;
        } finally {
            Database.close(con);
        }
	}
	
	
	public static RelacionBean verRespuesta(String rel, String bd){
		try{
			
			String query = "select * from " + bd + "." + rel;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(rel);
			return relacionBean;
			
		} catch (Exception ex) {
			System.out.println("Error en verRespuesta() -->" + ex.getMessage());
            return null;
        } finally {
            Database.close(con);
        }
	}
	
	public static RelacionBean verRespuestaEsperada(String rel, EsquemaBean esquema){
		try{
			
			String query = "select * from " + esquema.getNombre() + "_" + esquema.getRut() + "." + rel;
			System.out.println("Query: " + query);

			
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			RelacionBean relacionBean = new RelacionBean();
			List<TuplaBean> tuplasBean = new ArrayList<TuplaBean>();
						
			while(rs.next()){
				TuplaBean tuplaBean = new TuplaBean();
				Object atributo[] = new Object[rsmd.getColumnCount()];
				for(int i = 0 ; i < atributo.length ; i++){
					atributo[i] = rs.getObject(i+1);
				}
				tuplaBean.setAtributos(atributo);
				tuplasBean.add(tuplaBean);
			}
			
			List<AtributoBean> atributosBean = new ArrayList<AtributoBean>();
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++){
				AtributoBean atributoBean = new AtributoBean();
				atributoBean.setNombre(rsmd.getColumnName(i+1));
				if(rsmd.getColumnTypeName(i+1).equals("text"))
					atributoBean.setTipo("Cadena");
				else if(rsmd.getColumnTypeName(i+1).equals("float8"))
					atributoBean.setTipo("Real");
				else
					atributoBean.setTipo("Entero");
				System.out.println(atributoBean.getTipo());
				atributosBean.add(atributoBean);
			}
			
			relacionBean.setTuplas(tuplasBean);
			relacionBean.setAtributos(atributosBean);
			relacionBean.setNombre(rel);
			return relacionBean;
			
		} catch (Exception ex) {
			System.out.println("Error en verRespuesta() -->" + ex.getMessage());
            return null;
        } finally {
            Database.close(con);
        }
	}

}
