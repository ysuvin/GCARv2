package beans;
	 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import dao.ConsultaDAO;
import dao.EjercicioDAO;
import dao.ResultadoDAO;
import parser.AlgebraRelacionalLexer;
import parser.AlgebraRelacionalParser;
import util.AtributoBean;
import util.Consulta;
import util.Ejercicio;
import util.EsquemaBean;
import util.RelacionBean;	
import util.Respuesta;
import util.Resultado;
import util.TuplaBean;
import util.UserBean;
 
@ManagedBean(name="dtResponderEjerciciosBean")
@ViewScoped
public class ResponderEjerciciosBean implements Serializable {
     
	//Ejemplo
	private String tableName;
	private List<Object[]> data;
	private List<String> columnNames;
	private String query = "";
	private String queryList = "";
	
	private List<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
	private Ejercicio selectedEjercicio;
	private int cantEjercicios;
	
	private List<Respuesta> respuestas = new ArrayList<Respuesta>();	
	private Respuesta respuesta;
	private List<Consulta> consultas;
	private Consulta consulta;
	
    @PostConstruct
    public void init() {
    	
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    	EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
			    .getELResolver().getValue(elContext, null, "bd");
    	
    	if(esquemaBean != null){
			ejercicios = EjercicioDAO.cargarEjercicios(esquemaBean);
			if(ejercicios == null){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al cargar los ejercicios","");
	       		FacesContext.getCurrentInstance().addMessage(null, msg);
			}else{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Ejercicios Cargados","");
	       		FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			cantEjercicios = ejercicios.size();
    	}else{
    		try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
			} catch (Exception e) {
				System.out.println("No pude redireccionar");
			}
    	}
    }
	
	public Ejercicio getSelectedEjercicio() {
		return selectedEjercicio;
	}

	public void setSelectedEjercicio(Ejercicio selectedEjercicio) {
		this.selectedEjercicio = selectedEjercicio;
	}

	public int getCantEjercicios() {
		return cantEjercicios;
	}

