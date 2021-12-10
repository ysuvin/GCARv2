package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.EstadisticaConsulta;
import util.EstadisticaRespuesta;
import util.EstadisticaResultado;
import util.EstadisticaTodo;

public class EstadisticasDAO {

	static Connection con = null;
    static PreparedStatement ps = null;
    static Statement cs = null;
    
    public static List<EstadisticaConsulta> selectConsultas(){
    	try{
    		
    		String query = 	"select c.id, r.rut, c.numero, c.query, c.error, c.fecha " +
    						"from consultas c, respuestas r " + 
    						"where c.id_respuestas = r.id";
    		
    		System.out.println("Query " + query);
    		
    		con = Database.getConnection();	
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			List<EstadisticaConsulta> consultas = new ArrayList<EstadisticaConsulta>();
			
			while(rs.next()){
				EstadisticaConsulta consulta = new EstadisticaConsulta();
				consulta.setId(rs.getInt(1));
				consulta.setRut(rs.getString(2));
				consulta.setNumero(rs.getInt(3));
				consulta.setQuery(rs.getString(4));
				if(rs.getString(5) == null){
					consulta.setError("");
				}else{
					consulta.setError(rs.getString(5));
				}
				consulta.setFecha(rs.getString(6));
				consultas.add(consulta);
			}
			
			System.out.println("Carga lista de consultas");
			
			return consultas;			
	
    	} catch (Exception e){
    		System.out.println("Error selectConsulta() -> " + e.getMessage());
    		return null;
    	} finally {
    		Database.close(con);
    	}
    }
    
    public static List<EstadisticaRespuesta> selectRespuestas(){
    	try{
    		
    		String query = 	"select * from respuestas";
    		
    		System.out.println("Query " + query);
    		
    		con = Database.getConnection();	
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			List<EstadisticaRespuesta> respuestas = new ArrayList<EstadisticaRespuesta>();
			
			while(rs.next()){
				EstadisticaRespuesta respuesta = new EstadisticaRespuesta();
				respuesta.setId(rs.getInt(1));
				respuesta.setRut(rs.getString(2));
				respuesta.setBd(rs.getString(3));
				respuesta.setFechaBd(rs.getString(4));
				respuesta.setEjercicio(rs.getInt(5));
				respuesta.setResultado(rs.getBoolean(6));
				respuesta.setIntento(rs.getInt(7));
				respuesta.setTiempoEjercicio(rs.getString(8));
				respuesta.setTiempoSesion(rs.getString(9));
				respuesta.setFecha(rs.getString(10));
				respuestas.add(respuesta);
			}
			
			System.out.println("Carga lista de respuestas");
			
			return respuestas;			
	
    	} catch (Exception e){
    		System.out.println("Error selectRespuesta() -> " + e.getMessage());
    		return null;
    	} finally {
    		Database.close(con);
    	}
    }
    
    public static List<EstadisticaResultado> selectResultados(){
    	try{
    		
    		String query = 	"select * from resultados";
    		
    		System.out.println("Query " + query);
    		
    		con = Database.getConnection();	
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			List<EstadisticaResultado> resultados= new ArrayList<EstadisticaResultado>();
			
			while(rs.next()){
				EstadisticaResultado resultado = new EstadisticaResultado();
				resultado.setId(rs.getInt(1));
				resultado.setBd(rs.getString(2));
				resultado.setFechaBd(rs.getString(3));
				resultado.setCantEjercicios(rs.getInt(4));
				resultado.setCantCorrectas(rs.getInt(5));
				resultado.setCantErroneas(rs.getInt(6));
				resultado.setCantOmitidas(rs.getInt(7));
				resultado.setFecha(rs.getString(8));
				resultados.add(resultado);
			}
			
			System.out.println("Carga lista de respuestas");
			
			return resultados;			
	
    	} catch (Exception e){
    		System.out.println("Error selectResultado() -> " + e.getMessage());
    		return null;
    	} finally {
    		Database.close(con);
    	}
    }
    
    public static List<EstadisticaTodo> selectTodo(){
    	try{
    		
    		String query = 	"select	result.id as \"id_resultado\", result.bd, result.fecha_bd, " +
    						"result.cant_ejercicios, result.cant_correctas, result.cant_erroneas, " +
				    		"result.cant_omitidas, result.fecha as \"fecha_resultado\", " +
				    		"resp.id as \"id_respuesta\", resp.rut as \"rut_alumno\", resp.ejercicio, " + 
				    		"resp.resultado as \"resultado_ejercicio\" , " + 
				    		"resp.intento as \"intento_ejercicio\", resp.tiempo_ejercicio, " + 
				    		"resp.tiempo_sesion, resp.fecha as \"fecha_respuesta\", " + 
				    		"con.id as \"id_consulta\", con.numero as \"numero_consulta\", " +
				    		"con.query, con.error as \"error_query\", con.fecha as \"fecha_consulta\" " +
		    				"from resultados result, respuestas resp, consultas con " +
		    				"where	result.bd = resp.bd and " +
				    		"result.fecha_bd = resp.fecha_bd and " +
				    		"resp.id = con.id_respuestas";
    		
    		System.out.println("Query " + query);
    		
    		con = Database.getConnection();	
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			List<EstadisticaTodo> todos= new ArrayList<EstadisticaTodo>();
			
			while(rs.next()){
				EstadisticaTodo todo = new EstadisticaTodo();
				todo.setIdResultado(rs.getInt(1));
				todo.setBd(rs.getString(2));
				todo.setFechaBd(rs.getString(3));
				todo.setCantEjercicios(rs.getInt(4));
				todo.setCantCorrectas(rs.getInt(5));
				todo.setCantErroneas(rs.getInt(6));
				todo.setCantOmitidas(rs.getInt(7));
				todo.setFechaResultado(rs.getString(8));
				todo.setIdRespuesta(rs.getInt(9));
				todo.setRut(rs.getString(10));
				todo.setEjercicio(rs.getInt(11));
				todo.setResultadoEjercicio(rs.getBoolean(12));
				todo.setIntentoEjercicio(rs.getInt(13));
				todo.setTiempoEjercicio(rs.getString(14));
				todo.setTiempoSesion(rs.getString(15));
				todo.setFechaEjercicio(rs.getString(16));
				todo.setIdConsulta(rs.getInt(17));
				todo.setNumeroConsulta(rs.getInt(18));
				todo.setQuery(rs.getString(19));
				if(rs.getString(5) == null){
					todo.setErrorQuery("");
				}else{
					todo.setErrorQuery(rs.getString(20));
				}
				todo.setFechaConsulta(rs.getString(21));
				todos.add(todo);
			}
			
			System.out.println("Carga lista de todo");
			
			return todos;			
	
    	} catch (Exception e){
    		System.out.println("Error selectTodo() -> " + e.getMessage());
    		return null;
    	} finally {
    		Database.close(con);
    	}
    }
}
