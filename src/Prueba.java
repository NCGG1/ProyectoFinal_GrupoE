import java.io.Serializable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;


@ManagedBean
public class Prueba{
     
    private String[] lista;
	public Prueba() {
		lista = new String[]{"mainrca", "maincra", "maincra2", "elbueeno","La maravillosa prueba 2", "Supercalifragilisticoespialidoso",
				"mainrca", "maincra", "maincra2", "elbueeno","La maravillosa prueba 2", "Supercalifragilisticoespialidoso",
		"mainrca", "maincra", "maincra2", "elbueeno","La maravillosa prueba 2", "Supercalifragilisticoespialidoso"};
	}
	public String[] getLista() {
		return lista;
	}
	public void setLista(String[] lista) {
		this.lista = lista;
	}
	
	
	
}