	public void setCantEjercicios(int cantEjercicios) {
		if(cantEjercicios < 0){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"La cantidad de atributos no puede ser negativa","");
       		FacesContext.getCurrentInstance().addMessage(null, msg);
		}else{
			this.cantEjercicios = cantEjercicios;
		}
	}

	public List<Ejercicio> getEjercicios() {

		if(ejercicios.size() == 0){
			for(int i = 0 ; i < cantEjercicios ; i++){
				System.out.println("Hola");
				Ejercicio ejercicio = new Ejercicio();
				ejercicios.add(ejercicio);
			}
		}else if(ejercicios.size() < cantEjercicios){
			for(int i = ejercicios.size() ; i < cantEjercicios ; i++){
				Ejercicio ejercicio = new Ejercicio();
				ejercicio.setId(i);
				ejercicios.add(ejercicio);
			}
		}else if(ejercicios.size() > cantEjercicios){
			for(int i = ejercicios.size(); i > cantEjercicios ; i--){
				ejercicios.remove(i-1);
			}
		}
		for(int i = 0 ; i < ejercicios.size() ; i++){
			Ejercicio ejercicio = ejercicios.get(i);
			ejercicio.setId(i);
			ejercicios.set(i,ejercicio);
		}
		return ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	public String getQueryList() {
		return queryList;
	}

	public void setQueryList(String queryList) {
		this.queryList = queryList;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Object[]> getData(){
		return data;
	}
	
	public List<String> getColumnNames(){
		return columnNames;
	}
	
	public void setData(List<Object[]> data){
		this.data = data;
	}
	
	public void setColumnNames(List<String> columnNames){
		this.columnNames = columnNames;
	}
    
    public String getQuery(){
    	return query;
    }
    
	public void setQuery(String query) {
		this.query = query;
	}
	
	
	/* ##############################################
	 * #             Parte de Ejercicio				#
	 * ##############################################
	 */
	private void imprimirEjercicios(){
		for(Ejercicio e : ejercicios){
			System.out.println(e.getId());
			System.out.println(e.getPregunta());
			System.out.println(e.getRespuesta());
			System.out.println(e.getRespuestaAlumno());
			System.out.println(e.isResultado());
			System.out.println();
		}
	}
	
	private int buscarIntento(Respuesta resp){
		int intento = 0;
		for(Respuesta r : respuestas){
			if(r.getEjercicio() == resp.getEjercicio() && r.getIntento() >= intento){
				intento = r.getIntento();
			}
		}
		System.out.println("Intento: " + (intento+1));
		return intento + 1;
	}
	
	public void responder(){
		
		System.out.println("Respondiendo");
		Calendar tiempoInicio = new GregorianCalendar();
		
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		UserBean userBean = (UserBean) FacesContext.getCurrentInstance().getApplication()
			    .getELResolver().getValue(elContext, null, "usuario");
		EsquemaBean esquemaActual = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
			    .getELResolver().getValue(elContext, null, "bd");
		
		consultas = new ArrayList<Consulta>();
		
		respuesta = new Respuesta();		
		respuesta.setRut(userBean.getRut());
		respuesta.setBd(esquemaActual.getNombre() + "_" + esquemaActual.getRut());
		respuesta.setFechaBd(esquemaActual.getFecha());
		respuesta.setEjercicio(selectedEjercicio.getId());
		respuesta.setTiempoEjercicio(tiempoInicio);
		respuesta.setIntento(buscarIntento(respuesta));
		System.out.println();
	}
	
	public void cancelar(){
		System.out.println("cancelo");
		selectedEjercicio = null;
		imprimirEjercicios();
	}
	
//	private Calendar diferenciaHora(Calendar inicio, Calendar fin){
//		
//	}
	
	public void aceptar(){
		
		System.out.println("Respondido");
		
		Calendar tiempoEjercicio = new GregorianCalendar();
		Calendar tiempoSesion = new GregorianCalendar();
		
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		UserBean userBean = (UserBean) FacesContext.getCurrentInstance().getApplication()
			    .getELResolver().getValue(elContext, null, "usuario");	
		
		tiempoEjercicio.add(Calendar.MILLISECOND,-respuesta.getTiempoEjercicio().get(Calendar.MILLISECOND));
		tiempoEjercicio.add(Calendar.SECOND,-respuesta.getTiempoEjercicio().get(Calendar.SECOND));
		tiempoEjercicio.add(Calendar.MINUTE,-respuesta.getTiempoEjercicio().get(Calendar.MINUTE));
		tiempoEjercicio.add(Calendar.HOUR_OF_DAY,-respuesta.getTiempoEjercicio().get(Calendar.HOUR_OF_DAY));
		
		tiempoSesion.add(Calendar.MILLISECOND,-userBean.getInicioSesion().get(Calendar.MILLISECOND));
		tiempoSesion.add(Calendar.SECOND,-userBean.getInicioSesion().get(Calendar.SECOND));
		tiempoSesion.add(Calendar.MINUTE,-userBean.getInicioSesion().get(Calendar.MINUTE));
		tiempoSesion.add(Calendar.HOUR_OF_DAY,-userBean.getInicioSesion().get(Calendar.HOUR_OF_DAY));
				
		System.out.println("Tiempo Ejercicio: " + tiempoEjercicio.get(Calendar.HOUR_OF_DAY) + ":" + tiempoEjercicio.get(Calendar.MINUTE) + ":" + tiempoEjercicio.get(Calendar.SECOND));
		System.out.println("Tiempo Sesion: " + tiempoSesion.get(Calendar.HOUR_OF_DAY) + ":" + tiempoSesion.get(Calendar.MINUTE) + ":" + tiempoSesion.get(Calendar.SECOND));
		
		
		respuesta = ResultadoDAO.revisarRespuesta(respuesta,selectedEjercicio);
		respuesta.setTiempoEjercicio(tiempoEjercicio);
		respuesta.setTiempoSesion(tiempoSesion);
		respuesta.setConsultas(consultas);
		
		selectedEjercicio.setResultado(respuesta.isResultado());
		ejercicios.set(selectedEjercicio.getId(),selectedEjercicio);
		
		respuestas.add(respuesta);

		imprimirEjercicios();
		selectedEjercicio = null;
	}
	
	public String obtenerCalificacion(){

		if(ResultadoDAO.guardarRespuestas(respuestas)){
			
			// Preparando el conteo de respuestas
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
				    .getELResolver().getValue(elContext, null, "bd");
			UserBean userBean = (UserBean) FacesContext.getCurrentInstance().getApplication()
				    .getELResolver().getValue(elContext, null, "usuario");
			
			int cantEjercicios = ejercicios.size();
			int cantCorrectas = 0;
			int cantErroneas = 0;
			int cantOmitidas = 0;
			
			//Contando respuestas
			for(Ejercicio e : ejercicios){
				if(e.getRespuestaAlumno() == null){
					cantOmitidas++;
				}else{
					Pattern pat = Pattern.compile("\\s*");
				    Matcher mat = pat.matcher(e.getRespuestaAlumno());
				    if(mat.matches()) {
				    	cantOmitidas++;
				    }else if(e.isResultado()){
						cantCorrectas++;
					}else{
						cantErroneas++;
					}
				}		
			}
			
			Resultado resultado = new Resultado();
			resultado.setBd(esquemaBean.getNombre() + "_" + esquemaBean.getRut());
			resultado.setFechaBd(esquemaBean.getFecha());
			resultado.setCantCorrectas(cantCorrectas);
			resultado.setCantEjercicios(cantEjercicios);
			resultado.setCantErroneas(cantErroneas);
			resultado.setCantOmitidas(cantOmitidas);
			
			if(ResultadoDAO.guardarResultado(resultado)){
			
				userBean.setEjercicios(ejercicios);
				userBean.setResultado(resultado);
				
				HttpSession session = Util.getSession();
				session.setAttribute("usuario", userBean);
				
				return "obtenerCalificacion";
			
			}else{
				//Error al guardar resultados
//				Util.reloadBd();
				return "responderEjercicios";
			}
		}else{
			//Error al guardar respuestas
//			Util.reloadBd();
			return "responderEjercicios";
		}
		
	}

//	public void crear(){
//		System.out.println("Creando Ejercicios");
//		
//		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
//    	EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
//			    .getELResolver().getValue(elContext, null, "bd");
//    	UserBean userBean = (UserBean) FacesContext.getCurrentInstance().getApplication()
//			    .getELResolver().getValue(elContext, null, "usuario");
//		
//		boolean band = false;
//		for(Ejercicio e : ejercicios){
//			if(e.getPregunta() == null || e.getRespuesta() == null){
//				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Imposible guardar ejercicios con preguntas o respuestas vacías. Revisar ejercicio " + (e.getId()+1),"");
//	       		FacesContext.getCurrentInstance().addMessage(null, msg);
//	       		band = true;
//	       		break;
//			}else{
//				Pattern pat = Pattern.compile("\\s*");
//			    Matcher mat = pat.matcher(e.getPregunta());
//			    if (mat.matches()) {
//			    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Imposible guardar ejercicios con preguntas o respuestas vacías. Revisar ejercicio " + (e.getId()+1),"");
//		       		FacesContext.getCurrentInstance().addMessage(null, msg);
//		       		band = true;
//		       		break;
//			    }
//			    mat = pat.matcher(e.getRespuesta());
//			    if (mat.matches()) {
//			    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Imposible guardar ejercicios con preguntas o respuestas vacías. Revisar ejercicio " + (e.getId()+1),"");
//		       		FacesContext.getCurrentInstance().addMessage(null, msg);
//		       		band = true;
//		       		break;
//			    }else{
//			    	e.setRespuesta(e.getRespuesta().replaceAll("[\n\r]", ";"));
//			    	e.setRespuesta(e.getRespuesta().replaceAll(";+", ";"));
//			    	String[] aux = e.getRespuesta().split(";");
//			    	System.out.println(aux.length);
//			    	for(int i = 0 ; i < aux.length ; i++){
//			    		System.out.println("Query AR: " + aux[i]);
//			    		AlgebraRelacionalLexer lexer = new AlgebraRelacionalLexer(new ANTLRStringStream(aux[i]));
//			    		CommonTokenStream tokens = new CommonTokenStream(lexer);
//			    		AlgebraRelacionalParser parser = new AlgebraRelacionalParser(tokens);
//			    		try {
//							parser.st();
//							if(parser.getNumberOfSyntaxErrors() != 0){
//								FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error de sintaxis de Algebra Relacional. Revisar ejercicio " + (e.getId()+1),"");
//					       		FacesContext.getCurrentInstance().addMessage(null, msg);
//					       		band = true;
//					       		break;
//							}
//						} catch (RecognitionException e1) {
//							e1.printStackTrace();
//						}
//			    	}
//			    	if(band){
//			    		break;
//			    	}
//			    		
//			    }
//			}
//		}
//		if(!band){
//			if(EjercicioDAO.crearEjercicios(userBean.getRut(),esquemaBean.getNombre(), ejercicios)){
//				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Lista de Ejercicios Creada","");
//	       		FacesContext.getCurrentInstance().addMessage(null, msg);
//			}else{
//				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al crear la lista de Ejercicios","");
//	       		FacesContext.getCurrentInstance().addMessage(null, msg);
//			}
//		}
//	}
	
	
	
	/* ##############################################
	 * #             Parte de Consultas				#
	 * ##############################################
	 */
	
//	public void copiarRespuesta(){
//		selectedEjercicio.setRespuesta(queryList);
//	}
	
	private boolean nombreValido(String query){
		if(		/*Revisa si la relacion auxiliar contiene palabras reservadas*/
				query.contains("seleccionar") || query.contains("SELECCIONAR") ||
				query.contains("proyectar") ||  query.contains("PROYECTAR") ||
				query.contains("union") || query.contains("UNION") ||
				query.contains("inter") || query.contains("INTER") ||
				query.contains("diferencia") || query.contains("DIFERECIA") ||
				query.contains("cruz") || query.contains("CRUZ") ||
				query.contains("reunion") || query.contains("REUNION") ||
				query.contains("reunion_natural") || query.contains("REUNION_NATURAL") ||
				query.contains("reunion_ext_izq") || query.contains("REUNION_EXT_IZQ") ||
				query.contains("reunion_ext_der") || query.contains("REUNION_EXT_DER") ||
				query.contains("reunion_ext_full") || query.contains("REUNION_EXT_FULL") ||
				query.contains(":=") ||
				/*Revisa si la relacion auxiliar es igual a una etiqueta del lenguaje*/
				query.equals("st") || query.equals("asg") || query.equals("con") || query.equals("bin") ||
				query.equals("select") || query.equals("proy") || query.equals("renom1") ||
				query.equals("renom2") || query.equals("renom3") || query.equals("join") ||
				query.equals("atts") || query.equals("conds1") || query.equals("conds2") ||
				query.equals("con1") || query.equals("con2") || query.equals("con3") || query.equals("cons") ||
				query.equals("num") || query.equals("att") || query.equals("rel") || query.equals("NUM") ||
				query.equals("CAD") || query.equals("WS")		
				){
			return false;
		}else{
			return true;
		}
	}

	// Filtra consulta y luego las ejecuta
	public void ejecutar(){
		
		AlgebraRelacionalLexer lexer = new AlgebraRelacionalLexer(new ANTLRStringStream(query));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		AlgebraRelacionalParser parser = new AlgebraRelacionalParser(tokens);
		
		// Prepara la consulta para guardarla
		consulta = new Consulta();
		
		try{
			
			consulta.setQuery(query);
			consulta.setNumero(consultas.size());
			
			// Ejecuta la consulta
			parser.st();
			
			// Revisa si tiene errores de sintaxis
			if(parser.getNumberOfSyntaxErrors() == 0){
				System.out.println("Query AR: " + query);
				
				ELContext elContext = FacesContext.getCurrentInstance().getELContext();
				UserBean userBean = (UserBean) FacesContext.getCurrentInstance().getApplication()
					    .getELResolver().getValue(elContext, null, "usuario");
				EsquemaBean esquema = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
					    .getELResolver().getValue(elContext, null, "bd");
				RelacionBean resultado = new RelacionBean();
				
				if(query.contains(":=")){ // Revisa si es una consulta de asignacion
					boolean band = false;
					
					String test[] = query.split(":=");
					test[0] = test[0].replaceAll(" ", "");
					if(!nombreValido(test[0])){
						resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
						consulta.setError("Consulta utiliza Tokens");
						band = true;
					}else if(esquema.isRelacion(test[0])){
						resultado.setNombre("ERROR: no puedes reasignar una relación de la lista de Relaciones");
						consulta.setError("Consulta renombra Relacion del Esquema original");
						band = true;
					}
					
					//Asignar Reunion Natural
					if(!band && (query.contains("reunion_natural") || query.contains("REUNION_NATURAL"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");	
						
						String aux2[] = aux1[1].split("reunion_natural|REUNION_NATURAL");
						aux2[0] = aux2[0].replaceAll(" ", "");
						aux2[1] = aux2[1].replaceAll(" ", "");
						
						System.out.println(aux1[0]);
						System.out.println(aux2[0]);
						System.out.println(aux2[1]);
						
						if(aux1[0].equals(aux2[0]) || aux1[0].equals(aux2[1])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.reunionNatural(aux1[0],aux2[0],aux2[1],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}
						
						band = true;
					}
					//Asignar Reunion Externa Full
					if(!band && (query.contains("reunion_ext_full") || query.contains("REUNION_EXT_FULL"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");	
						
						String aux2[] = aux1[1].split("reunion_ext_full|REUNION_EXT_FULL");
						aux2[0] = aux2[0].replaceAll(" ", "");
						aux2[1] = aux2[1].replaceAll(" ", "");
						
						System.out.println(aux1[0]);
						System.out.println(aux2[0]);
						System.out.println(aux2[1]);
						
						if(aux1[0].equals(aux2[0]) || aux1[0].equals(aux2[1])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.reunionExtFull(aux1[0],aux2[0],aux2[1],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}
						
						band = true;
					}
					
					//Asignar Reunion Izquierda Externa
					if(!band && (query.contains("reunion_ext_izq") || query.contains("REUNION_EXT_IZQ"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");
						
						String aux2[] = query.split("reunion_ext_izq|REUNION_EXT_IZQ");
						aux2[0] = aux2[0].replaceAll(" ", "");
						aux2[1] = aux2[1].replaceAll(" ", "");
						
						System.out.println(aux1[0]);
						System.out.println(aux2[0]);
						System.out.println(aux2[1]);
						
						if(aux1[0].equals(aux2[0]) || aux1[0].equals(aux2[1])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.reunionExtIzq(aux1[0],aux2[0],aux2[1],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}
						
						band = true;
					}
					
					//Asignar Reunion Derecha Externa
					if(!band && (query.contains("reunion_ext_der") || query.contains("REUNION_EXT_DER"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");
						
						String aux2[] = query.split("reunion_ext_der|REUNION_EXT_DER");
						aux2[0] = aux2[0].replaceAll(" ", "");
						aux2[1] = aux2[1].replaceAll(" ", "");
						
						System.out.println(aux1[0]);
						System.out.println(aux2[0]);
						System.out.println(aux2[1]);
						
						if(aux1[0].equals(aux2[0]) || aux1[0].equals(aux2[1])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.reunionExtDer(aux1[0],aux2[0],aux2[1],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}

						band = true;
					}
					
					// Asignar Reunion
					if(!band && (query.contains("reunion") || query.contains("REUNION"))){
						
						String aux[] = query.split(":=");
						aux[0] = aux[0].replaceAll(" ","");
						
						String aux1[] = aux[1].split("reunion|REUNION");
						aux1[0] = aux1[0].replaceAll(" ", "");
						aux1[0] = aux1[0].replaceAll("\\)","");
						aux1[0] = aux1[0].replaceAll("\\(","");
						
						
						String aux2[] = aux1[1].split("\\(");
						aux2[1] = aux2[1].replaceAll("\\)","");
						aux2[2] = aux2[2].replaceAll("\\)","");
						aux2[2] = aux2[2].replaceAll(" ","");
						
						System.out.println(aux[0]);
						System.out.println(aux1[0]);
						System.out.println(aux2[2]);
						System.out.println(aux2[1]);
						
												
						if(aux[0].equals(aux1[0]) || aux[0].equals(aux2[2])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.reunion(aux[0],aux1[0],aux2[2],aux2[1],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}

						band = true;
					}

					//Asignar Union
					if(!band && (query.contains("union") || query.contains("UNION"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");	
						
						String aux2[] = aux1[1].split("union|UNION");
						aux2[0] = aux2[0].replaceAll(" ", "");
						aux2[1] = aux2[1].replaceAll(" ", "");
						
						System.out.println(aux1[0]);
						System.out.println(aux2[0]);
						System.out.println(aux2[1]);
						
						if(aux1[0].equals(aux2[0]) || aux1[0].equals(aux2[1])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.union(aux1[0],aux2[0],aux2[1],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}

						band = true;
			
					}
					
					//Asignar Interseccion	
					if(!band && (query.contains("inter") || query.contains("INTER"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");	
						
						String aux2[] = aux1[1].split("inter|INTER");
						aux2[0] = aux2[0].replaceAll(" ", "");
						aux2[1] = aux2[1].replaceAll(" ", "");
						
						System.out.println(aux1[0]);
						System.out.println(aux2[0]);
						System.out.println(aux2[1]);
						
						if(aux1[0].equals(aux2[0]) || aux1[0].equals(aux2[1])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.inter(aux1[0],aux2[0],aux2[1],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}
						
						band = true;
					}
					
					//Asignar Diferencia
					if(!band && (query.contains("diferencia") || query.contains("DIFERENCIA"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");	
						
						String aux2[] = aux1[1].split("diferencia|DIFERENCIA");
						aux2[0] = aux2[0].replaceAll(" ", "");
						aux2[1] = aux2[1].replaceAll(" ", "");
						
						System.out.println(aux1[0]);
						System.out.println(aux2[0]);
						System.out.println(aux2[1]);
						
						if(aux1[0].equals(aux2[0]) || aux1[0].equals(aux2[1])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.diferencia(aux1[0],aux2[0],aux2[1],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}
						
						band = true;
					}	
					//Asignar Producto Cruz
					if(!band && (query.contains("cruz") || query.contains("CRUZ"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");	
						
						String aux2[] = aux1[1].split("cruz|CRUZ");
						aux2[0] = aux2[0].replaceAll(" ", "");
						aux2[1] = aux2[1].replaceAll(" ", "");
						
						System.out.println(aux1[0]);
						System.out.println(aux2[0]);
						System.out.println(aux2[1]);
						
						if(aux1[0].equals(aux2[0]) || aux1[0].equals(aux2[1])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");	
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.cruz(aux1[0],aux2[0],aux2[1],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}
						
						band = true;						
					}
					
					// Asignar Proyeccion
					if(!band && (query.contains("proyectar") || query.contains("PROYECTAR"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");
						
						String aux[] = aux1[1].split("\\(");
						aux[1] = aux[1].replaceAll(" ", "");
						aux[1] = aux[1].replaceAll("\\)","");
						
						aux[2] = aux[2].replaceAll(" ", "");
						aux[2] = aux[2].replaceAll("\\)","");
						
						System.out.println(aux[1]);
						System.out.println(aux[2]);
						
						if(aux1[0].equals(aux[2])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.proyectar(aux1[0],aux[1],aux[2],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}
						
						band = true;
					}
					
					// Asignar Seleccionar
					if(!band && (query.contains("seleccionar") || query.contains("SELECCIONAR"))){
						
						String aux1[] = query.split(":=");
						aux1[0] = aux1[0].replaceAll(" ","");
						
						String aux[] = aux1[1].split("\\(");
						aux[1] = aux[1].replaceAll("\\)","");

						aux[2] = aux[2].replaceAll(" ", "");
						aux[2] = aux[2].replaceAll("\\)","");
						
						System.out.println(aux[1]);
						System.out.println(aux[2]);
						
						if(aux1[0].equals(aux[2])){
							resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");	
							consulta.setError("Asignacion recursiva de variable");
						}else if(!nombreValido(aux1[0])){
							resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
							consulta.setError("Consulta utiliza Tokens");
						}else{
							resultado = ConsultaDAO.seleccionar(aux1[0],aux[1],aux[2],userBean.getRut());
							System.out.println(resultado.getNombre());
							tableName = resultado.getNombre().toLowerCase();
						}

						band = true;
					}
					
					// Asignar Renombrar
					if(!band && (query.contains("renombrar") || query.contains("RENOMBRAR"))){
					
						String aux3[] = query.split(":=");
						aux3[0] = aux3[0].replaceAll(" ","");
						
						String aux[] = aux3[1].split("renombrar|RENOMBRAR");
						String aux1[] = aux[1].split("\\(");
						aux1[0] = aux1[0].replaceAll(" ","");	
						aux1[1] = aux1[1].replaceAll("\\)","");
						aux1[1] = aux1[1].replaceAll(" ","");
						
						if(aux1[0].equals("")){
							// Sólo renombra los atributos
							
							aux1[2] = aux1[2].replaceAll("\\)","");
							aux1[2] = aux1[2].replaceAll(" ","");
							
							EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
								    .getELResolver().getValue(elContext, null, "bd");
							
							RelacionBean relacion = esquemaBean.obtenerRelacion(aux1[2]);
							String[] atributos = aux1[1].split(",");
							
							if(relacion != null && atributos.length == relacion.getAtributos().size()){
								
								String att = "";
								for(int i = 0 ; i < atributos.length ; i++){
									atributos[i] = relacion.getAtributos().get(i).getNombre() + " as " + atributos[i];		
									att = att + atributos[i] + ",";
								}
								att = att.substring(0,att.length()-1);
								
								System.out.println(aux3[0]);
								System.out.println(relacion.getNombre());
								System.out.println(att);
								
								if(aux3[0].equals(relacion.getNombre())){
									consulta.setError("Asignacion recursiva de variable");
									resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");	
								}else if(!nombreValido(aux3[0])){
									resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
									consulta.setError("Consulta utiliza Tokens");
								}else{
									resultado = ConsultaDAO.renombrar(aux3[0],relacion.getNombre(),att,userBean.getRut());
									tableName = resultado.getNombre().toLowerCase();
								}
								
							}else{
								resultado.setNombre("ERROR: La relacion no existe o la cantidad de atributos a renombrar no concuerda");
								consulta.setError("Relacion a renombrar inexistente o cantidad invalida de atributos al renombrar");
							}
								
						}else{
							// Renombra relacion	
							if(aux1.length == 3){
								
								
								aux1[2] = aux1[2].replaceAll("\\)","");
								aux1[2] = aux1[2].replaceAll(" ","");
								
								EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
									    .getELResolver().getValue(elContext, null, "bd");
								
								RelacionBean relacion = esquemaBean.obtenerRelacion(aux1[2]);
								String[] atributos = aux1[1].split(",");
								
								if(relacion != null && atributos.length == relacion.getAtributos().size()){
									
									String att = "";
									for(int i = 0 ; i < atributos.length ; i++){
										atributos[i] = relacion.getAtributos().get(i).getNombre() + " as " + atributos[i];		
										att = att + atributos[i] + ",";
									}
									att = att.substring(0,att.length()-1);
									
									System.out.println(aux3[0]);
									System.out.println(aux1[0]);
									System.out.println(att);
									System.out.println(relacion.getNombre());
									
									if(aux3[0].equals(relacion.getNombre())){
										resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
										consulta.setError("Asignacion recursiva de variable");
									}else if(!nombreValido(aux3[0])){
										resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
										consulta.setError("Consulta utiliza Tokens");
									}else{
										resultado = ConsultaDAO.renombrar(aux3[0],relacion.getNombre(),att,userBean.getRut());
										tableName = aux1[0].toLowerCase();
									}
									
								}else{
									resultado.setNombre("ERROR: La relacion no existe o la cantidad de atributos a renombrar no concuerda");
									consulta.setError("Relacion a renombrar inexistente o cantidad invalida de atributos al renombrar");
								}
															
							}else{
								
								EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
									    .getELResolver().getValue(elContext, null, "bd");
								
								RelacionBean relacion = esquemaBean.obtenerRelacion(aux1[1]);
								
								if(relacion!= null){
									
									System.out.println(aux3[0]);
									System.out.println(aux1[0]);
									System.out.println(relacion.getNombre());
									
									if(aux3[0].equals(relacion.getNombre())){
										resultado.setNombre("ERROR: no puedes asignar recursivamente una variable");
										consulta.setError("Asignacion recursiva de variable");
									}else if(!nombreValido(aux3[0])){
										resultado.setNombre("ERROR: no puedes usar etiquetas del lenguaje como nombre");
										consulta.setError("Consulta utiliza Tokens");
									}else{
										resultado = ConsultaDAO.verRelacion(aux3[0],relacion.getNombre(),userBean.getRut());
										tableName = relacion.getNombre();
									}
									
								}else{
									resultado.setNombre("ERROR: La relacion " + aux1[1] + " no existe");
									consulta.setError("Relacion a renombar inexistente");
								}
							}						
						}
						
						band = true;
						
					}
					columnNames = new ArrayList<String>();
					data = new ArrayList<Object[]>();
					// Revisa el resultado de la consulta
					if(resultado.getTuplasBean()!= null){
						
						EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
							    .getELResolver().getValue(elContext, null, "bd");
						
						List<RelacionBean> relacionesAuxiliares = esquemaBean.getRelacionesAuxiliares();
						
						if(relacionesAuxiliares == null){
							relacionesAuxiliares = new ArrayList<RelacionBean>();
						}
						
						// Revisa si la relacion nueva ya existe
						if(esquemaBean.isRelacionAux(resultado.getNombre())){
							esquemaBean.reemplazarRelacion(resultado);
						
						}else{
							// Si no existe, simplemente la agrega
							relacionesAuxiliares.add(resultado);
						}
						esquemaBean.setRelacionesAuxiliares(relacionesAuxiliares);
						
						HttpSession session = Util.getSession();
				    	
				    	session.setAttribute("nombreBd",esquemaBean.getNombre());
				    	session.setAttribute("bd",esquemaBean);
						
						for(AtributoBean a : resultado.getAtributos())
							columnNames.add(a.getNombre());
						
						for(TuplaBean t : resultado.getTuplasBean())
							data.add(t.getAtributos());

						queryList = queryList + query + "\n";
						
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Consulta realizada satisfactoriamente","");
			       		FacesContext.getCurrentInstance().addMessage(null, msg);
					}else{
						tableName = null;
						columnNames = null;
						data = null;
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al realizar la consulta: " + resultado.getNombre(),"");
			       		FacesContext.getCurrentInstance().addMessage(null, msg);
						System.out.println("Error: " + resultado.getNombre());
						consulta.setError("Error Postgresql");
					}
					
				}else{					  // Consulta normal
					
					boolean band = false;
					//Reunion Natural
					if(!band && (query.contains("reunion_natural") || query.contains("REUNION_NATURAL"))){
						String aux[] = query.split("reunion_natural|REUNION_NATURAL");
						aux[0] = aux[0].replaceAll(" ", "");
						aux[1] = aux[1].replaceAll(" ", "");
						
						System.out.println(aux[0]);
						System.out.println(aux[1]);
						
						resultado = ConsultaDAO.reunionNatural(aux[0],aux[1],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}
					//Reunion Completa Externa
					if(!band && (query.contains("reunion_ext_full") || query.contains("REUNION_EXT_FULL"))){
						String aux[] = query.split("reunion_ext_full|REUNION_EXT_FULL");
						aux[0] = aux[0].replaceAll(" ", "");
						aux[1] = aux[1].replaceAll(" ", "");
						
						System.out.println(aux[0]);
						System.out.println(aux[1]);
						
						resultado = ConsultaDAO.reunionExtFull(aux[0],aux[1],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}
					//Reunion Izquierda Externa
					if(!band && (query.contains("reunion_ext_izq") || query.contains("REUNION_EXT_IZQ"))){
						String aux[] = query.split("reunion_ext_izq|REUNION_EXT_IZQ");
						aux[0] = aux[0].replaceAll(" ", "");
						aux[1] = aux[1].replaceAll(" ", "");
						
						System.out.println(aux[0]);
						System.out.println(aux[1]);
						
						resultado = ConsultaDAO.reunionExtIzq(aux[0],aux[1],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}
					//Reunion Derecha Externa
					if(!band && (query.contains("reunion_ext_der") || query.contains("REUNION_EXT_DER"))){
						String aux[] = query.split("reunion_ext_der|REUNION_EXT_DER");
						aux[0] = aux[0].replaceAll(" ", "");
						aux[1] = aux[1].replaceAll(" ", "");
						
						System.out.println(aux[0]);
						System.out.println(aux[1]);
						
						resultado = ConsultaDAO.reunionExtDer(aux[0],aux[1],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}
					// Proyeccion
					if(!band && (query.contains("proyectar") || query.contains("PROYECTAR"))){
						String aux[] = query.split("\\(");
						aux[1] = aux[1].replaceAll(" ", "");
						aux[1] = aux[1].replaceAll("\\)","");
						
						aux[2] = aux[2].replaceAll(" ", "");
						aux[2] = aux[2].replaceAll("\\)","");
						
						System.out.println(aux[1]);
						System.out.println(aux[2]);
						
						resultado = ConsultaDAO.proyectar(aux[1],aux[2],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}
					// Seleccionar
					if(!band && (query.contains("seleccionar") || query.contains("SELECCIONAR"))){
						String aux[] = query.split("\\(");
						aux[1] = aux[1].replaceAll("\\)","");

						aux[2] = aux[2].replaceAll(" ", "");
						aux[2] = aux[2].replaceAll("\\)","");
						
						System.out.println(aux[1]);
						System.out.println(aux[2]);

						resultado = ConsultaDAO.seleccionar(aux[1],aux[2],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}
					// Reunion
					if(!band && (query.contains("reunion") || query.contains("REUNION"))){
						String aux1[] = query.split("reunion|REUNION");
						aux1[0] = aux1[0].replaceAll(" ", "");
						aux1[0] = aux1[0].replaceAll("\\)","");
						aux1[0] = aux1[0].replaceAll("\\(","");
						
						System.out.println(band);
						
						String aux2[] = aux1[1].split("\\(");
						aux2[1] = aux2[1].replaceAll("\\)","");
						aux2[2] = aux2[2].replaceAll("\\)","");
						aux2[2] = aux2[2].replaceAll(" ","");
						
						System.out.println(aux1[0]);
						System.out.println(aux2[2]);
						System.out.println(aux2[1]);
						
						resultado = ConsultaDAO.reunion(aux1[0],aux2[2],aux2[1],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}
					//Union
					if(!band && (query.contains("union") || query.contains("UNION"))){ 
						String aux[] = query.split("union|UNION");
						
						aux[0] = aux[0].replaceAll(" ", "");//Relacion1
						aux[1] = aux[1].replaceAll(" ", "");//Relacion2
						
						System.out.println(aux[0]);
						System.out.println(aux[1]);
						
						resultado = ConsultaDAO.union(aux[0],aux[1],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}
					//Interseccion	
					if(!band && (query.contains("inter") || query.contains("INTER"))){
						String aux[] = query.split("inter|INTER");
						
						aux[0] = aux[0].replaceAll(" ", "");
						aux[1] = aux[1].replaceAll(" ", "");
						
						System.out.println(aux[0]);
						System.out.println(aux[1]);
						
						resultado = ConsultaDAO.inter(aux[0],aux[1],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}
					//Diferencia
					if(!band && (query.contains("diferencia") || query.contains("DIFERENCIA"))){
						String aux[] = query.split("diferencia|DIFERENCIA");
						
						aux[0] = aux[0].replaceAll(" ", "");
						aux[1] = aux[1].replaceAll(" ", "");
						
						System.out.println(aux[0]);
						System.out.println(aux[1]);
						
						resultado = ConsultaDAO.diferencia(aux[0],aux[1],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;
					}	
					//Producto Cruz
					if(!band && (query.contains("cruz") || query.contains("CRUZ"))){
						String aux[] = query.split("cruz|CRUZ");
						
						aux[0] = aux[0].replaceAll(" ", "");
						aux[1] = aux[1].replaceAll(" ", "");
						
						System.out.println(aux[0]);
						System.out.println(aux[1]);
						
						resultado = ConsultaDAO.cruz(aux[0],aux[1],userBean.getRut());
						tableName = resultado.getNombre();
						band = true;						
					}
					//Renombrar
					if(!band && (query.contains("renombrar") || query.contains("RENOMBRAR"))){
						
						String aux[] = query.split("renombrar|RENOMBRAR");
						String aux1[] = aux[1].split("\\(");
						aux1[0] = aux1[0].replaceAll(" ","");	
						aux1[1] = aux1[1].replaceAll("\\)","");
						aux1[1] = aux1[1].replaceAll(" ","");
						
						if(aux1[0].equals("")){
							// Sólo renombra los atributos
							
							aux1[2] = aux1[2].replaceAll("\\)","");
							aux1[2] = aux1[2].replaceAll(" ","");
							
							EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
								    .getELResolver().getValue(elContext, null, "bd");
							
							RelacionBean relacion = esquemaBean.obtenerRelacion(aux1[2]);
							String[] atributos = aux1[1].split(",");
							
							if(relacion != null && atributos.length == relacion.getAtributos().size()){
								
								String att = "";
								for(int i = 0 ; i < atributos.length ; i++){
									atributos[i] = relacion.getAtributos().get(i).getNombre() + " as " + atributos[i];		
									att = att + atributos[i] + ",";
								}
								att = att.substring(0,att.length()-1);
								
								System.out.println(relacion.getNombre());
								System.out.println(att);

								resultado = ConsultaDAO.renombrar(relacion.getNombre(),att,userBean.getRut());
								tableName = resultado.getNombre();
								
							}else{
								resultado.setNombre("ERROR: La relacion no existe o la cantidad de atributos a renombrar no concuerda");
							}
								
						}else{
							// Renombra relacion	
							if(aux1.length == 3){
								
								aux1[2] = aux1[2].replaceAll("\\)","");
								aux1[2] = aux1[2].replaceAll(" ","");
								
								EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
									    .getELResolver().getValue(elContext, null, "bd");
								
								RelacionBean relacion = esquemaBean.obtenerRelacion(aux1[2]);
								String[] atributos = aux1[1].split(",");
								
								if(relacion != null && atributos.length == relacion.getAtributos().size()){
									
									String att = "";
									for(int i = 0 ; i < atributos.length ; i++){
										atributos[i] = relacion.getAtributos().get(i).getNombre() + " as " + atributos[i];		
										att = att + atributos[i] + ",";
									}
									att = att.substring(0,att.length()-1);
									
									System.out.println(aux1[0]);
									System.out.println(att);
									System.out.println(relacion.getNombre());
									
									resultado = ConsultaDAO.renombrar(relacion.getNombre(),att,userBean.getRut());
									tableName = aux1[0].toLowerCase();
									
								}else{
									resultado.setNombre("ERROR: La relacion no existe o la cantidad de atributos a renombrar no concuerda");
									consulta.setError("Relacion a renombrar inexistente o cantidad invalida de atributos al renombrar");
								}
															
							}else{
								
								EsquemaBean esquemaBean = (EsquemaBean) FacesContext.getCurrentInstance().getApplication()
									    .getELResolver().getValue(elContext, null, "bd");
								
								RelacionBean relacion = esquemaBean.obtenerRelacion(aux1[1]);
								
								if(relacion!= null){
									
									System.out.println(aux1[0]);
									System.out.println(relacion.getNombre());
									
									resultado = ConsultaDAO.verRelacion(relacion.getNombre(),userBean.getRut());
									tableName = aux1[0].toLowerCase();
									
								}else{
									resultado.setNombre("ERROR: La relacion " + aux1[0] + "no existe");
									consulta.setError("Relacion a renombrar inexistente");
								}
							}						
						}
						band = true;
					}
			
					columnNames = new ArrayList<String>();
					data = new ArrayList<Object[]>();

					// Revisa el resultado de la consulta
					if(resultado.getTuplasBean()!= null){
						
						for(AtributoBean a : resultado.getAtributos())
							columnNames.add(a.getNombre());
						
						for(TuplaBean t : resultado.getTuplasBean())
							data.add(t.getAtributos());
						
						queryList = queryList + query + "\n";
					
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Consulta realizada satisfactoriamente","");
			       		FacesContext.getCurrentInstance().addMessage(null, msg);
					}else{
						tableName = "";
						columnNames = null;
						data = null;
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al realizar la consulta: " + resultado.getNombre(),"");
			       		FacesContext.getCurrentInstance().addMessage(null, msg);
						System.out.println("Error: " + resultado.getNombre());
						consulta.setError("Error Postgresql");
					}
					
					
				}
			
			// Error de sintaxis de consultas
			}else{
				tableName = "";
				columnNames = null;
				data = null;
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error de sintaxis en consulta de Algebra Relacional","");
				consulta.setError("Error de sintaxis de lenguaje AR");
	       		FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (RecognitionException e) {
			tableName = "";
			columnNames = null;
			data = null;
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error Interno al ejecutar la consulta","");
			consulta.setError("FATAL: Error interno");
       		FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		consultas.add(consulta);

	}
	
	public void ayudaSeleccionar(){
		query = "SELECCIONAR (Lista_de_condiciones) (relacion) ";
	}
	
	public void ayudaProyectar(){
		query = "PROYECTAR (Lista_de_atributos) (relacion) ";
	}

	public void ayudaRenombrar(){
		query = "RENOMBRAR nuevo_nombre(lista_de_atributos) (relacion) ";
	}
	
	public void ayudaUnion(){
		query = "relacion UNION relacion ";
	}
	
	public void ayudaInterseccion(){
		query = "relacion INTER relacion ";
	}
	
	public void ayudaDiferencia(){
		query = "relacion DIFERENCIA relacion ";
	}
	
	public void ayudaCruz(){
		query = "relacion CRUZ relacion ";
	}
	
	public void ayudaReunion(){
		query = "(relacion) REUNION (Lista_de_condiciones_de_reunion) (relacion) ";
	}
	
	public void ayudaReunionNatural(){
		query = "relacion REUNION_NATURAL relacion ";
	}
	
	public void ayudaReunionExtIzq(){
		query = "relacion REUNION_EXT_IZQ relacion ";
	}
	
	public void ayudaReunionExtDer(){
		query = "relacion REUNION_EXT_DER relacion ";
	}
	
	public void ayudaReunionExtComp(){
		query = "relacion REUNION_EXT_FULL relacion ";
	}
	
	public void ayudaAsignar(){
		query = "relacion := consulta ";
	}

}


