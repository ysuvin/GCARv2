package weka.api;


//CODIGO DE PRUEBA



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;

import weka.associations.Apriori;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;



@ManagedBean(name="dtAnalisisBean")
@ViewScoped
public class AnalisisBean implements Serializable{

	/**
	   * Espera un conjunto de datos como primer parámetro. Se utiliza el áltimo atributo
	   * como atributo de clase.
	   *
	   * @param argumenta los parámetros de la lánea de comandos
	   * @throws Excepcián si algo sale mal
	   */

	  public void apriori(String[] args) throws Exception {
	    // cargar datos
	    Instances data = DataSource.read(args[0]); // falta direcion del dataset dentro de la app
	    data.setClassIndex(data.numAttributes() - 1);

	    // construir asociacion
	    Apriori apriori = new Apriori();
	    apriori.setClassIndex(data.classIndex());
	    apriori.buildAssociations(data);

	    // salida asociacion
	    System.out.println(apriori); // enviar datos a vista estadisticas
	  }
	
	
	
	
	
	
	
	
	
	
	
}
