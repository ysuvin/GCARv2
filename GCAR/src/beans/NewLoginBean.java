package beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.el.ELContext;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import util.EsquemaBean;
import util.UserBean;
import dao.EsquemaDAO;
import dao.UserDAO;

@ManagedBean(name = "newLoginBean")
public class NewLoginBean {

	private UserBean userBean;

	public UserBean getUserBean() {
		return userBean;
	}	

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String loginUser() {

		try {
			Calendar inicioSesion = new GregorianCalendar();

			ELContext elContext = FacesContext.getCurrentInstance().getELContext();

			System.out.println(elContext);
			userBean = (UserBean) FacesContext.getCurrentInstance().getApplication()
					.getELResolver().getValue(elContext, null, "userBean");

			System.out.println(userBean);

			userBean = UserDAO.login(userBean.getRut(), userBean.getPass());
			System.out.println(userBean);		

			if (userBean != null) {

				// get Http Session and store username
				HttpSession session = Util.getSession();				
				userBean.setInicioSesion(inicioSesion);


				session.setAttribute("rut", userBean.getRut());
				session.setAttribute("nombre", userBean.getNombre1());
				session.setAttribute("pass", userBean.getPass());
				session.setAttribute("tipo", userBean.getTipo());
				session.setAttribute("usuario", userBean);				

				FacesContext  context = FacesContext.getCurrentInstance();
				context.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Bienvenido " + userBean.getNombre1() + " " + userBean.getPaterno(),
								""));
				context.getExternalContext().getFlash().setKeepMessages(true);				

				return "home";

			} else {
				FacesContext  context = FacesContext.getCurrentInstance();
				context.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Datos inválidos. Por favor, intente denuevo.",""));
				context.getExternalContext().getFlash().setKeepMessages(true);
				HttpSession session = Util.getSession();
				session.invalidate();
				return "login";
			}
		} catch (Exception ex) {
			System.err.println("EXCEPTION IN LOGIN USER");
			ex.printStackTrace();
			return "login";
		}
	}

	
	public String logout() {

		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		UserBean userBean = (UserBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, "usuario");
		EsquemaDAO.borrarEsquemaLoad(userBean.getRut());

		HttpSession session = Util.getSession();
		session.setAttribute("userBean", null);
		session.invalidate();
		return "login";
	}	

	public void isAdmin(ComponentSystemEvent event){
		HttpSession session = Util.getSession();
		if ((Integer)session.getAttribute("tipo") != 1){
			FacesContext fc = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)
					fc.getApplication().getNavigationHandler();
			nav.performNavigation("error");
		}
	}

	public void isAlumno(ComponentSystemEvent event){
		HttpSession session = Util.getSession();
		if ((Integer)session.getAttribute("tipo") != 2){
			FacesContext fc = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)
					fc.getApplication().getNavigationHandler();
			nav.performNavigation("error");
		}
	}

	public void loadBD(ComponentSystemEvent event){
		HttpSession session = Util.getSession();
		if ((EsquemaBean)session.getAttribute("bd") == null){
			FacesContext fc = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)
					fc.getApplication().getNavigationHandler();
			nav.performNavigation("error");
		}
	}

	public void isMyBd(ComponentSystemEvent event){
		HttpSession session = Util.getSession();
		EsquemaBean bd = (EsquemaBean)session.getAttribute("bd");
		UserBean user = (UserBean)session.getAttribute("usuario");
		if(user.getTipo() == 2 && !user.getRut().equals(bd.getRut())){
			FacesContext fc = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)
					fc.getApplication().getNavigationHandler();
			nav.performNavigation("error");
		}
	}

	//EL SIGUIENTE EVENTO NOS PERMITE LLAMAR AL METODO ISADMIN() DESDE
	// UN XHTML PARA MOSTRAR LA PAGINA SI CORRESPONDE AL ADMINISTRADOR -->
	//<f:event listener="#{userBean.isAdmin}" type="preRenderView" />	

	public String registrarse(){
		return "registrarse";
	}
}
