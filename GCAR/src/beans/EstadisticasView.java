package beans;

import javax.annotation.PostConstruct;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import dao.EstadisticasDAO;
import dao.ResultadoDAO;
import util.EstadisticaConsulta;
import util.EstadisticaRespuesta;
import util.EstadisticaResultado;
import util.EstadisticaTodo;
import util.Respuesta;
import util.Resultado;

 
@ManagedBean(name = "estadisticasView")
@ViewScoped
public class EstadisticasView implements Serializable {
 
   private String nombreBd;
   private int cantidadResp;
   private String promedioAcertadas;
   private String promedioErroneas;
   private String promedioOmitidas;
   private String promedioTiempoRespuestas;
   private String promedioIntentosRespuestas;
   private String promedioPorcentaje;
   private boolean ver = false;
   
   private List<Respuesta> respuestas;
   private List<Resultado> resultados;
   
   private DecimalFormat df = new DecimalFormat("##.##");
   
   private BarChartModel animatedModel2;
   
   private List<String> bds;
   private String selectedBd;
   private List<String> fechas;
   private String selectedFecha;
   private String fecha;
   
   private StreamedContent file;
   private String path;
   private String contentType;
   private boolean descargar = false;
   
   
   public boolean isDescargar() {
	return descargar;
	}
	public void setDescargar(boolean descargar) {
		this.descargar = descargar;
	}
	public StreamedContent getFile() {
	   return file;
	}
	public void setFile(StreamedContent file) {
		this.file = file;
	}
	public boolean getVer(){
	   return ver;
   }
   public void setVer(boolean ver){
	   this.ver = ver;
   }
   public List<String> getBds() {
	   return bds;
	}
	public void setBds(List<String> bds) {
		bds = this.bds;
	}
	public String getSelectedBd() {
		return selectedBd;
	}
	public void setSelectedBd(String selectedBd) {
		this.selectedBd = selectedBd;
	}
	public List<String> getFechas() {
		return fechas;
	}
	public void setFechas(List<String> fechas) {
		fechas = this.fechas;
	}
	public String getSelectedFecha() {
		return selectedFecha;
	}
	public void setSelectedFecha(String selectedFecha) {
		this.selectedFecha = selectedFecha;
	}
	public String getNombreBd() {
		return nombreBd;
	}
	public void setNombreBd(String nombreBd) {
		this.nombreBd = nombreBd;
	}
	public int getCantidadResp() {
		return cantidadResp;
	}
	public void setCantidadResp(int cantidadResp) {
		this.cantidadResp = cantidadResp;
	}
	public String getPromedioAcertadas() {
		return promedioAcertadas;
	}
	public void setPromedioAcertadas(String promedioAcertadas) {
		this.promedioAcertadas = promedioAcertadas;
	}
	public String getPromedioErroneas() {
		return promedioErroneas;
	}
	public void setPromedioErroneas(String primedioErroneas) {
		this.promedioErroneas = primedioErroneas;
	}
	public String getPromedioOmitidas() {
		return promedioOmitidas;
	}
	public void setPromedioOmitidas(String primedioOmitidas) {
		this.promedioOmitidas = primedioOmitidas;
	}
	public String getPromedioTiempoRespuestas() {
		return promedioTiempoRespuestas;
	}
	public void setPromedioTiempoRespuestas(String promedioTiempoRespuestas) {
		this.promedioTiempoRespuestas = promedioTiempoRespuestas;
	}
	public String getPromedioIntentosRespuestas() {
		return promedioIntentosRespuestas;
	}
	public void setPromedioIntentosRespuestas(String promedioIntentosRespuestas) {
		this.promedioIntentosRespuestas = promedioIntentosRespuestas;
	}
	public String getPromedioPorcentaje() {
		return promedioPorcentaje;
	}
	public void setPromedioPorcentaje(String promedioPorcentaje) {
		this.promedioPorcentaje = promedioPorcentaje;
	}
	public List<Respuesta> getRespuesta() {
		return respuestas;
	}
	public void setRespuesta(List<Respuesta> respuesta) {
		this.respuestas = respuesta;
	}
	public List<Resultado> getResultados() {
		return resultados;
	}
	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}
	public void setAnimatedModel2(BarChartModel animatedModel2) {
		this.animatedModel2 = animatedModel2;
	}
	
	@PostConstruct
	public void init(){	
		bds = ResultadoDAO.obtenerEsquemas();         
			
		nombreBd = "";		
		resultados = new ArrayList<Resultado>();
		respuestas = new ArrayList<Respuesta>();
		cantidadResp = resultados.size();
				
		this.promedioPorcentaje = df.format(0);
		this.promedioAcertadas = df.format(0);
		this.promedioErroneas = df.format(0);
		this.promedioOmitidas = df.format(0);
		this.promedioIntentosRespuestas = df.format(0);
		this.promedioTiempoRespuestas =	"0:0:0";
		createAnimatedModels();	
	}
		
	
	
	public void onBdChangue(){
		System.out.println(selectedBd);
		fechas = ResultadoDAO.obtenerFechas(selectedBd);
	}
	
	public void verEstadisticas(){
		
		nombreBd = selectedBd;
		fecha = selectedFecha;
		
		resultados = ResultadoDAO.cargarResultado(selectedBd,selectedFecha);
		
		if(resultados != null){
			
			respuestas = ResultadoDAO.cargarRespuestas(selectedBd,selectedFecha);
			
			if(respuestas != null){
				
				cantidadResp = resultados.size();
				ver = true;
				
				float promedioAcertadas = 0;
				float promedioErroneas = 0;
				float promedioOmitidas = 0;
				int totales = 0;
				for(Resultado r : resultados){
					promedioAcertadas = promedioAcertadas + r.getCantCorrectas();
					promedioErroneas = promedioErroneas + r.getCantErroneas();
					promedioOmitidas = promedioOmitidas + r.getCantOmitidas();
					totales = totales + r.getCantEjercicios();
				}
				this.promedioPorcentaje = df.format((promedioAcertadas * 100)/totales);
				this.promedioAcertadas = df.format(promedioAcertadas/resultados.size());
				this.promedioErroneas = df.format(promedioErroneas/resultados.size());
				this.promedioOmitidas = df.format(promedioOmitidas/resultados.size());
				
				float promedioIntentosRespuestas = 0;
				Calendar tiempoR = new GregorianCalendar();
				long tiempoRespuesta = 0;
				for(Respuesta r : respuestas){				
					tiempoRespuesta = tiempoRespuesta + r.getTiempoEjercicio().getTimeInMillis();
					promedioIntentosRespuestas = promedioIntentosRespuestas + r.getConsultas().size();
				}
				if(respuestas.size() != 0){
					this.promedioIntentosRespuestas = df.format(promedioIntentosRespuestas/respuestas.size());
					tiempoR.setTimeInMillis((long)tiempoRespuesta/respuestas.size());
					promedioTiempoRespuestas =	Integer.toString(tiempoR.get(Calendar.HOUR_OF_DAY)) + ":" +
												Integer.toString(tiempoR.get(Calendar.MINUTE)) + ":" +
												Integer.toString(tiempoR.get(Calendar.SECOND));
					
					
				}
				createAnimatedModels();
				
			}else{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al cargar las respuestas","");
	       		FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			
		}else{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al cargar los resultados","");
       		FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
    public BarChartModel getAnimatedModel2() {
    	return animatedModel2;
    }
 
    private void createAnimatedModels() {
         
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Grafico de Respuestas");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        Axis xAxis = animatedModel2.getAxis(AxisType.X);
        
        yAxis.setMin(0);
               
        xAxis.setLabel("Ejercicios");
        
    }
     
    private BarChartModel initBarModel() {
       
    	BarChartModel model = new BarChartModel();
        
        int max = 0;
        if(respuestas != null){
	        for(Respuesta r : respuestas)
	        	if(r.getEjercicio() > 0)
	        		max = r.getEjercicio();
        }
        
        
        ChartSeries acertadas = new ChartSeries();
        acertadas.setLabel("Acertadas");
        
        ChartSeries cantRes = new ChartSeries();
        cantRes.setLabel("Total Respuestas");
        
        ChartSeries intentos = new ChartSeries();
        intentos.setLabel("Intentos");
        
        
        if(respuestas != null){
	        for(int i = 0 ; i <= max ; i++){
	        	int acert = 0;
	        	int resp = 0;
	        	int intent = 0;
	        	for(Respuesta r : respuestas){
	        		if(r.getEjercicio() == i){
	        			resp++;
	        			if(r.getConsultas() != null){
	        				intent = intent + r.getConsultas().size();
	        			}
	        			if(r.isResultado()){
	        				acert++;
	        			}
	        		}
	        	}
	        	acertadas.set((i+1),acert);
	        	cantRes.set((i+1),resp);
	        	intentos.set((i+1),intent);
	        }
        }
        
        model.addSeries(acertadas);
        model.addSeries(cantRes);
        model.addSeries(intentos);
        
        return model;
    }  
    
    public void generarDescarga(){
    	System.out.println("Preparando Descarga");
    	
	    FileWriter f = null;
	    PrintWriter pw = null;
	    
    	List<EstadisticaConsulta> consultas = EstadisticasDAO.selectConsultas();
    	
    	if(consultas != null){    
		    try{
		    	 			    	
		    	f = new FileWriter("C:\\Repositorios\\Segovia\\Consultas.arff");
		    	pw = new PrintWriter(f);  	
		    	
		    	pw.println("@RELATION Consultas");
		    	pw.println("");
		    	pw.println("@ATTRIBUTE id NUMERIC");
		    	pw.println("@ATTRIBUTE rut STRING");
		    	pw.println("@ATTRIBUTE numero NUMERIC");
		    	pw.println("@ATTRIBUTE query STRING");
		    	pw.println("@ATTRIBUTE error STRING");
		    	pw.println("@ATTRIBUTE fecha DATE \"yyyy-MM-dd HH:mm:ss\"");
		    	pw.println("");
		    	pw.println("@DATA");
		    	for(EstadisticaConsulta e : consultas){
		    		pw.println(e.getId() + ",'" + e.getRut() + "'," + e.getNumero() + ",'" + e.getQuery() + "','" + e.getError() + "',\"" + e.getFecha() + "\"");
		    	}
		      	
		    }catch(Exception e){
		      	System.out.println("Error crear archivo de consultas -> " + e.getMessage());
		      	
		      	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al crear el archivo de estadisticas de consultas","");
	       		FacesContext.getCurrentInstance().addMessage(null, msg);
		    }finally{
		      	try{
		      		if(f != null)
		      			f.close();
		    	}catch(Exception e2){
		      		System.out.println("Error cerrar archivo de consultas -> " + e2.getMessage());
		      	}
		    }
    	}else{
    		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al cargar las estadisticas de las consultas","");
       		FacesContext.getCurrentInstance().addMessage(null, msg);
    	}
    	
    	List<EstadisticaRespuesta> respuestas = EstadisticasDAO.selectRespuestas();
    	
    	if(respuestas != null){    
		    try{
		    	 			    	
		    	f = new FileWriter("C:\\Repositorios\\Segovia\\Respuestas.arff");
		    	pw = new PrintWriter(f);  	
		    	
		    	pw.println("@RELATION Respuestas");
		    	pw.println("");
		    	pw.println("@ATTRIBUTE id NUMERIC");
		    	pw.println("@ATTRIBUTE rut STRING");
		    	pw.println("@ATTRIBUTE bd STRING");
		    	pw.println("@ATTRIBUTE fechaBd DATE \"yyyy-MM-dd HH:mm:ss\"");
		    	pw.println("@ATTRIBUTE ejercicio NUMERIC");
		    	pw.println("@ATTRIBUTE resultado {true,false}");
		    	pw.println("@ATTRIBUTE intento NUMERIC");
		    	pw.println("@ATTRIBUTE tiempoEjercicio DATE \"HH:mm:ss\"");
		    	pw.println("@ATTRIBUTE tiempoSesion DATE \"HH:mm:ss\"");
		    	pw.println("@ATTRIBUTE fecha DATE \"yyyy-MM-dd HH:mm:ss\"");
		    	pw.println("");
		    	pw.println("@DATA");
		    	for(EstadisticaRespuesta r : respuestas){
		    		pw.println(r.getId() + ",'" + r.getRut() + "','" + r.getBd() + "',\"" + r.getFechaBd() + "\"," + r.getEjercicio() + "," + r.isResultado() + "," + r.getIntento() + ",\"" + r.getTiempoEjercicio() + "\",\"" + r.getTiempoSesion() + "\",\"" + r.getFecha() + "\"");
		    	}
		      	
		    }catch(Exception e){
		      	System.out.println("Error crear archivo de respuestas -> " + e.getMessage());
		      	
		      	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al crear el archivo de estadisticas de respuestas","");
	       		FacesContext.getCurrentInstance().addMessage(null, msg);
		    }finally{
		      	try{
		      		if(f != null)
		      			f.close();
		    	}catch(Exception e2){
		      		System.out.println("Error cerrar archivo de respuestas -> " + e2.getMessage());
		      	}
		    }
    	}else{
    		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al cargar las estadisticas de las respuestas","");
       		FacesContext.getCurrentInstance().addMessage(null, msg);
    	}
    	
    	List<EstadisticaResultado> resultados = EstadisticasDAO.selectResultados();
    	
    	if(resultados != null){    
		    try{
		    	 			    	
		    	f = new FileWriter("C:\\Repositorios\\Segovia\\Resultados.arff");
		    	pw = new PrintWriter(f);  	
		    	
		    	pw.println("@RELATION Resultados");
		    	pw.println("");
		    	pw.println("@ATTRIBUTE id NUMERIC");
		    	pw.println("@ATTRIBUTE bd STRING");
		    	pw.println("@ATTRIBUTE fechaBd DATE \"yyyy-MM-dd HH:mm:ss\"");
		    	pw.println("@ATTRIBUTE cantEjercicios NUMERIC");
		    	pw.println("@ATTRIBUTE cantCorrectas NUMERIC");
		    	pw.println("@ATTRIBUTE cantErroneas NUMERIC");
		    	pw.println("@ATTRIBUTE cantOmitidas NUMERIC");
		    	pw.println("@ATTRIBUTE fecha DATE \"yyyy-MM-dd HH:mm:ss\"");
		    	pw.println("");
		    	pw.println("@DATA");
		    	for(EstadisticaResultado r : resultados){
		    		pw.println(r.getId() + ",'" + r.getBd() + "',\"" + r.getFechaBd() + "\"," + r.getCantEjercicios() + "," + r.getCantCorrectas() + "," + r.getCantErroneas() + "," + r.getCantOmitidas() + ",\"" + r.getFecha() + "\"");
		    	}
		      	
		    }catch(Exception e){
		      	System.out.println("Error crear archivo de resultados -> " + e.getMessage());
		      	
		      	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al crear el archivo de estadisticas de resultados","");
	       		FacesContext.getCurrentInstance().addMessage(null, msg);
		    }finally{
		      	try{
		      		if(f != null)
		      			f.close();
		    	}catch(Exception e2){
		      		System.out.println("Error cerrar archivo de resultados -> " + e2.getMessage());
		      	}
		    }
    	}else{
    		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al cargar las estadisticas de las resultados","");
       		FacesContext.getCurrentInstance().addMessage(null, msg);
    	}
    	
    	List<EstadisticaTodo> todos = EstadisticasDAO.selectTodo();
    	
    	if(todos != null){    
		    try{
		    	 			    	
		    	f = new FileWriter("C:\\Repositorios\\Segovia\\Todos.arff");
		    	pw = new PrintWriter(f);  	
		    	
		    	pw.println("@RELATION Todo");
		    	pw.println("");
		    	pw.println("@ATTRIBUTE idResultado NUMERIC");
		    	pw.println("@ATTRIBUTE bd STRING");
		    	pw.println("@ATTRIBUTE fechaBd DATE \"yyyy-MM-dd HH:mm:ss\"");		    	
		    	pw.println("@ATTRIBUTE cantEjercicios NUMERIC");
		    	pw.println("@ATTRIBUTE cantCorrectas NUMERIC");
		    	pw.println("@ATTRIBUTE cantErroneas NUMERIC");
		    	pw.println("@ATTRIBUTE cantOmitidas NUMERIC");
		    	pw.println("@ATTRIBUTE fechaResultado DATE \"yyyy-MM-dd HH:mm:ss\"");
		    	pw.println("@ATTRIBUTE idRespuesta NUMERIC");
		    	pw.println("@ATTRIBUTE rutAlumno STRING");
		    	pw.println("@ATTRIBUTE numeroEjercicio NUMERIC");
		    	pw.println("@ATTRIBUTE resultadoEjercicio {true,false}");
		    	pw.println("@ATTRIBUTE intentoEjercicio NUMERIC");
		    	pw.println("@ATTRIBUTE tiempoEjercicio DATE \"HH:mm:ss\"");
		    	pw.println("@ATTRIBUTE tiempoSesion DATE \"HH:mm:ss\"");
		    	pw.println("@ATTRIBUTE fechaEjercicio DATE \"yyyy-MM-dd HH:mm:ss\"");
		    	pw.println("@ATTRIBUTE idConsulta NUMERIC");
		    	pw.println("@ATTRIBUTE numeroConsulta NUMERIC");
		    	pw.println("@ATTRIBUTE query STRING");
		    	pw.println("@ATTRIBUTE errorQuery STRING");
		    	pw.println("@ATTRIBUTE fechaConsulta DATE \"yyyy-MM-dd HH:mm:ss\"");    	
		    	pw.println("");
		    	pw.println("@DATA");
		    	for(EstadisticaTodo t : todos){
		    		pw.println(t.getIdResultado() + ",'" + t.getBd() + "',\"" + t.getFechaBd() + "\"," + 
		    				t.getCantEjercicios() + "," + t.getCantCorrectas() + "," + 
		    				t.getCantErroneas() + "," + t.getCantOmitidas() + ",\"" + 
		    				t.getFechaResultado() + "\"," + t.getIdRespuesta() + ",'" + t.getRut() + "'," + 
		    				t.getEjercicio() + "," + t.isResultadoEjercicio() + "," + 
		    				t.getIntentoEjercicio() + ",\"" + t.getTiempoEjercicio() + "\",\"" + 
		    				t.getTiempoSesion() + "\",\"" + t.getFechaEjercicio() + "\"," + t.getIdConsulta() + "," +
		    				t.getNumeroConsulta() + ",'" + t.getQuery() + "','" + t.getErrorQuery() + "',\"" + 
		    				t.getFechaConsulta() + "\"");
		    	}
		      	
		    }catch(Exception e){
		      	System.out.println("Error crear archivo de todo -> " + e.getMessage());
		      	
		      	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al crear el archivo de todas las estadisticas","");
	       		FacesContext.getCurrentInstance().addMessage(null, msg);
		    }finally{
		      	try{
		      		if(f != null)
		      			f.close();
		    	}catch(Exception e2){
		      		System.out.println("Error cerrar archivo de todas las estadisticas -> " + e2.getMessage());
		      	}
		    }
    	}else{
    		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al cargar todas las estadisticas","");
       		FacesContext.getCurrentInstance().addMessage(null, msg);
    	}
    	
    	descargar = true;
    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Se han generado todas las Estadisticas","");
   		FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void descargarConsultas() throws IOException{
    	path = "C:\\Repositorios\\Segovia\\Consultas.arff";  
    	contentType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(path);
    	file = new DefaultStreamedContent(new FileInputStream(path), contentType, "Consultas.arff");
    }
    
    public void descargarResultados() throws IOException{
    	path = "C:\\Repositorios\\Segovia\\Resultados.arff";  
    	contentType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(path);
    	file = new DefaultStreamedContent(new FileInputStream(path), contentType, "Resultados.arff");
    }
    
    public void descargarRespuestas() throws IOException{
    	path = "C:\\Repositorios\\Segovia\\Respuestas.arff";  
    	contentType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(path);
    	file = new DefaultStreamedContent(new FileInputStream(path), contentType, "Respuestas.arff");
    }
    
    public void descargarTodo() throws IOException{
    	path = "C:\\Repositorios\\Segovia\\Todos.arff";  
    	contentType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(path);
    	file = new DefaultStreamedContent(new FileInputStream(path), contentType, "Todos.arff");
    }
    
}