package co.edu.unbosque.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario  implements Serializable {   
       
	private String nombre;         
	private String apellido;         
	private String cedula; 
	private String correo;
	private String departamento;         
	private String ciudad;         
	private String direccion;
	ArrayList<Producto> compras;
	private static final long serialVersionUID = 1L;

	public Usuario(String nombre, String apellido, String cedula, String correo, String departamento, String ciudad,
			String direccion) {
		super();
		this.compras = new ArrayList<Producto>();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.correo = correo;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}

	public Usuario() {}

	
	public ArrayList<Producto> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Producto> compras) {
		this.compras = compras;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Id
	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
   
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) o;
		return true
			&& (getNombre() == null ? other.getNombre() == null : getNombre().equals(other.getNombre()))
			&& (getApellido() == null ? other.getApellido() == null : getApellido().equals(other.getApellido()))
			&& (getCedula() == null ? other.getCedula() == null : getCedula().equals(other.getCedula()))
			&& (getDepartamento() == null ? other.getDepartamento() == null : getDepartamento().equals(other.getDepartamento()))
			&& (getCiudad() == null ? other.getCiudad() == null : getCiudad().equals(other.getCiudad()))
			&& (getDireccion() == null ? other.getDireccion() == null : getDireccion().equals(other.getDireccion()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getNombre() == null ? 0 : getNombre().hashCode());
		result = prime * result + (getApellido() == null ? 0 : getApellido().hashCode());
		result = prime * result + (getCedula() == null ? 0 : getCedula().hashCode());
		result = prime * result + (getDepartamento() == null ? 0 : getDepartamento().hashCode());
		result = prime * result + (getCiudad() == null ? 0 : getCiudad().hashCode());
		result = prime * result + (getDireccion() == null ? 0 : getDireccion().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", correo=" + correo
				+ ", departamento=" + departamento + ", ciudad=" + ciudad + ", direccion=" + direccion + ", compras="
				+ compras + "]";
	}
	
	
	
   
   
}
