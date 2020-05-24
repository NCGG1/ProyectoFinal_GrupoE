package co.edu.unbosque.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Usuario;

@RequestScoped
@ManagedBean
@FacesValidator("verificarLogin")
public class LoginBean implements Validator{
	
	/**
	 * Estos son los atributos de la clase Loginbean usados para realizar la
	 * validacion de los mismo al momento de iniciar sesion
	 */
	private String usuario;
	private String contraseña;

	/**
	 * Este es el metodo constructoer de la clase LoginBean
	 */
	public LoginBean() {

	}

	/**
	 * Este metodo se encarga de retornar el nombre de usuario del usuario que se
	 * esta registrando
	 * 
	 * @return
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Este metodo se encarga de cambiar el nombre de usuario por uno pasado por
	 * parametro
	 * 
	 * @param usuario Es el nuevo nombre de usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Este metodos e encarga de retornar la contraseña del usuario
	 * 
	 * @return contraseña Es la contraseña del usuario
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Este metodo se encarga de cambiar la contraseña del usuario por una pasada
	 * por parametro
	 * 
	 * @param contraseña La nueva contraseña del usuario
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	public void red() {
		System.out.println(this.usuario+" "+contraseña);
	}

	/**
	 * Este metodo se encarga de leer la base de datos de usuarios y retornar un
	 * arrayList con todos los usaurios registrados en la misma <b>pre</b> Tener una
	 * conexion a internet y que se haya cargado la pagina web correctamente
	 * <b>post</b> Cargar en un arraylist a todos los usuarios registrados en la
	 * base de datos
	 * 
	 * @return usuarios Es el arrayList con todos los usuarios registrados y
	 *         guardados en la base de datos
	 */
	public ArrayList<Cliente> doComparar() {

		ArrayList<Cliente> clientes = null;
		try {
			

			clientes = new ArrayList<Cliente>();
			
			//Aqui realizar persistencia
			FacesContext contexto = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) contexto.getExternalContext().getSession(true);
			
			clientes = (ArrayList<Cliente>) session.getAttribute("clientesAgregados");
			
			boolean encontrarCedula = false; 
			boolean encontrarCorreo = false; 
			if(session.getAttribute("clientesAgregados")==null) {
				clientes =new ArrayList<Cliente>();
				
			}else {
				System.out.println(usuario+" "+contraseña);
				boolean bandera = false;
				for (int i = 0; i < clientes.size(); i++) {
					if (clientes.get(i).getCorreo().equalsIgnoreCase(usuario)) {

						if (clientes.get(i).getContrasenia().equalsIgnoreCase(contraseña)) {
							bandera = true;
							
							session.setAttribute("log", clientes.get(i));

						}

					}
				}
				if (!bandera) {
					
					FacesContext.getCurrentInstance().addMessage(null,
			                new FacesMessage("Usuario o contraseña incorrecta"));
				} else {
					try {
						System.out.println("entro");
						contexto.getExternalContext().redirect("Principal.xhtml");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return clientes;

		

	}

	
	@Override
	public void validate(FacesContext context, UIComponent component, Object valor) throws ValidatorException {

		String contra = (String) component.getAttributes().get("contraseña");
		
		String param = valor.toString();

		FacesContext elcontexto = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) elcontexto.getExternalContext().getSession(true);

		ArrayList<Cliente> clientes = doComparar();

		if (clientes == null) {
			clientes = new ArrayList<Cliente>();
		}
		
	}
}
