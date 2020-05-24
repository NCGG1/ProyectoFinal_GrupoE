package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;

import java.io.IOException;
import java.util.ArrayList;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;

@Entity
@ManagedBean
public class Cliente extends Usuario{
private String numero;
private String nombreT;
private int cvv;
private boolean habilidado;
private String contrasenia;

public Cliente() {

}

public Cliente(String nombre, String apellido, String cedula, String departamento, String ciudad, String direccion, String numero, String nombreT, int cvv, String contrasenia) {
	this.habilidado= true;
	this.numero = numero;
	this.nombreT = nombreT;
	this.cvv = cvv;
	this.contrasenia = contrasenia;
}

public boolean isHabilidado() {
	return habilidado;
}

public void setHabilidado(boolean habilidado) {
	this.habilidado = habilidado;
}

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
	this.numero = numero;
}

public String getNombreT() {
	return nombreT;
}

public void setNombreT(String nombreT) {
	this.nombreT = nombreT;
}

public int getCvv() {
	return cvv;
}

public void setCvv(int cvv) {
	this.cvv = cvv;
}

public String getContrasenia() {
	return contrasenia;
}

public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}




@Override
public String toString() {
	return "Cliente [numero=" + numero + ", nombreT=" + nombreT + ", cvv=" + cvv + ", habilidado=" + habilidado
			+ ", contrasenia=" + contrasenia + ", getCompras()=" + getCompras() + ", getNombre()=" + getNombre()
			+ ", getApellido()=" + getApellido() + ", getCedula()=" + getCedula() + ", getDepartamento()="
			+ getDepartamento() + ", getCiudad()=" + getCiudad() + ", getDireccion()=" + getDireccion()
			+ ", getCorreo()=" + getCorreo() + "]";
}

public void algo() {
	
	FacesContext contexto = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) contexto.getExternalContext().getSession(true);
	
	ArrayList<Cliente> clientesAgregados = (ArrayList<Cliente>) session.getAttribute("clientesAgregados");
	
	boolean encontrarCedula = false; 
	boolean encontrarCorreo = false; 
	if(session.getAttribute("clientesAgregados")==null) {
		clientesAgregados =new ArrayList<Cliente>();
		
	}else {
		for (int i = 0; i < clientesAgregados.size(); i++) {
			if (clientesAgregados.get(i).getCedula().equalsIgnoreCase(this.getCedula())) {
				encontrarCedula = true;
			}
			if (clientesAgregados.get(i).getCorreo().equalsIgnoreCase(this.getCorreo())) {
				encontrarCorreo = true;
			}
			
		}
		
		
	}
	
	try {
		String msg = "error";
		if (encontrarCedula==false && encontrarCorreo==false) {
			clientesAgregados.add(this);
			msg = "¡ Bienvenido "+ this.getNombre()+", ahora estas registrado en el sistema !";
			session.setAttribute("mensajeRegistro", msg);
			session.setAttribute("clientesAgregados", clientesAgregados);
			PrimeFaces.current().executeScript("alert('"+msg+"');");
			contexto.getExternalContext().redirect("./index.xhtml");
			

		}else if (encontrarCorreo) {
			msg = "Ya hay una persona registrada con ese correo";
			
			
		}else
		{
			msg = "Ya hay una persona registrada con esa cédula";
			
		}
		
		session.setAttribute("mensajeRegistro", msg);
		PrimeFaces.current().executeScript("alert('"+msg+"');");
//		alert('"+msg+"');
//		PF('dlg3').show();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	session.setAttribute("clientesAgregados", clientesAgregados);
	
	
	

	mostrarClientes(clientesAgregados);
	
}

private void mostrarClientes(ArrayList<Cliente> clientesAgregados) {
	for (int i = 0; i < clientesAgregados.size(); i++) {
		System.out.println(clientesAgregados.get(i).toString());
	}
}

}
